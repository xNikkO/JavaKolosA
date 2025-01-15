package com.westeros.webapi.contract;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovieSummaryDto {

   private long id;
   private String title;
   private String homepage;
   private String language;
}
