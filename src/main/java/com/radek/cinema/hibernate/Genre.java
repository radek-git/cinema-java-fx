package com.radek.cinema.hibernate;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "genres")
public class Genre implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_GENRE", nullable = false, length = 11)
    private int id;


    @Column(name = "NAME", length = 50)
    private String name;

    public Genre(String name) {
        this.name = name;
    }

    public Genre() {
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
}
