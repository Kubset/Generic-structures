package structures.List.linkedlist;

import org.junit.jupiter.api.Test;
import structures.List.List;


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

    }

    @Test
    public void test_addValueOnNegativeIndex() {

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

    }

    @Test
    public void test_removeByIndexBiggerThanSize() {

    }

    @Test
    public void test_removeByNegativeIndex() {

    }

    @Test
    public void test_removeFirstElementByIndex() {

    }

    private List<Integer> initializeCustomList(int size) {
       List<Integer> customList = new LinkedList<>();

        for(int i=1; i<=size; i++) {
            customList.add(i);
        }
        return customList;
    }

    private java.util.List<Integer> initializeDefaultList(int size) {
        java.util.List<Integer> defaultList = new java.util.LinkedList<>();

         for(int i=1; i<=size; i++) {
            defaultList.add(i);
        }
        return defaultList;

    }

}