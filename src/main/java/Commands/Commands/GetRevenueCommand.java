package Commands.Commands;

import Commands.Command;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GetRevenueCommand extends Command {

    private String revenueId;
    private String revenue;

    public GetRevenueCommand(String revenueId) {
        this.revenueId = revenueId;
    }

    @Override
    public String toString() {
        return String.format("{ \"commandType\": \"GetRevenueCommand\", \"revenueId\": \"%s\" }", revenueId);
    }

    @Override
    public void execute() {
        // Logik um die Einnahmen zu holen, z.B. aus einer Datenbank oder einer externen Quelle
        // Beispiel:
        this.revenue = revenueId;
    }

    // Getter für die Revenue, um sie nach der Ausführung abzurufen
    public String getRevenue() {
        return revenue;
    }
}
