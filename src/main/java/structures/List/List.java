package structures.List;

public interface List<E> {

    public void add(E element);
    public void add(int index, E element);
    public E get(int index);
    public int size();
    public void remove(int index);
    public void clear();
    public boolean contains(E element);
    public int indexOf(E element);
    public Object[] toArray();
}
