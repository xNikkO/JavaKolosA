package com.westeros.movies.mappers;

import com.westeros.data.model.Movie;
import com.westeros.moviesclient.contract.MovieDto;
import org.springframework.stereotype.Component;

@Component
public class MovieMapper implements IMapEntities<MovieDto, Movie>{
    @Override
    public Movie map(MovieDto movieDto) {
        return map(movieDto, new Movie());
    }

    @Override
    public Movie map(MovieDto movieDto, Movie movie) {
        movie.setAdult(movieDto.adult());
        movie.setBudget(movieDto.budget());
        movie.setBackdropPath(movieDto.backdropPath());
        movie.setHomepage(movieDto.homepage());
        movie.setOriginalLanguage(movieDto.originalLanguage());
        movie.setOriginalTitle(movieDto.originalTitle());
        movie.setOverview(movieDto.overview());
        movie.setPopularity(movieDto.popularity());
        movie.setPosterPath(movieDto.posterPath());
        movie.setReleaseDate(movieDto.releaseDate());
        movie.setRuntime(movieDto.runtime());
        movie.setVoteCount(movieDto.voteCount());
        movie.setVoteAverage(movieDto.voteAverage());
        movie.setSourceId(movieDto.id());
        return movie;
    }
}
