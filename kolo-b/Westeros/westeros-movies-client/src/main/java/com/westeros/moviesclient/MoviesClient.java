package com.westeros.moviesclient;

import com.westeros.moviesclient.contract.*;
import com.westeros.moviesclient.contract.ActorDto;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

public class MoviesClient implements IMoviesClient {

    RestTemplate restClient;

    IMoviesClientUriBuilderProvider provider;
    public MoviesClient(IMoviesClientUriBuilderProvider provider) {
        restClient = new RestTemplate();
        this.provider=provider;
    }

    @Override
    public PagedResultDto getByDateRange(LocalDate from, LocalDate to) {

        var uri = provider.builder()
                .pathSegment("discover", "movie")
                .queryParam("primary_release_date.gte", from)
                .queryParam("primary_release_date.lte", to)
                .toUriString();

        return restClient.getForEntity(uri, PagedResultDto.class).getBody();
    }

    @Override
    public PagedResultDto getByDateRange(LocalDate from, LocalDate to, int page) {
        var uri = provider.builder()
                .pathSegment("discover", "movie")
                .queryParam("primary_release_date.gte", from)
                .queryParam("primary_release_date.lte", to)
                .queryParam("page", page)
                .toUriString();
        return restClient.getForEntity(uri, PagedResultDto.class).getBody();
    }

    @Override
    public MovieDto getMovie(long id) {
        String url = provider.builder()
                .pathSegment("movie")
                .pathSegment(""+id)
                .build()
                .toUriString();
        var response = restClient.getForEntity(url, MovieDto.class).getBody();
        return response;
    }

    @Override
    public CreditsDto getCredits(long id) {
        var url = provider
                .builder()
                .pathSegment("movie", id+"", "credits")
                .toUriString();
        return restClient.getForEntity(url, CreditsDto.class).getBody();
    }

    @Override
    public ActorDto getActorDetails(long id) {

        var url = provider.builder()
                .pathSegment("person", id+"")
                .toUriString();
        return restClient.getForEntity(url, ActorDto.class).getBody();
    }
}
