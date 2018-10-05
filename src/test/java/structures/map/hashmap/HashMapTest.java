package structures.map.hashmap;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class HashMapTest {

    @Test
    protected void test_addFewElementsToEmptyHashMap() {
        int mapSize = 22;
        HashMap<Integer, Integer> customMap = initializeCustomHashMap(mapSize);
        java.util.HashMap<Integer,Integer> defaultMap = initializeDefaultHashMap(mapSize);

        assertAll(() -> {
            assertEquals(defaultMap.get(2), customMap.get(2));
            assertEquals(defaultMap.get(4), customMap.get(4));
            assertEquals(defaultMap.get(7), customMap.get(7));
            assertEquals(defaultMap.get(9), customMap.get(9));
            assertEquals(defaultMap.get(1), customMap.get(1));
        });
    }

    @Test
    public void test_addFewElementsToImplementedMap() {
        int mapSize = 22;
        HashMap<Integer, Integer> customMap = initializeCustomHashMap(mapSize);
        java.util.HashMap<Integer,Integer> defaultMap = initializeDefaultHashMap(mapSize);

        customMap.put(100,0);
        customMap.put(90,0);
        defaultMap.put(100,0);
        defaultMap.put(90,0);

         assertAll(() -> {
            assertEquals(mapSize+2, customMap.size());
            assertEquals(defaultMap.toString(), customMap.toString());
                });
    }

    @Test
    public void test_removeFewElements() {
        int mapSize = 22;
        HashMap<Integer, Integer> customMap = initializeCustomHashMap(mapSize);
        java.util.HashMap<Integer,Integer> defaultMap = initializeDefaultHashMap(mapSize);

        defaultMap.remove(2);
        defaultMap.remove(8);
        customMap.remove(2);
        customMap.remove(8);

        assertAll(() -> {
            assertEquals(defaultMap.size(), customMap.size());
            assertEquals(defaultMap.toString(), customMap.toString());
        });

    }

    @Test
    public void test_removeNotPresentElement() {
        int mapSize = 17;
        HashMap<Integer, Integer> customMap = initializeCustomHashMap(mapSize);
        java.util.HashMap<Integer,Integer> defaultMap = initializeDefaultHashMap(mapSize);

        defaultMap.remove(222);
        defaultMap.remove(123);
        customMap.remove(123);
        customMap.remove(222);

        assertAll(() -> {
            assertEquals(defaultMap.size(), customMap.size());
            assertEquals(defaultMap.toString(), customMap.toString());
        });

    }
    @Test
    public void test_removeFromEmptyMap() {

    }

    @Test
    public void test_toStringMethod() {

    }

    @Test
    public void test_toStringOnEmptyMap() {

    }

    @Test
    protected void test_cleanMap() {
        int mapSize = 12;
        HashMap<Integer, Integer> customMap = initializeCustomHashMap(mapSize);

        customMap.clear();

        assertAll(() -> {
            assertEquals(0, customMap.size());
            assertEquals("{}", customMap.toString());
        });

    }

    @Test
    protected void test_isEmpty() {
        int mapSize = 22;
        HashMap<Integer, Integer> customMap = initializeCustomHashMap(mapSize);

        boolean notEmpty = customMap.isEmpty();
        customMap.clear();
        boolean empty = customMap.isEmpty();

        assertAll(() -> {
            assertTrue(empty);
            assertFalse(notEmpty);
        });
    }

    @Test
    protected void test_returnKeySet() {
        int mapSize = 22;
        HashMap<Integer, Integer> customMap = initializeCustomHashMap(mapSize);
        java.util.HashMap<Integer,Integer> defaultMap = initializeDefaultHashMap(mapSize);

        assertEquals(defaultMap.keySet(), customMap.keySet());
    }


    @Test
    protected void test_returnEmptyKeySet() {
        int mapSize = 22;
        HashMap<Integer, Integer> customMap = new HashMap<>();
        java.util.HashMap<Integer,Integer> defaultMap = new java.util.HashMap<>();

        assertEquals(defaultMap.keySet(), customMap.keySet());
    }

    @Test
    protected void test_returnValues() {
        int mapSize = 4;
        HashMap<Integer, Integer> customMap = initializeCustomHashMap(mapSize);
        Set<Integer> expectedSet = new HashSet<>();
        expectedSet.add(0);
        expectedSet.add(1);
        expectedSet.add(2);
        expectedSet.add(3);


        assertEquals(expectedSet, customMap.values());
 }

    @Test
    protected void test_returnEmptyValues() {
        HashMap<Integer, Integer> customMap = new HashMap<>();
        Set<Integer> expectedSet = new HashSet<>();

        assertEquals(expectedSet, customMap.values());
    }

    @Test
    protected void test_containsPresentKey() {
        int mapSize = 11;
        HashMap<Integer, Integer> customMap = initializeCustomHashMap(mapSize);

        assertAll(() -> {
            assertTrue(customMap.containsKey(2));
            assertTrue(customMap.containsKey(5));
            assertTrue(customMap.containsKey(7));
            assertTrue(customMap.containsKey(1));
        });
    }

    @Test
    public void test_ContainsNoPresentKey() {

    }

    @Test
    protected void test_containsPresentValue() {
         int mapSize = 11;
         HashMap<Integer, Integer> customMap = initializeCustomHashMap(mapSize);

         assertAll(() -> {
            assertTrue(customMap.containsValue(2));
            assertTrue(customMap.containsValue(5));
            assertTrue(customMap.containsValue(7));
            assertTrue(customMap.containsValue(1));
         });
    }

    @Test
    protected void test_containsNoPresentValue() {

    }

    @Test
    protected void test_putToPresentKey() {
        int mapSize = 8;
        HashMap<Integer, Integer> customMap = initializeCustomHashMap(mapSize);

        customMap.put(5, 111);
        customMap.put(1,999);

        assertAll(() -> {
            assertTrue(customMap.containsValue(111));
            assertTrue(customMap.containsValue(999));
            assertEquals(mapSize, customMap.size());
        });
    }

    @Test
    protected void test_removeAbsentKey() {
        int mapSize = 5;
        HashMap<Integer, Integer> customMap = initializeCustomHashMap(mapSize);
        java.util.HashMap<Integer,Integer> defaultMap = initializeDefaultHashMap(mapSize);

        customMap.remove(111);


        assertAll(() -> {
            assertEquals(defaultMap.size(), customMap.size());
            assertEquals(defaultMap.toString(), customMap.toString());
        });

    }

    @Test
    protected void test_increaseBucketSize() throws IllegalAccessException, NoSuchFieldException {
        int mapSize = 1200;
        HashMap<Integer, Integer> customMap = initializeCustomHashMap(mapSize);
        java.util.HashMap<Integer,Integer> defaultMap = initializeDefaultHashMap(mapSize);

        Field f = customMap.getClass().getDeclaredField("bucketSize");
        f.setAccessible(true);
        int customBucketSize = (int) f.get(customMap);

        Field f2 = defaultMap.getClass().getDeclaredField("table");
        f2.setAccessible(true);
        Object[] defaultBucketSize = (Object[]) f2.get(defaultMap);


        assertEquals(defaultBucketSize.length, customBucketSize);

    }

    @Test
    protected void test_increaseBucketSizeWithCustomLoadFactor() throws IllegalAccessException, NoSuchFieldException {
        int mapSize = 516;
        HashMap<Integer, Integer> customMap = initializeCustomHashMap(mapSize, 0.5f);
        java.util.HashMap<Integer,Integer> defaultMap = initializeDefaultHashMap(mapSize, 0.5f);

        Field f = customMap.getClass().getDeclaredField("bucketSize");
        f.setAccessible(true);
        int customBucketSize = (int) f.get(customMap);

        Field f2 = defaultMap.getClass().getDeclaredField("table");
        f2.setAccessible(true);
        Object[] defaultBucketSize = (Object[]) f2.get(defaultMap);


        assertEquals(defaultBucketSize.length, customBucketSize);
   }

    private HashMap<Integer, Integer> initializeCustomHashMap(int size) {
        List<Integer> keys = initializeList(size);
        List<Integer> values = initializeList(size);
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<size; i++) {
           map.put(keys.get(i), values.get(i));
        }

        return map;
    }

    private HashMap<Integer, Integer> initializeCustomHashMap(int size, float loadFactor) {
        List<Integer> keys = initializeList(size);
        List<Integer> values = initializeList(size);
        HashMap<Integer, Integer> map = new HashMap<>(16,loadFactor);
        for(int i=0; i<size; i++) {
           map.put(keys.get(i), values.get(i));
        }

        return map;
    }

    private java.util.HashMap<Integer, Integer> initializeDefaultHashMap(int size, float loadFactor) {
        List<Integer> keys = initializeList(size);
        List<Integer> values = initializeList(size);
        java.util.HashMap<Integer, Integer> map = new java.util.HashMap<>(16, loadFactor);
        for(int i=0; i<size; i++) {
           map.put(keys.get(i), values.get(i));
        }

        return map;

    }

    private java.util.HashMap<Integer, Integer> initializeDefaultHashMap(int size) {
        List<Integer> keys = initializeList(size);
        List<Integer> values = initializeList(size);
        java.util.HashMap<Integer, Integer> map = new java.util.HashMap<>();
        for(int i=0; i<size; i++) {
           map.put(keys.get(i), values.get(i));
        }

        return map;

    }


    private List<Integer> initializeList(int size) {
        List<Integer> result = new ArrayList<>();
        for(int i=0; i<size; i++) {
           result.add(i);
        }
        return result;
    }

}