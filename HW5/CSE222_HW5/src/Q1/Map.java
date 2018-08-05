package Q1;

public interface Map<K, V> {

    V get(Object key);
    V put(K key, V value) throws Exception;
    V remove(Object key) throws Exception;
    int size();
    boolean isEmpty();
}
