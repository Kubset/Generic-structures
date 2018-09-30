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

    @Test
    protected void test_increaseSize() {
        HashMap<Integer, Integer> hm = produceFilledHashMap();
        int size = hm.size();
        hm.put(10,1);
        hm.put(2,4);
        hm.put(3,222);
        int increasedSize = hm.size();

         assertAll(() -> {
            assertEquals(6, size);
            assertEquals(9, increasedSize);
                });
    }

    @Test
    protected void test_reduceSize() {
        HashMap<Integer, Integer> hm = produceFilledHashMap();
        int size = hm.size();
        hm.remove(10);
        hm.remove(2);
        int reducedSize = hm.size();

        assertAll(() -> {
            assertEquals(6, size);
            assertEquals(4, reducedSize);
        });

    }

    @Test
    protected void test_cleanMap() {
        HashMap<Integer, Integer> hm = produceFilledHashMap();
        
        hm.clear();

        assertEquals(0, hm.size());

    }


    private HashMap<Integer, Integer> produceFilledHashMap() {
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(10,1);
        hm.put(2,4);
        hm.put(3,222);
        hm.put(100,12);
        hm.put(0,422);
        hm.put(22,2222);
        return hm;
    }

}