package structures.linkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    @Test
    public void test_addFewElementsToLinkedList() {
        LinkedList<Integer> ll = new LinkedList<>();
        ll.add(22);
        ll.add(2);
        ll.add(1);
        ll.add(32);
        ll.add(22);
        assertAll(() -> {
            assertEquals(Integer.valueOf(22), ll.get(0));
            assertEquals(Integer.valueOf(2), ll.get(1));
            assertEquals(Integer.valueOf(1), ll.get(2));
            assertEquals(Integer.valueOf(32), ll.get(3));
            assertEquals(Integer.valueOf(22), ll.get(4));
        });

    }

}