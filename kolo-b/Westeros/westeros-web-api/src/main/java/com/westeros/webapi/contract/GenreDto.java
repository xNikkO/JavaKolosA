package com.westeros.webapi.contract;

import lombok.Data;

import java.util.List;

@Data
public class GenreDto {
    private int id;
    private String name;
    private List<MovieSummaryDto> movies;
}
