package com.datenbank.DB.DBKlassen.postgres.Model;

import com.datenbank.DB.DBKlassen.postgres.Model.Cinema.Seat;
import com.datenbank.DB.DBKlassen.postgres.Model.Cinema.TicketStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ticketNumber;

    @ManyToOne
    @JoinColumn(name = "screening_id", nullable = false)
    private Screening screening;

    @ManyToOne
    @JoinColumn(name = "seat_id", nullable = false)
    private Seat seat;

    @Enumerated(EnumType.STRING)
    private TicketStatus status;

    private Integer price;

    @ManyToOne
    @JoinColumn(name = "booking_id")
    private Booking booking;
}

