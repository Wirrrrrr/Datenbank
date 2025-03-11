package com.datenbank.DB.DBKlassen.postgres.Model;

import com.datenbank.DB.DBKlassen.postgres.Model.Cinema.Seat;
import com.datenbank.DB.DBKlassen.postgres.Model.Cinema.TicketStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Ticket {

    private Long ticketNumber;

    private Screening screening;

    private Seat seat;

    private TicketStatus status;

    private Integer price;
}
