package com.westeros.moviesclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class MoviesClientConfig {


    @Bean
    public IMoviesClientUriBuilderProvider MoviesClientUriBuilderProvider(
            @Value("${themoviedb.api.key}") String apiKey,
            @Value("${themoviedb.api.host}") String host,
            @Value("${themoviedb.api.version}") int apiVersion){
        return new MoviesClientUriBuilderProvider(apiKey, host, apiVersion);
    }
    @Bean
    @Scope("prototype")
    public MoviesClient moviesClient(IMoviesClientUriBuilderProvider uriBuilderProvider) {
        return new MoviesClient(uriBuilderProvider);
    }
}
