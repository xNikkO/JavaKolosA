package com.westeros.data.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Genre implements IHaveDictionaryName{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int sourceId;
    private String name;

    @ManyToMany
    private List<Movie> movies = new ArrayList<>();

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSourceId() {
        return sourceId;
    }

    public void setSourceId(int sourceId) {
        this.sourceId = sourceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Genre genre = (Genre) o;
        return id == genre.id && sourceId == genre.sourceId && Objects.equals(name, genre.name) && Objects.equals(movies, genre.movies);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sourceId, name, movies);
    }
}
