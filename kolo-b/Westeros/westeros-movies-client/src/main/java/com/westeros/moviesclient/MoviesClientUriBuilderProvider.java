package com.westeros.moviesclient;

import org.springframework.beans.factory.annotation.Value;

public record MoviesClientUriBuilderProvider(String apiKey, String host,
                                             int apiVersion) implements IMoviesClientUriBuilderProvider {
    /**
     * adnotacja @Value służy do odczytywania wartości z pliku application.properties
     * docs. https://www.baeldung.com/spring-value-annotation
     *
     * @param apiKey
     * @param host
     * @param apiVersion
     */
    public MoviesClientUriBuilderProvider(
            @Value("${themoviedb.api.key}") String apiKey,
            @Value("${themoviedb.api.host}") String host,
            @Value("${themoviedb.api.version}") int apiVersion) {

        this.apiKey = apiKey;
        this.host = host;
        this.apiVersion = apiVersion;
    }
}
