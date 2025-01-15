package com.westeros.webapi.services;

import com.westeros.data.model.Actor;
import com.westeros.data.model.ActorRole;
import com.westeros.data.model.Language;
import com.westeros.data.repositories.ICatalogData;
import com.westeros.webapi.contract.ActorCharacterDto;
import com.westeros.webapi.contract.LanguageDto;
import com.westeros.webapi.contract.MovieDto;
import com.westeros.webapi.contract.MovieSummaryDto;
import com.westeros.webapi.services.mappers.Mappers;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService implements IMovieService{
    private final ICatalogData db;
    private final Mappers mappers;

    @Override
    public long saveMovie(MovieDto dto) {
        var movieEntity = mappers.getMovieDtoToEntityMapper().map(dto);
        db.getMovies().save(movieEntity);
        return movieEntity.getId();
    }
    public List<MovieSummaryDto> getAllMovies(){
        return db.getMovies().findAll().stream().map(x->mappers.getMovieToSummaryDtoMapper().map(x)).toList();
    }
    public MovieDto getMovie(long id){
        var entity = db.getMovies().findById(id).orElse(null);
        if(entity == null) return null;
        return mappers.getMovieToDtoMapper().map(entity);
    }
    public void deleteMovieById(long id){
        db.getMovies().deleteById(id);
    }
    public long updateMovie(long id, MovieDto movieDto){
        movieDto.setId(id);
        db.getMovies().save(mappers.getMovieDtoToEntityMapper().map(movieDto));
        return id;
    }
    public List<ActorCharacterDto> getActorsInMovie(long id){
        var actors = db.getCharacter().getActorsFromMovie(id);
        return actors.stream().map(this::mapActorCharacterdto).toList();
    }
    public List<LanguageDto> getLanguagaes(){
        var languages = db.getLanguages().findAll();
        return languages.stream().map(this::mapLanguageDto).toList();
    }

    public long saveActor(ActorCharacterDto actorCharacterDto, long id) {
        var actor = new Actor();
        actor.setName(actorCharacterDto.getActorName());
        var characterRole = new ActorRole();
        characterRole.setName(actorCharacterDto.getCharacterName());
        var movie = db.getMovies().findById(id).orElse(null);
        movie.getCharacters().add(characterRole);
        db.getMovies().save(movie);
        characterRole.setMovie(movie);
        actor.getCharacters().add(characterRole);
        characterRole.setActor(actor);
        db.getActors().save(actor);
        return actor.getId();
    }
    //Dto mappers
    private ActorCharacterDto mapActorCharacterdto(ActorRole characterRole){
        var actorCharacter = new ActorCharacterDto();
        actorCharacter.setActorName(characterRole.getActor().getName());
        actorCharacter.setCharacterName(characterRole.getName());
        return actorCharacter;
    }
    private LanguageDto mapLanguageDto(Language spokenLanguage){
        var languageDto = new LanguageDto();
        languageDto.setId(spokenLanguage.getId());
        languageDto.setName(spokenLanguage.getName());
        return languageDto;
    }
}