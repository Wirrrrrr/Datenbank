package Commands.Commands.Cinema;

import Commands.Command;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FindSeatCommand extends Command {

    private Long seatID;

    public FindSeatCommand(Long seatID) {
        this.seatID = seatID;
    }

    @Override
    public String toString() {
        return String.format("{ \"commandType\": \"FindSeatCommand\", \"seatID\": %d }", seatID);
    }

    @Override
    public void execute() {

    }
}
