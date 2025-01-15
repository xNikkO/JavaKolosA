package com.westeros.data.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int sourceId;
    private String logoPath;
    private String name;
    private String originCountry;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "COMPANY_MOVIES",
            joinColumns = @JoinColumn(name = "MOVIES_ID", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "PRODUCTION_COMPANIES_ID",
                    referencedColumnName = "id"))
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

    public String getLogoPath() {
        return logoPath;
    }

    public void setLogoPath(String logoPath) {
        this.logoPath = logoPath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOriginCountry() {
        return originCountry;
    }

    public void setOriginCountry(String originCountry) {
        this.originCountry = originCountry;
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
        Company company = (Company) o;
        return id == company.id && sourceId == company.sourceId && Objects.equals(logoPath, company.logoPath) && Objects.equals(name, company.name) && Objects.equals(originCountry, company.originCountry) && Objects.equals(movies, company.movies);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sourceId, logoPath, name, originCountry, movies);
    }
}
