package com.datenbank.DB.DBKlassen.postgres.Model.Cinema;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seatID;

    private Integer seatNumber;

    @Enumerated(EnumType.STRING)
    private SeatCategory seatCategory;

    @Override
    public String toString() {
        return String.format("{ \"seatID\": %d, \"seatNumber\": %d, \"seatCategory\": \"%s\" }",
                seatID, seatNumber, seatCategory);
    }
}

