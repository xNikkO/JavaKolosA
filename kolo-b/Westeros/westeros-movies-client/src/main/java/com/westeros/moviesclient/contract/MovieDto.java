package com.westeros.moviesclient.contract;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.util.List;

public record MovieDto(
         int id,
         boolean adult,
         @JsonProperty("backdrop_path") String backdropPath,
         int budget,
         List<Dictionaries.GenreDto> genres,
         String homepage,
         @JsonProperty("original_language") String originalLanguage,
         @JsonProperty("original_title") String originalTitle,
         String overview,
         double popularity,
         @JsonProperty("poster_path") String posterPath,
         @JsonProperty("production_companies") List<CompanySummaryDto> productionCompanies,
         @JsonProperty("production_countries") List<Dictionaries.CountryDto> productionCountries,
         @JsonProperty("release_date") LocalDate releaseDate,
         int runtime,
         @JsonProperty("spoken_languages") List<Dictionaries.LanguageDto> spokenLanguages,
         @JsonProperty("vote_count") int voteCount,
         @JsonProperty("vote_average") double voteAverage
        
) {

    public record CompanySummaryDto(int id,
                                    @JsonProperty("logo_path") String logoPath,
                                    String name,
                                    @JsonProperty("origin_country") String originCountry){}
}
