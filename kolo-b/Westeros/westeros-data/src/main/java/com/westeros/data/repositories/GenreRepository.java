package com.westeros.data.repositories;

import com.westeros.data.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Integer> {


    @Query("select x from Genre x where x.sourceId in (:sourceIds)")
    List<Genre> WithSourceIdsIn(List<Integer> sourceIds);
}
