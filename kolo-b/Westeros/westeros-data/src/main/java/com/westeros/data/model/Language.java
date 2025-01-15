package com.westeros.data.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class  Language implements IHaveDictionaryName{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String englishName;
    private String name;

    @ManyToMany
    private List<Movie> movies = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
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
        Language language = (Language) o;
        return id == language.id && Objects.equals(englishName, language.englishName) && Objects.equals(name, language.name) && Objects.equals(movies, language.movies);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, englishName, name, movies);
    }
}
