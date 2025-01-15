package com.westeros.moviesclient.contract;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record PagedResultDto(
        @JsonProperty("results") List<MovieSummaryDto> movies,
        int page,
        @JsonProperty("total_pages") int totalPages,
        @JsonProperty("total_results") int totalResults) {

    public record MovieSummaryDto(long id, String title){}
}
