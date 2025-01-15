package com.westeros.movies.mappers;

import com.westeros.data.model.*;
import com.westeros.moviesclient.contract.ActorDto;
import com.westeros.moviesclient.contract.CreditsDto;
import com.westeros.moviesclient.contract.Dictionaries;
import com.westeros.moviesclient.contract.MovieDto;

public interface ICatalogMappers {
    IMapEntities<ActorDto, Actor> forActor();

    IMapEntities<CreditsDto.ActorSummaryDto, ActorRole> forCharacter();

    IMapEntities<MovieDto.CompanySummaryDto, Company> forCompany();

    IMapEntities<Dictionaries.CountryDto, Country> forCountry();

    IMapEntities<Dictionaries.GenreDto, Genre> forGenre();

    IMapEntities<Dictionaries.LanguageDto, Language> forLanguage();

    IMapEntities<MovieDto, Movie> forMovie();
}
