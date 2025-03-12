package Commands.Commands;

import Commands.Command;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FindBookingCommand extends Command {

    private Long bookingNumber;

    public FindBookingCommand(Long bookingNumber) {
        this.bookingNumber = bookingNumber;
    }

    @Override
    public String toString() {
        return String.format("{ \"commandType\": \"FindBookingCommand\", \"bookingNumber\": %d }", bookingNumber);
    }

    @Override
    public void execute() {

    }
}
