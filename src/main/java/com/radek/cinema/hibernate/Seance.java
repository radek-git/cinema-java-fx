package com.radek.cinema.hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;


@Entity
@Table(name = "seances")
public class Seance implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_SEANCE")
    private int id;

    @Basic
    @Column(name = "ID_MOVIE")
    private int movieId;

    @Basic
    @Column(name = "ID_ROOM")
    private int roomId;

    @Basic
    @Column(name = "DATETIME")
    private LocalDateTime dateTime;

//    @OneToOne
//    @JoinColumn(name = "ID_MOVIE")
//    private Movie movie;

    public Seance() {
    }

    public Seance(int movieId, int roomId, LocalDateTime dateTime) {
        this.movieId = movieId;
        this.roomId = roomId;
        this.dateTime = dateTime;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

//    public Movie getMovie() {
//        return movie;
//    }
}
