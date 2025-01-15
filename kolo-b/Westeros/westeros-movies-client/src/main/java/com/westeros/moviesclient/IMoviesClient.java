package com.westeros.moviesclient;

import com.westeros.moviesclient.contract.*;
import com.westeros.moviesclient.contract.ActorDto;

import java.time.LocalDate;

public interface IMoviesClient {

    /**
     * Zwraca liste skróconych informacji o filmach które wyszły w podanym zakresie czasu
     * docs: https://developers.themoviedb.org/3/discover/movie-discover
     * endpoint: discover/movie?primary_release_date.gte=2014-09-15&primary_release_date.lte=2014-10-22 (to jest tylko przykład)
     * @param from data od
     * @param to data do
     * @return
     */
    PagedResultDto getByDateRange(LocalDate from, LocalDate to);

    /**
     * j.w. ale dodatkowo w parametrze przyjmuje nr strony wyników
     *
     * @param from data od
     * @param to data do
     * @param page nr strony
     * @return
     */
    PagedResultDto getByDateRange(LocalDate from, LocalDate to, int page);

    /**
     * Zwraca dokładne informacje o filmie o zadanym id.
     *
     * docs: https://developers.themoviedb.org/3/movies/get-movie-details
     * @param id id filmu
     * @return film
     */
    MovieDto getMovie(long id);

    /**
     * zwraca informacje o aktorach i zalodze, która brała udział przy tworzeniu filmu o zadanym id
     *
     * docs: https://developers.themoviedb.org/3/movies/get-movie-credits
     * @param id
     * @return
     */
    CreditsDto getCredits(long id);

    /**
     * Zwraca szczegółowe informacje o aktorze o zadanym id
     *
     * docs: https://developers.themoviedb.org/3/people/get-person-details
     * @param id id aktora
     * @return informacje o aktorze
     */
    ActorDto getActorDetails(long id);
}
