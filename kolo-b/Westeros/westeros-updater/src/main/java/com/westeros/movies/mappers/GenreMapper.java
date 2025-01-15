package com.westeros.movies.mappers;

import com.westeros.data.model.Genre;
import com.westeros.moviesclient.contract.Dictionaries;
import org.springframework.stereotype.Component;

@Component
public class GenreMapper implements IMapEntities<Dictionaries.GenreDto, Genre>{
    @Override
    public Genre map(Dictionaries.GenreDto genreSummaryDto) {
        return map(genreSummaryDto, new Genre());
    }

    @Override
    public Genre map(Dictionaries.GenreDto genreSummaryDto, Genre genre) {
        genre.setName(genreSummaryDto.name());
        genre.setSourceId(genreSummaryDto.id());
        return genre;
    }
}
