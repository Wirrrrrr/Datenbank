package com.datenbank.DB.DBKlassen.postgres.Model.Cinema;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Seat {

    private Long seatID;

    private Integer seatNumber;

    private SeatCategory seatCategory;
}

