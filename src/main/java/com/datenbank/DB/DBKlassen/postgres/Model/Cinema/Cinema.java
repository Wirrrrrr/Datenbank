package com.datenbank.DB.DBKlassen.postgres.Model.Cinema;

import com.datenbank.DB.DBKlassen.postgres.Model.Exceptions.CinemaModifyException;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Setter
@Getter
@Entity
public class Cinema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long theaterNumber;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "theater_Number")  // Fremdschlüssel in Seat
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

    /*public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{\n");
        sb.append(String.format("  \"theaterNumber\": %d,\n", theaterNumber));
        sb.append(String.format("  \"ready\": %s,\n", ready ? "true" : "false"));

        sb.append("  \"rows\": [\n");

        for (Row row : rows) {
            sb.append("    {\n");
            sb.append(String.format("      \"rowKey\": \"%c\",\n", row.getRowKey()));
            sb.append("      \"seats\": [\n");

            for (Seat seat : row.getSeats()) {
                sb.append("        {\n");
                sb.append(String.format("          \"seatID\": %d,\n", seat.getSeatID()));
                sb.append(String.format("          \"seatNumber\": %d,\n", seat.getSeatNumber()));
                sb.append(String.format("          \"seatCategory\": \"%s\"\n", seat.getSeatCategory()));
                sb.append("        },\n");
            }

            // Entferne das letzte Komma nach dem letzten Seat
            if (!row.getSeats().isEmpty()) {
                sb.setLength(sb.length() - 2); // Entfernt das letzte Komma
            }

            sb.append("      ]\n");
            sb.append("    },\n");
        }

        // Entferne das letzte Komma nach der letzten Row
        if (!rows.isEmpty()) {
            sb.setLength(sb.length() - 2); // Entfernt das letzte Komma
        }

        sb.append("\n  ]\n");
        sb.append("}");

        return sb.toString();
    }*/

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
