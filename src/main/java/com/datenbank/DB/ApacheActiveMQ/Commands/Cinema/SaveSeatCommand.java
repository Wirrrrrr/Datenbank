package com.datenbank.DB.ApacheActiveMQ.Commands.Cinema;

import Commands.Command;
import com.datenbank.DB.DBKlassen.postgres.Model.Cinema.Seat;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SaveSeatCommand extends Command<Seat> {
    private final Seat seat;

    @JsonCreator
    public SaveSeatCommand(@JsonProperty("seat") Seat seat) {
        this.seat = seat;
    }

    @Override
    public void execute() {
        try {
            System.out.println("Speichere Sitz: " + seat);
            // Hier würde der Datenbank-Speichervorgang stattfinden:
            // datenbankService.save(seat);
        } catch (Exception e) {
            this.e = e;
        }
    }

    public Seat getSeat() {
        return seat;
    }
}

