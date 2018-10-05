package structures.List.linkedlist;

import java.util.Arrays;
import java.util.Iterator;

public class LinkedListIterator<E> implements Iterator<E> {
    private int position = 0;
    private Object[] data;

    LinkedListIterator(LinkedList<E> data) {
        this.data = data.toArray();
    }

    public boolean hasNext() {
        if (position < data.length)
            return true;
        else
            return false;
    }

    public E next() {
        if (this.hasNext())
            return (E) data[position++];
        else
            return null;
    }
}
