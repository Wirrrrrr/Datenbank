package Commands.Commands;

import Commands.Command;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FindScreeningByMovieCommand extends Command {

    private String movieTitle;

    public FindScreeningByMovieCommand(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    @Override
    public String toString() {
        return String.format("{ \"commandType\": \"FindScreeningByMovieCommand\", \"movieTitle\": \"%s\" }", movieTitle);
    }

    @Override
    public void execute() {

    }
}
