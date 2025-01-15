package com.westeros.data.repositories;

public interface ICatalogData {
    CompanyRepository getCompanies();
    MoviesRepository getMovies();
    ActorRepository getActors();
    CharacterRepository getCharacter();
    CountryRepository getCountries();
    GenreRepository getGenres();
    LanguageRepository getLanguages();

}
