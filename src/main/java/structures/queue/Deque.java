package structures.queue;

public interface Deque<E> {
    public void add(E element);
    public void addFirst(E element);
    public void addLast(E element);
    public E getFirst();
    public E getLast();
    public E pop();
    public void push(E element);
    public boolean contains(E element);
}
