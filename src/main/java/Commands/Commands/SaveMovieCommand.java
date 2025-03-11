package Commands.Commands;

import Commands.Command;
import com.datenbank.DB.DBKlassen.postgres.Model.Movie;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SaveMovieCommand extends Command<Movie> {
    private final Movie movie;

    @JsonCreator
    public SaveMovieCommand(@JsonProperty("movie") Movie movie) {
        this.movie = movie;
    }

    @Override
    public void execute() {
        try {
            System.out.println("Speichere Film: " + movie);
            // Hier würde der Datenbank-Speichervorgang stattfinden:
            // datenbankService.save(movie);
        } catch (Exception e) {
            this.e = e;
        }
    }

    public Movie getMovie() {
        return movie;
    }
}
