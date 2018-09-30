package structures.hashmap;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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

    @Test
    protected void test_isEmpty() {
        HashMap<Integer, Integer> hm = produceFilledHashMap();

        boolean notEmpty = hm.isEmpty();
        hm.clear();
        boolean empty = hm.isEmpty();


        assertAll(() -> {
            assertTrue(empty);
            assertFalse(notEmpty);
        });
    }

    @Test
    protected void test_returnKeySet() {
        HashMap<Integer, Integer> hm = produceFilledHashMap();

        Set<Integer> result = hm.keySet();
        Set<Integer> expected = new HashSet<>(Arrays.asList(10,2,3,100,0,22));

        assertEquals(expected, result);
    }

    @Test
    protected void test_returnEmptyKeySet() {
        HashMap<Integer, Integer> hm = new HashMap<>();

        Set<Integer> emptySet = new HashSet<>();

        assertEquals(emptySet, hm.keySet());
    }

    @Test
    protected void test_returnValues() {
        HashMap<Integer, Integer> hm = produceFilledHashMap();

        Set<Integer> result = hm.values();
        Set<Integer> expected = new HashSet<>(Arrays.asList(1,4,222,12,422,2222));

        assertEquals(expected, result);
    }

    @Test
    protected void test_returnEmptyValues() {
        HashMap<Integer, Integer> hm = new HashMap<>();

        Set<Integer> emptySet = new HashSet<>();

        assertEquals(emptySet, hm.values());
    }

    @Test
    protected void test_containsKey() {
        HashMap<Integer, Integer> hm = produceFilledHashMap();

        boolean notPresentKey = hm.containsKey(1234567);
        boolean presentKey = hm.containsKey(10);

        assertAll(() -> {
            assertTrue(presentKey);
            assertFalse(notPresentKey);
        });

    }

    @Test
    protected void containsValue() {
        HashMap<Integer, Integer> hm = produceFilledHashMap();

        boolean notPresentValue = hm.containsValue(1234567);
        boolean presentValue = hm.containsValue(222);

        assertAll(() -> {
            assertTrue(presentValue);
            assertFalse(notPresentValue);
        });

    }

    @Test
    protected void test_putToPresentKey() {
        HashMap<Integer, Integer> hm = produceFilledHashMap();
        int size = hm.size();

        hm.put(10,222);


        assertAll(() -> {
            assertEquals(size, hm.size());
            assertEquals(new Integer(222), hm.get(10));
        });

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