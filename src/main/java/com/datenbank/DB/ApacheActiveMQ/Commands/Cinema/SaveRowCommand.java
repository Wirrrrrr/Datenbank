package com.datenbank.DB.ApacheActiveMQ.Commands.Cinema;


import Commands.Command;
import com.datenbank.DB.DBKlassen.postgres.Model.Cinema.Row;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SaveRowCommand extends Command<Row> {
    private final Row row;

    @JsonCreator
    public SaveRowCommand(@JsonProperty("row") Row row) {
        this.row = row;
    }

    @Override
    public void execute() {
        try {
            System.out.println("Speichere Reihe: " + row);
            // Hier würde der Datenbank-Speichervorgang stattfinden:
            // datenbankService.save(row);
            this.result = true; // Erfolgreich gespeichert
        } catch (Exception e) {
            this.e = e;
        }
    }

    public Row getRow() {
        return row;
    }
}
