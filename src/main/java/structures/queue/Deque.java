package structures.queue;

public interface Deque<T> {
    public void addFirst(T element);
    public void addLast(T element);
    public T getFirst();
    public T getLast();
    public T pop();
    public void push(T element);
}
