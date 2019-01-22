package com.radek.cinema.hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ORDER")
    private int id;

//    @Basic
//    @Column(name = "ID_SEANCE")
//    private int seanceId;

    @OneToOne(fetch = FetchType.LAZY, optional = false) //optional ma 2 opcje - true albo false.
    @JoinColumn(name = "ID_SEANCE", referencedColumnName = "ID_SEANCE")
    private Seance seance;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_USER", referencedColumnName = "ID_USER")
    private User user;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_EMPLOYEE", referencedColumnName = "ID_EMPLOYEE")
    private Employee employee;

    @OneToMany(mappedBy = "order")
    private Set<Ticket> tickets;


    public Order() {
    }

    public Order(Seance seance, User user, Employee employee, Set<Ticket> tickets) {
        this.seance = seance;
        this.user = user;
        this.employee = employee;
        this.tickets = tickets;
    }

    public int getId() {
        return id;
    }

    public Seance getSeance() {
        return seance;
    }

    public User getUser() {
        return user;
    }

    public Employee getEmployee() {
        return employee;
    }

    public Set<Ticket> getTickets() {
        return tickets;
    }
}
