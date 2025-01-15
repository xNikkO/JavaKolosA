package com.westeros.movies.mappers;

import com.westeros.data.model.Country;
import com.westeros.moviesclient.contract.Dictionaries;
import org.springframework.stereotype.Component;

@Component
public class CountryMapper implements IMapEntities<Dictionaries.CountryDto, Country>{
    @Override
    public Country map(Dictionaries.CountryDto countryDto) {
        return map(countryDto, new Country());
    }

    @Override
    public Country map(Dictionaries.CountryDto countryDto, Country country) {
        country.setName(countryDto.englishName());
        return country;
    }
}
