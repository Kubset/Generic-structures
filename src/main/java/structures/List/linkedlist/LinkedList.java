package structures.List.linkedlist;

import structures.List.List;

public class LinkedList<T> implements List<T> {

    private Node<T> firstNode;
    private Node<T> lastNode;
    private int size;

    public LinkedList() {
        this.size = 0;
    }

    public void add(T element) {
        if(size == 0) {
            firstNode = lastNode = new Node<>(element);
        } else {
            lastNode.setNext(new Node<>(element));
            lastNode = lastNode.getNext();
        }
        size++;

    }

    public void add(int index, T element) {
        checkElementIndex(index);
        Node<T> currentNode = firstNode;
        Node<T> newNode = new Node<>(element);
        if(index == 0) {
            newNode.setNext(firstNode);
            firstNode = newNode;
        } else {
            for(int i=1; i<index; i++) {
                currentNode = currentNode.getNext();
            }
            newNode.setNext(currentNode.getNext());
            currentNode.setNext(newNode);
        }
        size++;
    }

    public T get(int index) {
        Node<T> currentNode = firstNode;
        for(int i=0; i<index; i++) {
            currentNode = currentNode.getNext();

        }
        return currentNode.getValue();
    }

    public int size() {
        return size;
    }

    public void remove(int index) {
        checkElementIndex(index);
        Node<T> currentNode = firstNode;
        if(index == 0) {
            firstNode = firstNode.getNext();
        } else {
            for(int i=1; i<index; i++) {
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(currentNode.getNext().getNext());
        }
        size--;
    }

    public void addFirst(T element) {

    }

    public void addLast(T element) {

    }

    public T getFirst() {
        return null;
    }

    public T getLast() {
        return null;
    }

    public void clear() {

    }

    public void contains(T element) {

    }

    public int indexOf(T element) {
        return 0;
    }

    public T pop() {
        return null;
    }

    public void push(T element) {

    }

    public T[] toArray() {
        return null;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        for(int i=0; i<size; i++) {
            result.append(get(i));
            result.append(", ");
        }
        result.setLength(result.length()-2);
        result.append("]");

        return result.toString();
    }

    private void checkElementIndex(int index) {
        if(index > size || index < 0) throw new IndexOutOfBoundsException();
    }
}
