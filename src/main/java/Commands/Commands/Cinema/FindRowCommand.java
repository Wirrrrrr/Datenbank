package Commands.Commands.Cinema;

import Commands.Command;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FindRowCommand extends Command {

    private Character rowKey;

    public FindRowCommand(Character rowKey) {
        this.rowKey = rowKey;
    }

    @Override
    public String toString() {
        return String.format("{ \"commandType\": \"FindRowCommand\", \"rowKey\": \"%c\" }", rowKey);
    }

    @Override
    public void execute() {

    }
}
