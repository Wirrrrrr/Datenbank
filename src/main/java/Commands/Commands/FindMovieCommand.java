package Commands.Commands;

import Commands.Command;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FindMovieCommand extends Command {

    private String title;

    public FindMovieCommand(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return String.format("{ \"commandType\": \"FindMovieCommand\", \"title\": \"%s\" }", title);
    }

    @Override
    public void execute() {

    }
}