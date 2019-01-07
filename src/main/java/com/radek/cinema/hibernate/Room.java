package com.radek.cinema.hibernate;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "rooms")
public class Room implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ROOM")
    private int id;


    @Column(name = "NAME")
    private String name;


    @Column(name = "ROWS")
    private int row;


    @Column(name = "SEATS_IN_ROW")
    private int seatsInRow;

    public Room() {
    }

    public Room(String name, int row, int seatsInRow) {
        this.name = name;
        this.row = row;
        this.seatsInRow = seatsInRow;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getSeatsInRow() {
        return seatsInRow;
    }

    public void setSeatsInRow(int seatsInRow) {
        this.seatsInRow = seatsInRow;
    }
}
