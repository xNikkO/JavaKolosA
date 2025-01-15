package com.westeros.data.repositories;

import com.westeros.data.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {

    @Query("select x from Country x where x.name in (:names)")
    List<Country> withNames(List<String> names);

    Optional<Country> findByName(String name);
}
