package com.radek.cinema.hibernate;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tickets")
public class Ticket implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TICKET")
    private int id;

    @Basic
    @Column(name = "ID_SEANCE")
    private int seanceId;


    @OneToOne
    @JoinColumn(name = "ID_TICKET_TYPE")
    private TicketType ticketType;

    @Basic
    @Column(name = "ROW")
    private int row;

    @Basic
    @Column(name = "SEAT")
    private int seat;


    public Ticket() {
    }


    public Ticket(int seanceId, TicketType ticketType, int row, int seat) {
        this.seanceId = seanceId;
        this.ticketType = ticketType;
        this.row = row;
        this.seat = seat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSeanceId() {
        return seanceId;
    }

    public TicketType getTicketType() {
        return ticketType;
    }

    public int getRow() {
        return row;
    }

    public int getSeat() {
        return seat;
    }
}

