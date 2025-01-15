package com.westeros.data.repositories;

import com.westeros.data.model.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Integer> {

    @Query("select x from Language x where x.name in (:names)")
    List<Language> withNames(List<String> names);
}
