package com.datenbank.DB.DBKlassen.postgres.Model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Movie {

    private String title;

    private Integer runTimeMinutes;

    private Integer ageRestriction;

    private String moveImage;
}
