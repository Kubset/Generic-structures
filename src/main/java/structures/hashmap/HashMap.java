package structures.hashmap;

import java.util.*;

public class HashMap<K,V> {
    public int bucketSize;
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



    public boolean containsKey(K key) {
        boolean isKey = false;

        for(int i=0; i<elements.length; i++) {
            if(elements[i] != null) {
                for(KeyValue kv : elements[i]) {
                    if(kv.getKey().equals(key)) {
                        isKey = true;
                    }
                }
            }
        }
        return isKey;
    }

    public boolean containsValue(V value) {
        boolean isValue = false;

        for(int i=0; i<elements.length; i++) {
            if(elements[i] != null) {
                for(KeyValue kv : elements[i]) {
                    if(kv.getValue().equals(value)) {
                        isValue = true;
                    }
                }
            }
        }
        return isValue;
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
        resizeIfNeeded();
        KeyValue<K,V> keyValue = new KeyValue<K,V>(key, value);
        boolean isKeyPresent = false;
        int position = getHash(key);
        if(elements[position] == null) {
            elements[position] = new LinkedList<>();
            elements[position].add(keyValue);
            size++;
        } else {
            for(KeyValue<K,V> kv : elements[position]) {
                if(kv.getKey().equals(key)) {
                    kv.setValue(value);
                    isKeyPresent = true;
                }
            }
            if(!isKeyPresent) {
                elements[position].add(keyValue);
                size++;
            }

        }
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

    private void resizeIfNeeded() {
        if(size > bucketSize*loadFactor) {
            initializeNewBucket();
            bucketSize *= 2;
        } else if(size < bucketSize*loadFactor/2) {
            initializeNewBucket();
            bucketSize /= 2;
        }



    }

    private void initializeNewBucket() {
        LinkedList<KeyValue<K,V>>[] temp = new LinkedList[bucketSize*2];
        KeyValue<K,V> keyValue;
        for(K key : keySet()) {
            keyValue = new KeyValue<>(key, get(key));
            int position = getHash(key);
            if(temp[position] == null) {
                temp[position] = new LinkedList<>();
            }
            temp[position].add(keyValue);
       }
       elements = temp;
    }
}
