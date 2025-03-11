package com.datenbank.DB.DBKlassen.postgres.Model;

import Informationsinfrastrukturen.IIS.Model.Cinema.Seat;
import Informationsinfrastrukturen.IIS.Model.Cinema.TicketStatus;
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
