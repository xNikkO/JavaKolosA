package com.westeros.movies.updater;


import com.westeros.data.model.Company;
import com.westeros.data.model.IHaveDictionaryName;
import com.westeros.data.model.Movie;
import com.westeros.data.repositories.ICatalogData;
import com.westeros.movies.mappers.ICatalogMappers;
import com.westeros.movies.mappers.IMapEntities;
import com.westeros.moviesclient.IMoviesClient;
import com.westeros.moviesclient.IMoviesDictionariesClient;
import com.westeros.moviesclient.contract.CreditsDto;
import com.westeros.moviesclient.contract.IHaveName;
import com.westeros.moviesclient.contract.MovieDto;
import com.westeros.moviesclient.contract.PagedResultDto;
import jakarta.transaction.Transactional;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

@Service
@Transactional
public class MoviesUpdater implements IUpdateMovies{

    private final ICatalogData data;
    private final IMoviesClient moviesClient;
    private final IMoviesDictionariesClient dictionariesClient;
    private final ICatalogMappers entityMapper;

    public MoviesUpdater(ICatalogData dbCatalog,
                         IMoviesClient moviesClient,
                         IMoviesDictionariesClient dictionariesClient,
                         ICatalogMappers entityMapper) {
        this.data = dbCatalog;
        this.moviesClient = moviesClient;
        this.dictionariesClient = dictionariesClient;
        this.entityMapper = entityMapper;
    }

    @Async
    @Override
    public void updateByDateRange(LocalDate from, LocalDate to) {

        updateDictionaries();
        List<Long> sourceIds = getSourceIds(from, to);
        var moviesDto = sourceIds.stream().map(moviesClient::getMovie).toList();
        var creditsDto = sourceIds.stream().map(moviesClient::getCredits).filter(x->x!=null).toList();
        ArrayList<Long> actorsSourceIds = getActorsSourceIds(creditsDto);
        var actorsFromDb = data.getActors().withSourceIds(actorsSourceIds);
        actorsFromDb.forEach(x->actorsSourceIds.remove((long)x.getSourceId()));
        var actorsDto = actorsSourceIds.stream().map(moviesClient::getActorDetails).toList();
        var actorsToSave = new ArrayList<>(actorsDto.stream().map(dto -> entityMapper.forActor().map(dto)).toList());
        actorsToSave.addAll(actorsFromDb);

        var companiesSourceIds = moviesDto.stream().flatMap(x->x.productionCompanies().stream())
                .map(x->x.id()).distinct().toList();

        var companiesToSave = data.getCompanies().withSourceIds(companiesSourceIds);
        var companySourceIdsToIgnore = companiesToSave.stream().map(x->x.getSourceId()).toList();
        var companiesDto = moviesDto.stream()
                .filter(dto->dto.productionCompanies()!=null)
                .flatMap(m->m.productionCompanies()
                        .stream()
                        .filter(Predicate.not(c->companySourceIdsToIgnore.contains(c.id()))));
        var newCompanies = companiesDto.map(x->entityMapper.forCompany().map(x)).toList();
        companiesToSave.addAll(newCompanies);
        data.getCompanies().saveAll(companiesToSave);
        var newMoviesToSave = moviesDto.stream().map(dto-> entityMapper.forMovie().map(dto)).toList();
        data.getMovies().saveAll(newMoviesToSave);
        newMoviesToSave.forEach(movie->prepareMovieToSave(moviesDto, companiesToSave, movie));
        data.getMovies().saveAll(newMoviesToSave);
        data.getActors().saveAll(actorsToSave);

        for (var credits: creditsDto){
            for(var role: credits.cast()){
                var character = entityMapper.forCharacter().map(role);
                character.setActor(actorsToSave.stream().filter(actor->actor.getSourceId()==role.id()).findFirst().orElse(null));
                character.setMovie(newMoviesToSave.stream().filter(x->x.getSourceId()== credits.id()).findFirst().orElse(null));
                data.getCharacter().save(character);
            }
        }
    }

