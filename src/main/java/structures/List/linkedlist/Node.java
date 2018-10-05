package structures.List.linkedlist;

public class Node<E> {
    private Node<E> previous;
    private Node<E> next;
    private E value;

    public Node() {
    }

    public Node(Node<E> previous, Node<E> next, E value) {
        this.previous = previous;
        this.next = next;
        this.value = value;
    }

    public Node(E value) {
        this.value = value;
    }

    public Node<E> getPrevious() {
        return previous;
    }

    public void setPrevious(Node<E> previous) {
        this.previous = previous;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }
}
