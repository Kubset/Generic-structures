package structures.List;

public interface List<T> {

    public void add(T element);
    public void add(int index, T element);
    public T get(int index);
    public int size();
}
