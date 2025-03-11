package Commands;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.io.Serializable;
import java.util.UUID;
/**
 * An arbitrary command to call an operation, which returns a value of type R or an exception
 * @param <R>
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property = "@class")
public abstract class Command<R> implements Serializable {
    private final String id;  // Einzigartige ID

    protected R result;
    protected Exception e;

    public Command() {
        this.id = UUID.randomUUID().toString();  // Zufällige ID generieren
    }

    public String getId() {
        return id;
    }

    public abstract void execute();

    public R getResult() throws Exception {
        if (this.e != null) throw e;
        return this.result;
    }
}

