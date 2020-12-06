package Practice.Practice_25_26;

public class Sample<K,V> {
        K key;
        V value;

    public Sample(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public Sample() {

    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}
