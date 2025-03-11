package Commands.Commands;

import Commands.Command;
import com.datenbank.DB.DBKlassen.postgres.Model.Reservation;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SaveReservationCommand extends Command<Reservation> {
    private final Reservation reservation;

    @JsonCreator
    public SaveReservationCommand(@JsonProperty("reservation") Reservation reservation) {
        this.reservation = reservation;
    }

    @Override
    public void execute() {
        try {
            System.out.println("Speichere Reservierung: " + reservation);
            // Hier würde der Datenbank-Speichervorgang stattfinden:
            // datenbankService.save(reservation);
        } catch (Exception e) {
            this.e = e;
        }
    }

    public Reservation getReservation() {
        return reservation;
    }
}
