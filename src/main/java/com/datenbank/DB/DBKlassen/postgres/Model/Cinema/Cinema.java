package com.datenbank.DB.DBKlassen.postgres.Model.Cinema;

import Informationsinfrastrukturen.IIS.Model.Exceptions.CinemaModifyException;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Setter
@Getter
public class Cinema {

    private Long theaterNumber;

    private List<Row> rows = new ArrayList<Row>();

    private Boolean ready = Boolean.FALSE;

    public Optional<Row> getRow(Character rowKey) {
        for (Row row : rows) {
            if (row.getRowKey().equals(rowKey)) {
                return Optional.of(row);
            }
        }
        return Optional.empty();
    }

    public void addRow(Row row) throws CinemaModifyException {
        if (ready){
            throw new CinemaModifyException("Cinema is already ready");
        }else {
            for (Row currentRows : rows) {
                if(currentRows.getRowKey() == row.getRowKey()){
                    throw new CinemaModifyException("Row already exists");
                }
            }
            rows.add(row);
        }
    }
}
