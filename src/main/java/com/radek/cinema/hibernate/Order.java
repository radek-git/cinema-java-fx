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

    @Basic
    @Column(name = "ID_SEANCE")
    private int seanceId;

    @Basic
    @Column(name = "ID_USER")
    private Integer userId;

    @Basic
    @Column(name = "ID_EMPLOYEE")
    private Integer employeeId;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "order_tickets", joinColumns = {@JoinColumn(name = "ID_ORDER")},
            inverseJoinColumns = {@JoinColumn(name = "ID_TICKET")})
    private Set<Ticket> tickets;


    public Order() {
    }

    public Order(int seanceId, Integer userId, Integer employeeId, Set<Ticket> tickets) {
        this.seanceId = seanceId;
        this.userId = userId;
        this.employeeId = employeeId;
        this.tickets = tickets;
    }

    public Order(int seanceId, Integer userId, Integer employeeId) {
        this.seanceId = seanceId;
        this.userId = userId;
        this.employeeId = employeeId;
        this.tickets = new HashSet<>();
    }

    public int getId() {
        return id;
    }

    public Integer getSeanceId() {
        return seanceId;
    }

    public Integer getUserId() {
        return userId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public Set<Ticket> getTickets() {
        return tickets;
    }

    @Override
    public String toString() {
        return "Id zamowienia: " + id + " Id seansu: " + seanceId;// + seance.getMovie().getTitle();
    }
}
