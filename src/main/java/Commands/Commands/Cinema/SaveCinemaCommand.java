package Commands.Commands.Cinema;

import Commands.Command;
import com.datenbank.DB.DBKlassen.postgres.Model.Cinema.Cinema;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SaveCinemaCommand extends Command<Cinema> {
    private final Cinema cinema;

    @JsonCreator
    public SaveCinemaCommand(@JsonProperty("cinema") Cinema cinema) {
        this.cinema = cinema;
    }

    @Override
    public void execute() {
        try {
            System.out.println("Speichere Kino: " + cinema);
            System.out.println(cinema.toString());
            // Hier würde der Datenbank-Speichervorgang stattfinden:
            // datenbankService.save(cinema);
        } catch (Exception e) {
            this.e = e;
        }
    }


    public Cinema getCinema() {
        return cinema;
    }
}