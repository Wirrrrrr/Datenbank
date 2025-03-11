package com.datenbank.DB.DBKlassen.postgres.Model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Booking {

    private Long bookingNumber;

    private String customerName;

    private  String customerEmail;

    private Screening screening;

    private List<Ticket> tickets;
}
