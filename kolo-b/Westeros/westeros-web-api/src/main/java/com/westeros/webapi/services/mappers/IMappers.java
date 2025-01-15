package com.westeros.webapi.services.mappers;

import com.westeros.data.model.Movie;
import com.westeros.webapi.contract.MovieDto;
import com.westeros.webapi.contract.MovieSummaryDto;

public interface IMappers {

    IMap<MovieDto, Movie> getMovieDtoToEntityMapper();
    IMap<Movie, MovieSummaryDto> getMovieToSummaryDtoMapper();
    IMap<Movie, MovieDto> getMovieToDtoMapper();
}
