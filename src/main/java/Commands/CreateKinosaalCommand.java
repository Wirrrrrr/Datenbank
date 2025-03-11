package Commands;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateKinosaalCommand extends Command<Boolean> {
    private int saalNummer; // Entferne final

    public CreateKinosaalCommand(int saalNummer) {
        this.saalNummer = saalNummer;
    }

    // Standardkonstruktor für Jackson
    public CreateKinosaalCommand() {}

    @Override
    public void execute() {
        System.out.println("Kinosaal " + saalNummer + " wird angelegt...");
        this.result = true;
    }

    public int getSaalNummer() {
        return saalNummer;
    }
}
