package Commands.Commands;

import Commands.Command;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FindAllMoviesCommand extends Command {

    @Override
    public String toString() {
        return "{ \"commandType\": \"FindAllMoviesCommand\" }";
    }

    @Override
    public void execute() {
        // Hier könnte die Logik zum Abrufen aller Filme implementiert werden
    }
}
