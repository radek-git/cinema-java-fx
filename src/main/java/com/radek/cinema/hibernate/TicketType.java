package com.radek.cinema.hibernate;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ticket_types")
public class TicketType implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TICKET_TYPE")
    private int id;

    @Basic
    @Column(name = "ticket_type")
    private String name;

    @Basic
    @Column(name = "price")
    private int price;


    public TicketType() {
    }

    public TicketType(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
