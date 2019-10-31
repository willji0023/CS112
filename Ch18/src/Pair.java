public class Pair<K, V> {
    private K key; // element 1
    private V value; // element 2

    public Pair(K e1, V e2) {
        key = e1;
        value = e2;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public String toString() {
        return key + " " + value + "\n";
    }
}
