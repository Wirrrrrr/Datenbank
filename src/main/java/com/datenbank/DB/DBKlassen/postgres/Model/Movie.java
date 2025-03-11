package com.datenbank.DB.DBKlassen.postgres.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Movie {

    @Id
    private String title;

    private Integer runTimeMinutes;

    private Integer ageRestriction;

    private String moveImage;
}
