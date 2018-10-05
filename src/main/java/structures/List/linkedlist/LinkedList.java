package structures.List.linkedlist;

import structures.List.List;
import structures.queue.Deque;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<E> implements List<E>, Deque<E>, Iterable<E> {

    private Node<E> firstNode;
    private Node<E> lastNode;
    private int size;

    public LinkedList() {
        this.size = 0;
    }

    public void add(E element) {
        if(size == 0) {
            firstNode = lastNode = new Node<>(element);
        } else {
            lastNode.setNext(new Node<>(element));
            lastNode = lastNode.getNext();
        }
        size++;

    }

    public void add(int index, E element) {
        checkElementIndex(index);
        Node<E> currentNode = firstNode;
        Node<E> newNode = new Node<>(element);
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

    public E get(int index) {
        Node<E> currentNode = firstNode;
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
        Node<E> currentNode = firstNode;
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

    public void addFirst(E element) {
        this.push(element);
    }

    public void addLast(E element) {
        Node<E> newNode = new Node<E>(element);
        lastNode.setNext(newNode);
        lastNode = lastNode.getNext();
        size++;
    }

    public E getFirst() {
        checkEmptyList();
        return firstNode.getValue();
    }

    public E getLast() {
        checkEmptyList();
        return lastNode.getValue();
    }

    public void clear() {
        firstNode = lastNode = null;
        size = 0;
    }

    public boolean contains(E element) {
        Node<E> currentNode = firstNode;
        for(int i=0; i<size; i++) {
            if(currentNode.getValue().equals(element)) {
                return true;
            }
            currentNode = currentNode.getNext();
        }
        return false;

    }

    public int indexOf(E element) {
        int index = 0;
        Node<E> currentNode = firstNode;
        for(int i=0; i<size; i++) {
            if(currentNode.getValue().equals(element)) {
                return index;
            }
            currentNode = currentNode.getNext();
            index++;
        }
        return -1;
    }

    public E pop() {
        checkEmptyList();
        E firstValue = firstNode.getValue();
        firstNode = firstNode.getNext();
        size--;
        return firstValue;
    }

    public void push(E element) {
        Node<E> newNode = new Node<E>(element);
        newNode.setNext(firstNode);
        firstNode = newNode;
        size++;
    }

    public Object[] toArray() {
        Object[] resultArray = new Object[size];
        Node<E> currentNode = firstNode;

        for(int i=0; i<size; i++) {
            resultArray[i] = currentNode.getValue();
            currentNode = currentNode.getNext();
        }
        return resultArray;
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedListIterator<>(this);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        if(size == 0) return "[]";
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

    private void checkEmptyList() {
        if(size==0) throw new NoSuchElementException();
    }

}
