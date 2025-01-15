package com.westeros.movies.mappers;

import com.westeros.data.model.Language;
import com.westeros.moviesclient.contract.Dictionaries;
import org.springframework.stereotype.Component;

@Component
public class LanguageMapper implements IMapEntities<Dictionaries.LanguageDto, Language>{
    @Override
    public Language map(Dictionaries.LanguageDto languageSummaryDto) {
        return map(languageSummaryDto, new Language());
    }

    @Override
    public Language map(Dictionaries.LanguageDto languageSummaryDto, Language spokenLanguage) {
        spokenLanguage.setName(languageSummaryDto.englishName());
        spokenLanguage.setEnglishName(languageSummaryDto.englishName());
        return spokenLanguage;
    }
}
