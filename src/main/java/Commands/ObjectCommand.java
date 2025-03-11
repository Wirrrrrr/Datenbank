package Commands;

/**
 * A command targeted at an object of type @param <T> and returning a value of type @param <R>
 */
public abstract class ObjectCommand<T, R> extends Command<R> {
    protected T receiver;
    public ObjectCommand(T receiver) {this.receiver = receiver;}
    public T getReceiver() {return receiver;}
}

