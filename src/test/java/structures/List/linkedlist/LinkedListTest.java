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
    public void test_addFewParametersInTheMiddleOfList() {

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