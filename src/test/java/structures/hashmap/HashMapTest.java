package structures.hashmap;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.*;

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
        hm.put(71,4);
        hm.put(83,222);
        int increasedSize = hm.size();

         assertAll(() -> {
            assertEquals(6, size);
            assertEquals(8, increasedSize);
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

    @Test
    protected void test_removeAbsentKey() {
        HashMap<Integer, Integer> hm = produceFilledHashMap();
        int size = hm.size();

        hm.remove(9999);

        assertEquals(size, hm.size());
    }

    @Test
    protected void test_increasingBucket() throws IllegalAccessException, NoSuchFieldException {
        HashMap<Integer, Integer> hm = produceFilledHashMap(1000);
        Field f = hm.getClass().getDeclaredField("bucketSize");
        f.setAccessible(true);
        int bucketSize = (int) f.get(hm);

        assertEquals(2048, bucketSize);
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

    private HashMap<Integer, Integer> produceFilledHashMap(int size) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        List<Integer> keys = new ArrayList<>();
        List<Integer> values = new ArrayList<>();
        initialize(keys, size);
        initialize(values, size);

        for(int i=0 ;i<size; i++) {
            hm.put(keys.get(i), values.get(i));
        }

        return hm;
    }


    public static void initialize(List<Integer> list, int size) {
       Random rand = new Random();
       for(int i=0; i<size; i++) {
           list.add(rand.nextInt(10000000));
       }
    }

}