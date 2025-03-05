package com.datenbank.DB.DBKlassen;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "saele")  // Gibt an, dass die Klasse zur Collection "saele" gehört
public class Saal {

    @Id
    private String id;
    private String name;
    private int sitzplaetze;

    public Saal() {}

    public Saal(String name, int sitzplaetze) {
        this.name = name;
        this.sitzplaetze = sitzplaetze;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getSitzplaetze() {
        return sitzplaetze;
    }
}
