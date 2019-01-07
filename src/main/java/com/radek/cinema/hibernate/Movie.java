package com.radek.cinema.hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "movies")
public class Movie implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_MOVIE", nullable = false, length = 20)
    private int id;


    @Column(name = "TITLE", length = 50)
    private String title;


    @Column(name = "DESCRIPTION", length = 500)
    private String description;


    @Column(name = "DURATION", length = 20)
    private int duration;


    @Column(name = "POSTER_URL")
    private String posterUrl;


    @OneToMany(cascade=CascadeType.ALL)
    @JoinTable(name="movie_directors", joinColumns={@JoinColumn(name="ID_MOVIE")},
            inverseJoinColumns={@JoinColumn(name="ID_DIRECTOR")})
    private Set<Director> directors;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinTable(name="movie_actors", joinColumns={@JoinColumn(name="ID_MOVIE")},
            inverseJoinColumns={@JoinColumn(name="ID_ACTOR")})
    private Set<Actor> actors;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinTable(name="movie_genres", joinColumns={@JoinColumn(name="ID_MOVIE")},
            inverseJoinColumns={@JoinColumn(name="ID_GENRE")})
    private Set<Genre> genres;

    public Movie(String title, String description, int duration, String posterUrl, Set<Director> directors, Set<Actor> actors, Set<Genre> genres) {
        this.title = title;
        this.description = description;
        this.duration = duration;
        this.posterUrl = posterUrl;
        this.directors = directors;
        this.actors = actors;
        this.genres = genres;
    }

    public Movie(String title, String description, int duration, String posterUrl) {
        this.title = title;
        this.description = description;
        this.duration = duration;
        this.posterUrl = posterUrl;
        this.directors = new HashSet<>();
        this.actors = new HashSet<>();
        this.genres = new HashSet<>();
    }

    public Movie() {
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Set<Director> getDirectors() {
        return directors;
    }

    public void setDirectors(Set<Director> directors) {
        this.directors = directors;
    }

    public Set<Actor> getActors() {
        return actors;
    }

    public void setActors(Set<Actor> actors) {
        this.actors = actors;
    }

    public Set<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", duration=" + duration +
                ", posterUrl='" + posterUrl + '\'' +
                '}';
    }
}
