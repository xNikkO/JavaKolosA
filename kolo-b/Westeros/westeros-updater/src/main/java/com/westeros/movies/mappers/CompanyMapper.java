package com.westeros.movies.mappers;

import com.westeros.data.model.Company;
import com.westeros.moviesclient.contract.MovieDto;
import org.springframework.stereotype.Component;

@Component
public class CompanyMapper implements IMapEntities<MovieDto.CompanySummaryDto, Company>{
    @Override
    public Company map(MovieDto.CompanySummaryDto companySummaryDto) {
        return map(companySummaryDto, new Company());
    }

    @Override
    public Company map(MovieDto.CompanySummaryDto companySummaryDto, Company company) {
        company.setSourceId(companySummaryDto.id());
        company.setName(companySummaryDto.name());
        company.setOriginCountry(company.getOriginCountry());
        return company;
    }
}
