package structures.map;

import java.util.Collection;
import java.util.Set;

public interface Map<K,V> {
    public void clear();
    public boolean containsKey(K key);
    public boolean containsValue(V value);
    public V get(K key);
    public boolean isEmpty();
    Set<K> keySet();
    public void put(K key, V value);
    public Collection<V> values();
    public int size();
    public void remove(K key);
}
