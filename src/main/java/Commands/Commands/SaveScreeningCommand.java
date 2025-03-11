package Commands.Commands;

import Commands.Command;
import com.datenbank.DB.DBKlassen.postgres.Model.Screening;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SaveScreeningCommand extends Command<Screening> {
    private final Screening screening;

    @JsonCreator
    public SaveScreeningCommand(@JsonProperty("screening") Screening screening) {
        this.screening = screening;
    }

    @Override
    public void execute() {
        try {
            System.out.println("Speichere Vorführung: " + screening);
            // Hier würde der Datenbank-Speichervorgang stattfinden:
            // datenbankService.save(screening);
        } catch (Exception e) {
            this.e = e;
        }
    }

    public Screening getScreening() {
        return screening;
    }
}