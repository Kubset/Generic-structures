package structures.List.linkedlist;

import org.junit.jupiter.api.Test;
import structures.List.List;
import structures.queue.Deque;


import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    @Test
    public void test_addFewElementsToLinkedList() {
        int numberElements = 7;
        List<Integer> customList = initializeCustomList(numberElements);
        java.util.List<Integer> defaultList = initializeDefaultList(numberElements);


        assertAll(() -> {
            for(int i=0; i<numberElements; i++) {
                assertEquals(defaultList.get(i), customList.get(i));
            }
        });
    }

    @Test
    public void test_toStringMethod() {
        int numberElements = 10;
        List<Integer> customList = initializeCustomList(numberElements);
        java.util.List<Integer> defaultList = initializeDefaultList(numberElements);

        assertEquals(defaultList.toString(), customList.toString());
    }
    @Test
    public void test_addFewValuesInTheMiddleOfList() {
        int numberElements = 25;
        List<Integer> customList = initializeCustomList(numberElements);
        java.util.List<Integer> defaultList = initializeDefaultList(numberElements);

        for(int i=1; i<25; i = i+4) {
            customList.add(i, 99);
            defaultList.add(i, 99);
        }

        assertEquals(defaultList.toString(), customList.toString());
    }

    @Test
    public void test_addValueOnFirstIndex() {
        int numberElements = 3;
        List<Integer> customList = initializeCustomList(numberElements);
        java.util.List<Integer> defaultList = initializeDefaultList(numberElements);

        customList.add(0, -1);
        defaultList.add(0, -1);

        assertEquals(defaultList.toString(), customList.toString());
    }

    @Test
    public void test_addValueOnLastIndex() {
        int numberElements = 3;
        List<Integer> customList = initializeCustomList(numberElements);
        java.util.List<Integer> defaultList = initializeDefaultList(numberElements);

        customList.add(customList.size(), -1);
        defaultList.add(defaultList.size(), -1);

        assertEquals(defaultList.toString(), customList.toString());
    }

    @Test
    public void test_addValueOnIndexBiggerThanSize() {
        int numberElements = 7;
        List<Integer> customList = initializeCustomList(numberElements);

        assertThrows(IndexOutOfBoundsException.class, () -> customList.add(customList.size()+5, -1));


    }

    @Test
    public void test_addValueOnNegativeIndex() {
        int numberElements = 3;
        List<Integer> customList = initializeCustomList(numberElements);

        assertThrows(IndexOutOfBoundsException.class, () -> customList.add(-5, -1));
    }




    @Test
    public void test_sizeOfList() {
        int numberElements = 25;
        List<Integer> customList = initializeCustomList(numberElements);
        java.util.List<Integer> defaultList = initializeDefaultList(numberElements);

        assertEquals(defaultList.size(), customList.size());
    }

    @Test
    public void test_sizeOfEmptyList() {
        List<Integer> customList = new LinkedList<>();
        java.util.List<Integer> defaultList = new java.util.LinkedList<>();

        assertEquals(defaultList.size(), customList.size());

    }

    @Test
    public void test_sizeOfListAfterRemove() {
        int numberElements = 33;
        List<Integer> customList = initializeCustomList(numberElements);
        java.util.List<Integer> defaultList = initializeDefaultList(numberElements);

        defaultList.remove(5);
        customList.remove(5);

        assertEquals(defaultList.size(), customList.size());
    }

    @Test
    public void test_removeFewElementsByIndex() {
        int numberElements = 13;
        List<Integer> customList = initializeCustomList(numberElements);
        java.util.List<Integer> defaultList = initializeDefaultList(numberElements);

        for(int i=12; i>0; i = i-3) {
            customList.remove(i);
            defaultList.remove(i);
        }

        assertEquals(defaultList.toString(), customList.toString());
    }

    @Test
    public void test_removeLastElementByIndex() {
        int numberElements = 22;
        List<Integer> customList = initializeCustomList(numberElements);
        java.util.List<Integer> defaultList = initializeDefaultList(numberElements);

        customList.remove(customList.size()-1);
        defaultList.remove(defaultList.size()-1);

        assertEquals(defaultList.toString(),customList.toString());

    }

    @Test
    public void test_removeByIndexBiggerThanSize() {
        int numberElements = 22;
        List<Integer> customList = initializeCustomList(numberElements);

        assertThrows(IndexOutOfBoundsException.class, () -> customList.remove(customList.size()+99));
    }

    @Test
    public void test_removeByNegativeIndex() {
        int numberElements = 17;
        List<Integer> customList = initializeCustomList(numberElements);

        assertThrows(IndexOutOfBoundsException.class, () -> customList.remove(-277));

    }

    @Test
    public void test_removeFirstElementByIndex() {
        int numberElements = 33;
        List<Integer> customList = initializeCustomList(numberElements);
        java.util.List<Integer> defaultList = initializeDefaultList(numberElements);

        defaultList.remove(0);
        customList.remove(0);

        assertEquals(defaultList.toString(), customList.toString());
    }

    @Test
    public void test_pop() {
        int numberElements = 33;
        LinkedList<Integer> customList = initializeCustomList(numberElements);
        java.util.LinkedList<Integer> defaultList = initializeDefaultList(numberElements);

        Integer lastDefaultElement = defaultList.pop();
        Integer lastCustomElement = customList.pop();

        assertAll(()-> {
            assertEquals(lastDefaultElement, lastCustomElement);
            assertEquals(defaultList.size(), customList.size());
        });

    }

    @Test
    public void test_emptyPop() {
        LinkedList<Integer> customList = new LinkedList<>();

        assertThrows(NoSuchElementException.class, customList::pop);
    }

    @Test
    public void test_push() {
        int numberElements = 4;
        Integer elementToPush = 78;
        LinkedList<Integer> customList = initializeCustomList(numberElements);
        java.util.LinkedList<Integer> defaultList = initializeDefaultList(numberElements);

        customList.push(elementToPush);
        defaultList.push(elementToPush);


        assertEquals(defaultList.toString(), customList.toString());

    }

    @Test
    public void test_emptyPush() {
        int numberElements = 4;
        Integer elementToPush = 78;
        LinkedList<Integer> customList = new LinkedList<>();
        java.util.LinkedList<Integer> defaultList = new java.util.LinkedList<>();

        customList.push(elementToPush);
        defaultList.push(elementToPush);


        assertEquals(defaultList.toString(), customList.toString());

    }

    @Test
    public void test_addFirst() {
        int numberElements = 2;
        Integer elementToAdd = 66;
        LinkedList<Integer> customList = initializeCustomList(22);
        java.util.LinkedList<Integer> defaultList = initializeDefaultList(22);

        customList.addFirst(elementToAdd);
        defaultList.addFirst(elementToAdd);

        assertEquals(defaultList.toString(), customList.toString());
    }

    @Test
    public void test_addFirstToEmpty() {

    }

    @Test
    public void test_addLast() {

    }

    @Test
    public void test_addLastToEmpty() {

    }

    @Test
    public void test_getFirst() {

    }

    @Test
    public void test_getFirstFromEmpty() {

    }

    @Test
    public void test_getLastFromEmpty() {

    }

    @Test
    public void test_clearList() {

    }

    @Test
    public void test_clearEmptyList() {

    }

    @Test
    public void test_containsPresentElement() {

    }

    @Test
    public void test_containsNotPresentElement() {

    }

    @Test
    public void test_containsEmptyList() {

    }

    @Test
    public void test_indexOfPresentElement() {

    }

    @Test
    public void test_indexOfNotPresentElement() {

    }

    @Test
    public void test_IndexOfPresentMoreThanOneElement() {

    }

    @Test
    public void test_indexOfEmptyList() {

    }

    @Test
    public void test_toArray() {

    }

    @Test
    public void test_toArrayFromEmpty() {

    }

    private LinkedList<Integer> initializeCustomList(int size) {
       LinkedList<Integer> customList = new LinkedList<>();

        for(int i=1; i<=size; i++) {
            customList.add(i);
        }
        return customList;
    }

    private java.util.LinkedList<Integer> initializeDefaultList(int size) {
        java.util.LinkedList<Integer> defaultList = new java.util.LinkedList<>();

         for(int i=1; i<=size; i++) {
            defaultList.add(i);
        }
        return defaultList;

    }

}