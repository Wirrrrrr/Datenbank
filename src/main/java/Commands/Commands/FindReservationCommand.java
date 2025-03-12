package Commands.Commands;

import Commands.Command;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FindReservationCommand extends Command {

    private Long bookingNumber;

    public FindReservationCommand(Long bookingNumber) {
        this.bookingNumber = bookingNumber;
    }

    @Override
    public String toString() {
        return String.format("{ \"commandType\": \"FindReservationCommand\", \"bookingNumber\": %d }", bookingNumber);
    }

    @Override
    public void execute() {

    }
}
