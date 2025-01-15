package com.westeros.data.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int sourceId;
    private String name;
    private String profilePath;
    private String alsoKnownAs;
    @Lob
    @Column(columnDefinition = "TEXT")
    private String biography;
    private LocalDate birthday;
    private LocalDate deathday;
    private double popularity;

    @OneToMany(mappedBy = "actor")
    private List<ActorRole> characters = new ArrayList<>();

    public long getId() {

        return id;
    }

    public void setId(long id) {
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

    public String getProfilePath() {
        return profilePath;
    }

    public void setProfilePath(String profilePath) {
        this.profilePath = profilePath;
    }

    public String getAlsoKnownAs() {
        return alsoKnownAs;
    }

    public void setAlsoKnownAs(String alsoKnownAs) {
        this.alsoKnownAs = alsoKnownAs;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public LocalDate getDeathday() {
        return deathday;
    }

    public void setDeathday(LocalDate deathday) {
        this.deathday = deathday;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public List<ActorRole> getCharacters() {
        return characters;
    }

    public void setCharacters(List<ActorRole> character) {
        this.characters = character;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Actor actor = (Actor) o;
        return id == actor.id && sourceId == actor.sourceId && Double.compare(actor.popularity, popularity) == 0 && Objects.equals(name, actor.name) && Objects.equals(profilePath, actor.profilePath) && Objects.equals(alsoKnownAs, actor.alsoKnownAs) && Objects.equals(biography, actor.biography) && Objects.equals(birthday, actor.birthday) && Objects.equals(deathday, actor.deathday) && Objects.equals(characters, actor.characters);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sourceId, name, profilePath, alsoKnownAs, biography, birthday, deathday, popularity, characters);
    }
}
