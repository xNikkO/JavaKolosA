package com.westeros.data.repositories;

import com.westeros.data.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MoviesRepository extends JpaRepository<Movie, Long> {
    @Query("select x from Movie x where x.sourceId not in (:sourceIds)")
    List<Movie> getMoviesExcludingSourceIds(List<Integer> sourceIds);
    @Query("select x.sourceId from Movie x where x.sourceId in (:sourceIds)")
    List<Long> getSourceIdsIn(List<Long> sourceIds);
    @Query("select x from Movie x where x.sourceId in (:sourceIds)")
    List<Movie> getMovieWithSourceIds(List<Long> sourceIds);

    Optional<Movie> findBySourceId(Long sourceId);
}
