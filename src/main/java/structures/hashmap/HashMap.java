package structures.hashmap;

import java.util.*;

public class HashMap<K,V> {
    private int bucketSize;
    private float loadFactor;
    private LinkedList<KeyValue<K,V>>[] elements;
    private int size;


    public HashMap() {
        size = 0;
        bucketSize = 16;
        loadFactor = 0.8F;
        this.elements = new LinkedList[bucketSize];
    }

    public HashMap(int bucketSize) {
        size = 0;
        this.loadFactor = 0.8F;
        this.bucketSize = bucketSize;
        this.elements = new LinkedList[bucketSize];
    }

    public HashMap(int bucketSize, float loadFactor) {
        size = 0;
        this.loadFactor = loadFactor;
        this.bucketSize = bucketSize;
        this.elements = new LinkedList[bucketSize];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }



    public boolean containsKey(Object key) {
        return false;
    }

    public boolean containsValue(Object value) {
        return false;
    }

    public V get(K key) {
        int position = getHash(key);
        if (elements[position] == null) return null;
        else {
            for(KeyValue<K,V> keyValue: elements[position]) {
                if(keyValue.getKey().equals(key)) {
                    return keyValue.getValue();
                }
            }
        }
        return null;
    }

    public void put(K key, V value) {
        KeyValue<K,V> keyValue = new KeyValue<K,V>(key, value);
        int position = getHash(key);
        elements[position] = new LinkedList<>();
        elements[position].add(keyValue);
        size++;
    }

    public void remove(K key) {
        int position = getHash(key);
        if(elements[position] != null) {
            for(int i=0; i<elements[position].size(); i++) {
                if(elements[position].get(i).getKey().equals(key)) {
                    elements[position].remove(i);
                    size--;
                }
            }
        }


    }

//    public void putAll(Map m) {
//
//    }

    public void clear() {
        elements = new LinkedList[bucketSize];
        size = 0;
    }

    public Set<K> keySet() {
        Set<K> keys = new HashSet<>();
        for(int i=0; i<elements.length;i++) {
            if(elements[i] != null) {
                elements[i].forEach((keyValue) -> keys.add(keyValue.getKey()));
            }
        }
        return keys;
    }


    public Set<V> values() {
         Set<V> values = new HashSet<>();
        for(int i=0; i<elements.length;i++) {
            if(elements[i] != null) {
                elements[i].forEach((keyValue) -> values.add(keyValue.getValue()));
            }
        }
        return values;
    }

    private int getHash(K key) {
        return key.hashCode() % bucketSize;
    }
}
