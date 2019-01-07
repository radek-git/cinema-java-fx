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

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_MOVIE", referencedColumnName = "ID_MOVIE")
    private Movie movie;


    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_ROOM", referencedColumnName = "ID_ROOM")
    private Room room;


    @Column(name = "DATETIME")
    private LocalDateTime dateTime;

//    @OneToOne
//    @JoinColumn(name = "ID_MOVIE")
//    private Movie movie;

    public Seance() {
    }

    public Seance(Movie movie, Room room, LocalDateTime dateTime) {
        this.movie = movie;
        this.room = room;
        this.dateTime = dateTime;
    }

    public int getId() {
        return id;
    }

    public Movie getMovie() {
        return movie;
    }

    public Room getRoom() {
        return room;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }


    //    public Movie getMovie() {
//        return movie;
//    }
}
