package com.westeros.moviesclient;

import org.springframework.web.util.UriComponentsBuilder;

public interface IMoviesClientUriBuilderProvider {

    /**
     * Ten getter zwraca klucz do api https://www.themoviedb.org/
     * -> utwórz darmowe konto i sprawdź w ustawieniach konta wartość klucza
     * @return klucz do api
     */
     String apiKey();

    /**
     * Ten getter zwraca adres bazowy do api api.themoviedb.org
     * @return
     */
    String host();

    /**
     * zwraca wersję api - domyślnie 3
     * @return
     */
    int apiVersion();


    /**
     * Metoda zwraca spredefinowanego budowniczego do adresów URI
     * docs. https://www.baeldung.com/spring-uricomponentsbuilder
     * @return UriComponentsBuilder
     */
    default UriComponentsBuilder builder(){
        return UriComponentsBuilder.newInstance()
                .scheme("http")
                .host(host())
                .pathSegment(apiVersion()+"")
                .queryParam("api_key", apiKey());
    }
}
