package com.westeros.data.repositories;

import com.westeros.data.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Long> {

    @Query("select x from Actor x where x.sourceId not in (:sourceIds)")
    List<Actor> getActorsExcludingSourceIds(@Param("sourceIds") List<Integer> sourceIds);

    @Query("select x from Actor x where x.sourceId in (:sourceIds)")
    List<Actor> withSourceIds(List<Long> sourceIds);
}
