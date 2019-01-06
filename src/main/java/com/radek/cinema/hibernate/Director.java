package com.radek.cinema.hibernate;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "directors")
public class Director implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_DIRECTOR", nullable = false, length = 11)
    private int id;

    @Basic
    @Column(name = "NAME", length = 50)
    private String name;

    @Basic
    @Column(name = "SURNAME", length = 50)
    private String surname;

    public Director(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Director() {
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
