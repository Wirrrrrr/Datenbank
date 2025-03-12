package Commands.Commands.Cinema;

import Commands.Command;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FindCinemaCommand extends Command {

    private Long theaterNumber;

    public FindCinemaCommand(Long theaterNumber) {
        this.theaterNumber = theaterNumber;
    }

    @Override
    public String toString() {
        return String.format("{ \"commandType\": \"FindCinemaCommand\", \"theaterNumber\": %d }", theaterNumber);
    }

    @Override
    public void execute() {

    }
}
