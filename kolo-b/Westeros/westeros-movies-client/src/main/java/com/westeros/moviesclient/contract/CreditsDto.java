package com.westeros.moviesclient.contract;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record CreditsDto(int id, List<ActorSummaryDto> cast) {

    public record ActorSummaryDto(
            long id,
            String name,
            String character,
            @JsonProperty("profile_path") String profilePath){}
}
