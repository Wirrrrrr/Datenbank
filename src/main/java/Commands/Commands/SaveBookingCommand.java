package Commands.Commands;

import Commands.Command;
import com.datenbank.DB.DBKlassen.postgres.Model.Booking;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SaveBookingCommand extends Command<Booking> {
    private final Booking booking;

    @JsonCreator
    public SaveBookingCommand(@JsonProperty("booking") Booking booking) {
        this.booking = booking;
    }

    @Override
    public void execute() {
        try {
            System.out.println("Speichere Buchung: " + booking);
            // Hier würde der Datenbank-Speichervorgang stattfinden:
            // datenbankService.save(booking);
        //    this.result = true; // Erfolgreich gespeichert
        } catch (Exception e) {
            this.e = e;
        }
    }

    public Booking getBooking() {
        return booking;
    }
}
