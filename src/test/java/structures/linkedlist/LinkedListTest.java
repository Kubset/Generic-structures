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
            assertEquals(22, ll.get(0));
            assertEquals(2, ll.get(1));
            assertEquals(1, ll.get(2));
            assertEquals(32, ll.get(3));
            assertEquals(22, ll.get(4));
        });

    }

}