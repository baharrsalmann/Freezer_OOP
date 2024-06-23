import java.util.List;

public interface Container<T> {
    public boolean put(T item);

    public T remove();

    public List<T> getAll();
}