    private void prepareMovieToSave(List<MovieDto> moviesDto, List<Company> companiesToSave, Movie movie) {
        var dto = moviesDto.stream().filter(x->x.id()== movie.getSourceId()).findFirst().orElse(null);
        if(dto==null) return;
        var companySourceIds = new ArrayList<Integer>();
        if(dto.productionCompanies()!=null)
             companySourceIds =new ArrayList<>( dto.productionCompanies().stream().map(x->x.id()).toList());
        var genres = data.getGenres().WithSourceIdsIn(dto.genres().stream().map(g->g.id()).toList());
        var countries = data.getCountries().withNames(dto.productionCountries()
                .stream()
                .map(x->x.name())
                .toList());
        var languages = data.getLanguages().withNames(dto.spokenLanguages()
                .stream()
                .map(x->x.getName())
                .toList());
        ArrayList<Integer> finalCSourceIds = companySourceIds;
        var moviesCompanies = companiesToSave.stream().filter(x-> finalCSourceIds.contains(x.getSourceId())).toList();
        movie.getProductionCompanies().addAll(moviesCompanies);
        moviesCompanies.forEach(x->x.getMovies().add(movie));
        movie.getGenres().addAll(genres);
        genres.forEach(g->g.getMovies().add(movie));
        movie.getProductionCountries().addAll(countries);
        countries.forEach(c->c.getMovies().add(movie));
        movie.getSpokenLanguages().addAll(languages);
        languages.forEach(x->x.getMovies().add(movie));
    }

    private static ArrayList<Long> getActorsSourceIds(List<CreditsDto> creditsDto) {
        var actorsSourceIds = new ArrayList<>(creditsDto.stream()
                .flatMap(x -> x.cast().stream())
                .map(CreditsDto.ActorSummaryDto::id)
                .distinct().toList());
        return actorsSourceIds;
    }

    private List<Long> getSourceIds(LocalDate from, LocalDate to) {
        var result = moviesClient.getByDateRange(from, to);
        List<Long> sourceIds = new ArrayList<>();
        for(var page =1; page<= result.totalPages(); page++){
            sourceIds.addAll(moviesClient.getByDateRange(from, to, page)
                    .movies()
                    .stream()
                    .map(PagedResultDto.MovieSummaryDto::id)
                    .toList());
        }
        var sourceIdsToIgnore = data.getMovies().getSourceIdsIn(sourceIds);
        sourceIdsToIgnore.forEach(sourceIds::remove);
        return sourceIds;
    }

    private void updateDictionaries(){

        var languagesDto = dictionariesClient.getLanguages();
        var countriesDto = dictionariesClient.getCountries();
        var genresDto = dictionariesClient.getGenres();
        var languages = data.getLanguages().findAll();
        var countries = data.getCountries().findAll();
        var genres = data.getGenres().findAll();

        SaveNewDictionaries(languagesDto, languages, entityMapper.forLanguage(), entity->data.getLanguages().save(entity));
        SaveNewDictionaries(countriesDto, countries, entityMapper.forCountry(), entity->data.getCountries().save(entity));
        SaveNewDictionaries(genresDto, genres, entityMapper.forGenre(), entity-> data.getGenres().save(entity));
    }

    private <TDto extends IHaveName, TEntity extends IHaveDictionaryName> void SaveNewDictionaries(List<TDto> dtos,
                                                                                                   List<TEntity> entities,
                                                                                                   IMapEntities<TDto, TEntity> mapper,
                                                                                                   Consumer<TEntity> saveAction){
        dtos.stream()
                .filter(Predicate.not(
                        dto-> entities
                                .stream()
                                .anyMatch(entity->entity.getName().equals(dto.getName()))))
                .forEach(dto->saveAction.accept(mapper.map(dto)));
    }


}
