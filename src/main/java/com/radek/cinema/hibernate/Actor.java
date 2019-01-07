package com.radek.cinema.hibernate;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "actors")
public class Actor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ACTOR", nullable = false, length = 11)
    private int id;

    @Column(name = "NAME", length = 80)
    private String name;

    @Column(name = "SURNAME", length = 80)
    private String surname;

    public Actor(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Actor() {
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
