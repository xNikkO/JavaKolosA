package com.westeros.moviesclient.contract;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Dictionaries {
    public record GenreDto(int id, String name) implements IHaveName{
        @Override
        public String getName() {
            return name;
        }
    }
    public record CountryDto(
            String name,
            @JsonProperty("english_name") String englishName,
            @JsonProperty("native_name") String nativeName,
            @JsonProperty("iso_3166_1") String isoCode)implements IHaveName{

        @Override
        public String getName() {
            return name;
        }
    }
    public record LanguageDto(
                              @JsonProperty("english_name") String englishName,
                              @JsonProperty("iso_639_1") String isoCode) implements IHaveName{
        @Override
        public String getName() {
            return englishName;
        }
    }
}
