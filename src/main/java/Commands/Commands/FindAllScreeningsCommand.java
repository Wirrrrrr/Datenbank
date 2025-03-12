package Commands.Commands;

import Commands.Command;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FindAllScreeningsCommand extends Command {

    @Override
    public String toString() {
        return "{ \"commandType\": \"FindAllScreeningsCommand\" }";
    }

    @Override
    public void execute() {
        // Hier könnte die Logik zum Abrufen aller Screenings implementiert werden
    }
}
