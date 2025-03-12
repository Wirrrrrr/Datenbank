package Commands.Commands;

import Commands.Command;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FindScreeningCommand extends Command {

    private Long screeningID;

    public FindScreeningCommand(Long screeningID) {
        this.screeningID = screeningID;
    }

    @Override
    public String toString() {
        return String.format("{ \"commandType\": \"FindScreeningCommand\", \"screeningID\": %d }", screeningID);
    }

    @Override
    public void execute() {

    }
}
