package com.westeros.webapi.services.mappers;

import com.westeros.data.model.Movie;
import com.westeros.webapi.contract.MovieDto;
import com.westeros.webapi.contract.MovieSummaryDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Getter
@Accessors
public class Mappers implements IMappers{

     private final IMap<MovieDto, Movie> movieDtoToEntityMapper;

    private final IMap<Movie, MovieSummaryDto> movieToSummaryDtoMapper;
    private final IMap<Movie, MovieDto> movieToDtoMapper;
}
