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
    public void test_ToStringMethodOnEmptyList() {
        List<Integer> customList = new LinkedList<>();
        java.util.List<Integer> defaultList = new java.util.LinkedList<>();

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
        LinkedList<Integer> customList = initializeCustomList(numberElements);
        java.util.LinkedList<Integer> defaultList = initializeDefaultList(numberElements);

        customList.addFirst(elementToAdd);
        defaultList.addFirst(elementToAdd);

        assertEquals(defaultList.toString(), customList.toString());
    }

    @Test
    public void test_addFirstToEmpty() {
        Integer elementToAdd = 999;
        LinkedList<Integer> customList = new LinkedList<>();
        java.util.LinkedList<Integer> defaultList = new java.util.LinkedList<>();

        customList.addFirst(elementToAdd);
        defaultList.addFirst(elementToAdd);

        assertEquals(defaultList.toString(), customList.toString());
    }

    @Test
    public void test_addLast() {
        int numberElements = 17;
        Integer elementToAdd = 22;
        LinkedList<Integer> customList = initializeCustomList(numberElements);
        java.util.LinkedList<Integer> defaultList = initializeDefaultList(numberElements);

        customList.addLast(elementToAdd);
        defaultList.addLast(elementToAdd);

        assertEquals(defaultList.toString(), customList.toString());
    }

    @Test
    public void test_addLastToEmpty() {
        Integer elementToAdd = 227;
        LinkedList<Integer> customList = new LinkedList<>();
        java.util.LinkedList<Integer> defaultList = new java.util.LinkedList<>();

        customList.addFirst(elementToAdd);
        defaultList.addFirst(elementToAdd);

        assertEquals(defaultList.toString(), customList.toString());
    }

    @Test
    public void test_getFirst() {
        int numberElements = 77;
        LinkedList<Integer> customList = initializeCustomList(numberElements);
        java.util.LinkedList<Integer> defaultList = initializeDefaultList(numberElements);

        Integer defaultLastElement = customList.getFirst();
        Integer customLastElement = defaultList.getFirst();

        assertAll(() -> {
            assertEquals(defaultLastElement, customLastElement);
            assertEquals(defaultList.toString(), customList.toString());
        });
    }

    @Test
    public void test_getFirstFromEmpty() {
        LinkedList<Integer> customList = new LinkedList<>();

        assertThrows(NoSuchElementException.class, customList::getFirst);
    }

    @Test
    public void test_getLastFromEmpty() {
        LinkedList<Integer> customList = new LinkedList<>();

        assertThrows(NoSuchElementException.class, customList::getLast);
    }

    @Test
    public void test_clearList() {
        int numberElements = 222;
        LinkedList<Integer> customList = initializeCustomList(numberElements);
        java.util.LinkedList<Integer> defaultList = initializeDefaultList(numberElements);

        customList.clear();
        defaultList.clear();

        assertAll(() -> {
            assertEquals(defaultList.size(), customList.size());
            assertEquals(defaultList.toString(), customList.toString());
        });


    }

    @Test
    public void test_clearEmptyList() {
        LinkedList<Integer> customList = new LinkedList<>();
        java.util.LinkedList<Integer> defaultList = new java.util.LinkedList<>();

        customList.clear();
        defaultList.clear();

        assertEquals(defaultList.toString(),customList.toString());
    }

    @Test
    public void test_containsPresentElement() {
        int numberElements = 20;
        LinkedList<Integer> customList = initializeCustomList(numberElements);
        java.util.LinkedList<Integer> defaultList = initializeDefaultList(numberElements);

        boolean defaultContains = defaultList.contains(10);
        boolean customContains = defaultList.contains(10);

        assertAll(() -> {
            assertEquals(defaultContains, customContains);
            assertEquals(defaultList.toString(), customList.toString());
        });

    }

    @Test
    public void test_containsPresentElementOnFirstPlace() {
        int numberElements = 22;
        LinkedList<Integer> customList = initializeCustomList(numberElements);
        java.util.LinkedList<Integer> defaultList = initializeDefaultList(numberElements);

        customList.add(0,-12);
        defaultList.add(0,-12);

        boolean defaultContains = defaultList.contains(-12);
        boolean customContains = defaultList.contains(-12);

        assertAll(() -> {
            assertEquals(defaultContains, customContains);
            assertEquals(defaultList.toString(), customList.toString());
        });

    }

    @Test
    public void test_containsPresentElementOnLastPlace() {
        int numberElements = 38;
        Integer expectedElement = -10;
        LinkedList<Integer> customList = initializeCustomList(numberElements);
        java.util.LinkedList<Integer> defaultList = initializeDefaultList(numberElements);

        customList.add(expectedElement);
        defaultList.add(expectedElement);

        boolean defaultContains = defaultList.contains(expectedElement);
        boolean customContains = defaultList.contains(expectedElement);

        assertAll(() -> {
            assertEquals(defaultContains, customContains);
            assertEquals(defaultList.toString(), customList.toString());
        });

    }

    @Test
    public void test_containsNotPresentElement() {
        int numberElements = 28;
        LinkedList<Integer> customList = initializeCustomList(numberElements);
        java.util.LinkedList<Integer> defaultList = initializeDefaultList(numberElements);

        boolean defaultContains = defaultList.contains(-13);
        boolean customContains = defaultList.contains(-13);

        assertEquals(defaultContains, customContains);
    }

    @Test
    public void test_containsEmptyList() {
        LinkedList<Integer> customList = new LinkedList<>();
        java.util.LinkedList<Integer> defaultList = new java.util.LinkedList<>();

        boolean defaultContains = defaultList.contains(0);
        boolean customContains = defaultList.contains(0);

        assertEquals(defaultContains, customContains);
    }

    @Test
    public void test_indexOfPresentElement() {
        int numberElements = 28;
        LinkedList<Integer> customList = initializeCustomList(numberElements);
        java.util.LinkedList<Integer> defaultList = initializeDefaultList(numberElements);

        customList.add(11,-9);
        defaultList.add(11,-9);

        assertAll(() -> {
            assertEquals(defaultList.indexOf(-9), customList.indexOf(-9));
            assertEquals(defaultList.toString(), customList.toString());
        });

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