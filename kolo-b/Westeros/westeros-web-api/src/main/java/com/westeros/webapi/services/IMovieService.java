package com.westeros.webapi.services;

import com.westeros.webapi.contract.ActorCharacterDto;
import com.westeros.webapi.contract.LanguageDto;
import com.westeros.webapi.contract.MovieDto;
import com.westeros.webapi.contract.MovieSummaryDto;

import java.util.List;

public interface IMovieService {

    long saveMovie(MovieDto dto);
    List<MovieSummaryDto> getAllMovies();
    MovieDto getMovie(long id);
    void deleteMovieById(long id);
    long updateMovie(long id, MovieDto movieDto);
    List<ActorCharacterDto> getActorsInMovie(long id);
    List<LanguageDto> getLanguagaes();
    long saveActor(ActorCharacterDto actorCharacterDto, long id);
}
