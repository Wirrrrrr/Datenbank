package com.datenbank.DB.ApacheActiveMQ.Commands;

import Commands.Command;
import com.datenbank.DB.DBKlassen.postgres.Model.Cinema.Cinema;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SaveCinemaCommand extends Command<Boolean> {
    private final Cinema cinema;

    @JsonCreator
    public SaveCinemaCommand(@JsonProperty("cinema") Cinema cinema) {
        this.cinema = cinema;
    }

    @Override
    public void execute() {
        try {
            System.out.println("Speichere Kino: " + cinema);
            // Hier würde der Datenbank-Speichervorgang stattfinden:
            // datenbankService.save(cinema);
            this.result = true; // Erfolgreich gespeichert
        } catch (Exception e) {
            this.e = e;
        }
    }

    public Cinema getCinema() {
        return cinema;
    }
}