package com.westeros.moviesclient;

import com.westeros.moviesclient.contract.Dictionaries;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
public class MoviesDictionariesClient implements IMoviesDictionariesClient{

    RestTemplate restClient;
    String baseUrl;
    String apiKey;
    int version;
    private final IMoviesClientUriBuilderProvider settings;

    public MoviesDictionariesClient(IMoviesClientUriBuilderProvider settings) {
        restClient = new RestTemplate();
        this.baseUrl=settings.host();
        this.apiKey= settings.apiKey();
        this.version= settings.apiVersion();
        this.settings=settings;
    }

    @Override
    public List<Dictionaries.LanguageDto> getLanguages() {
        String url = settings.builder()
                .pathSegment("configuration", "languages")
                .build()
                .toUriString();
        return restClient.exchange(url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<ArrayList<Dictionaries.LanguageDto>>() {})
                .getBody();
    }

    @Override
    public List<Dictionaries.GenreDto> getGenres() {
        String url = settings.builder()
                .pathSegment("genre", "movie", "list")
                .build()
                .toUriString();
        return restClient.getForObject(url, GenresResponseDto.class).genres();
    }

    record GenresResponseDto(List<Dictionaries.GenreDto> genres){}

    @Override
    public List<Dictionaries.CountryDto> getCountries() {
        String url = settings.builder()
                .pathSegment("configuration", "countries")
                .build()
                .toUriString();
        return restClient.exchange(url,
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<ArrayList<Dictionaries.CountryDto>>() {})
                .getBody();
    }
}
