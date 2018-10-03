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
}
