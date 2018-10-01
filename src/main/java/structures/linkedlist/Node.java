package structures.linkedlist;

public class Node<T> {
    private Node previous;
    private Node next;
    private T value;

    public Node() {
    }

    public Node(Node previous, Node next, T value) {
        this.previous = previous;
        this.next = next;
        this.value = value;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
