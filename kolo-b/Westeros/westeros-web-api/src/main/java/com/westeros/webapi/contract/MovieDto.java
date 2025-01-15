package com.westeros.webapi.contract;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
public class MovieDto extends MovieSummaryDto{

    private boolean adult;
    private int budget;
    private String overview;
    private LocalDate releaseDate;
    private int runtime;

}
