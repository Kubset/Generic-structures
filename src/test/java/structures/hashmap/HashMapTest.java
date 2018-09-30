package structures.hashmap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashMapTest {

    @Test
    protected void test_addFewElementsToHashMap() {
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(11,22);
        hm.put(10,1);
        hm.put(2,4);
        hm.put(3,222);

        assertAll(() -> {
            assertEquals(new Integer(22), hm.get(11));
            assertEquals(new Integer(1), hm.get(10));
            assertEquals(new Integer(4), hm.get(2));
            assertEquals(new Integer(222), hm.get(3));
                });
    }


}