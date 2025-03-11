package com.datenbank.DB.DBKlassen;


import com.datenbank.DB.DBKlassen.postgres.Model.Movie;
import com.datenbank.DB.DBKlassen.postgres.Model.Pair;
import com.datenbank.DB.DBKlassen.postgres.Model.Screening;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Data
@Document
public class Revenue {

    List<Pair<Pair<Movie,Long>, List<Pair<Screening,Long>>>> revenues = new ArrayList<>();

    public void addToRevenue(Pair<Pair<Movie,Long>, List<Pair<Screening,Long>>> listPair){
        revenues.add(listPair);
    }
}
