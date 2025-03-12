package Commands.Commands;

import Commands.Command;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FindRevenueCommand extends Command {

    private String revenueId;

    public FindRevenueCommand(String revenueId) {
        this.revenueId = revenueId;
    }

    @Override
    public String toString() {
        return String.format("{ \"commandType\": \"FindRevenueCommand\", \"revenueId\": \"%s\" }", revenueId);
    }

    @Override
    public void execute() {
        // Hier könnte die Logik zum Finden der Einnahmen implementiert werden
    }
}
