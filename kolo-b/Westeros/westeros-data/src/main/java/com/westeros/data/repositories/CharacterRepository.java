package com.westeros.data.repositories;

import com.westeros.data.model.ActorRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CharacterRepository extends JpaRepository<ActorRole, Long> {

    @Query("select cr from ActorRole cr where cr.movie.id = :movieId")
    List<ActorRole> getActorsFromMovie(@Param("movieId")long id);
}
