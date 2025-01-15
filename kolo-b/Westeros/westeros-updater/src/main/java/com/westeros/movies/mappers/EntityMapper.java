package com.westeros.movies.mappers;

import com.westeros.data.model.*;
import com.westeros.moviesclient.contract.ActorDto;
import com.westeros.moviesclient.contract.CreditsDto;
import com.westeros.moviesclient.contract.Dictionaries;
import com.westeros.moviesclient.contract.MovieDto;
import org.springframework.stereotype.Component;

@Component
public class EntityMapper implements ICatalogMappers {

    private final IMapEntities<ActorDto, Actor> forActor;
    private final IMapEntities<CreditsDto.ActorSummaryDto, ActorRole> forCharacter;
    private final IMapEntities<MovieDto.CompanySummaryDto, Company> forCompany;
    private final IMapEntities<Dictionaries.CountryDto, Country> forCountry;
    private final IMapEntities<Dictionaries.GenreDto, Genre> forGenre;
    private final IMapEntities<Dictionaries.LanguageDto, Language> forLanguage;
    private final IMapEntities<MovieDto, Movie> forMovie;

    public EntityMapper(IMapEntities<ActorDto, Actor> forActor, IMapEntities<CreditsDto.ActorSummaryDto, ActorRole> forCharacter, IMapEntities<MovieDto.CompanySummaryDto, Company> forCompany, IMapEntities<Dictionaries.CountryDto, Country> forCountry, IMapEntities<Dictionaries.GenreDto, Genre> forGenre, IMapEntities<Dictionaries.LanguageDto, Language> forLanguage, IMapEntities<MovieDto, Movie> forMovie) {
        this.forActor = forActor;
        this.forCharacter = forCharacter;
        this.forCompany = forCompany;
        this.forCountry = forCountry;
        this.forGenre = forGenre;
        this.forLanguage = forLanguage;
        this.forMovie = forMovie;
    }

    @Override
    public IMapEntities<ActorDto, Actor> forActor() {
        return forActor;
    }

    @Override
    public IMapEntities<CreditsDto.ActorSummaryDto, ActorRole> forCharacter() {
        return forCharacter;
    }

    @Override
    public IMapEntities<MovieDto.CompanySummaryDto, Company> forCompany() {
        return forCompany;
    }

    @Override
    public IMapEntities<Dictionaries.CountryDto, Country> forCountry() {
        return forCountry;
    }

    @Override
    public IMapEntities<Dictionaries.GenreDto, Genre> forGenre() {
        return forGenre;
    }

    @Override
    public IMapEntities<Dictionaries.LanguageDto, Language> forLanguage() {
        return forLanguage;
    }

    @Override
    public IMapEntities<MovieDto, Movie> forMovie() {
        return forMovie;
    }
}
