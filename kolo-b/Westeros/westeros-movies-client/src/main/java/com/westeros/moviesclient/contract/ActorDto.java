package com.westeros.moviesclient.contract;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public record ActorDto(long id,
                       String name,
                       String character,
                       @JsonProperty("profile_path") String profilePath,
                        String biography,
                       LocalDate birthday,
                       LocalDate deathday,
                       double popularity,
                       @JsonProperty("also-known-as") String alsoKnownAs
) {}
