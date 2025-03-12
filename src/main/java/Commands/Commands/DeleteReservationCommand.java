package Commands.Commands;

import Commands.Command;
import com.datenbank.DB.DBKlassen.postgres.Model.Reservation;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class DeleteReservationCommand extends Command<Reservation> {
    private final Reservation reservation;
    private final List<Reservation> reservations;

    @JsonCreator
    public DeleteReservationCommand(@JsonProperty("reservation") Reservation reservation,
                                    @JsonProperty("reservations") List<Reservation> reservations) {
        this.reservation = reservation;
        this.reservations = reservations;
    }

    @Override
    public void execute() {
        try {
            boolean removed = reservations.removeIf(r -> r.getBookingNumber() == reservation.getBookingNumber());
            if (removed) {
                System.out.println("Reservierung gelöscht: " + reservation);
            } else {
                System.out.println("Reservierung nicht gefunden: " + reservation);
            }
        } catch (Exception e) {
            this.e = e;
        }
    }

    public Reservation getReservation() {
        return reservation;
    }
}
