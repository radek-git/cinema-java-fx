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


    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_SEANCE", referencedColumnName = "ID_SEANCE")
    private Seance seance;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_TICKET_TYPE", referencedColumnName = "ID_TICKET_TYPE")
    private TicketType ticketType;


    @Column(name = "ROW")
    private int row;


    @Column(name = "SEAT")
    private int seat;


    public Ticket() {
    }


    public Ticket(Seance seance, TicketType ticketType, int row, int seat) {
        this.seance = seance;
        this.ticketType = ticketType;
        this.row = row;
        this.seat = seat;
    }

    public int getId() {
        return id;
    }

    public Seance getSeance() {
        return seance;
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

