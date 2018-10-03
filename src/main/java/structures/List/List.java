package structures.List;

public interface List<T> {

    public void add(T element);
    public void add(int index, T element);
    public T get(int index);
    public int size();
    public void remove(int index);
    public void addFirst(T element);
    public void addLast(T element);
    public T getFirst();
    public T getLast();
    public void clear();
    public void contains(T element);
    public int indexOf(T element);
    public T pop();
    public void push(T element);
    public T[] toArray();
}
