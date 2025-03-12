package Commands.Commands;

import Commands.Command;
import com.datenbank.DB.DBKlassen.Revenue;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SaveRevenueCommand extends Command<Revenue> {
    private final Revenue revenue;

    @JsonCreator
    public SaveRevenueCommand(@JsonProperty("revenue") Revenue revenue) {
        this.revenue = revenue;
    }

    @Override
    public void execute() {
        try {
            System.out.println("Speichere Einnahmen: " + revenue);
            // Hier würde der Datenbank-Speichervorgang stattfinden:
            // datenbankService.save(revenue);
        } catch (Exception e) {
            this.e = e;
        }
    }

    public Revenue getRevenue() {
        return revenue;
    }
}
