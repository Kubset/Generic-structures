package structures.linkedlist;

public class LinkedList<T> {

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

    public T get(int index) {
        Node<T> currentNode = firstNode;
        for(int i=0; i<index; i++) {
            currentNode = currentNode.getNext();

        }
        return currentNode.getValue();
    }


}
