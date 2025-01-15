package com.westeros.moviesclient;

import com.westeros.moviesclient.contract.Dictionaries;

import java.util.List;

public interface IMoviesDictionariesClient {

    List<Dictionaries.LanguageDto> getLanguages();
    List<Dictionaries.GenreDto> getGenres();
    List<Dictionaries.CountryDto> getCountries();
}
