package Commands.Commands.Cinema;

import Commands.Command;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FindAllCinemaCommand extends Command {

    @Override
    public String toString() {
        return "{ \"commandType\": \"FindAllCinemaCommand\" }";
    }

    @Override
    public void execute() {
        // Hier könnte die Logik zum Abrufen aller Kinos implementiert werden
    }
}
