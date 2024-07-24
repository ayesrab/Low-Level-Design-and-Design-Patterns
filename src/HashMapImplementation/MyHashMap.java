package HashMapImplementation;

import java.util.Map;

public class MyHashMap<K, V> {
    private static final int DEFAULT_CAPACITY = 1 << 4;
    private static final int MAXIMUM_CAPACITY = 1 << 30;

    Entry[] hashTable;

    public MyHashMap() {
        hashTable = new Entry[DEFAULT_CAPACITY];
    }

    public MyHashMap(int capacity) {
        int tableSize = getTableSize(capacity);
        hashTable = new Entry[tableSize];
    }

    public int getTableSize(int capacity) {
        int n = capacity - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

    public void put(K key, V value) {
        int hashCode = key.hashCode();
        Entry node = hashTable[hashCode];
        if (node == null) {
            hashTable[hashCode] = new Entry(key, value);
        }
        else {
            Entry previous = node;
            while (node != null) {
                if (node.key == key) {
                    node.value = value;
                    return;
                }
                previous = node;
                node = node.next;
            }
            Entry newNode = new Entry(key, value);
            previous.next = newNode;
        }
    }

    public V get(K key) {
        int hashCode = key.hashCode();
        Entry node = hashTable[hashCode];
        while (node != null) {
            if (node.key == key) {
                return (V) node.value;
            }
            node = node.next;
        }
        return null;
    }

    class Entry<K, V> {
        K key;
        V value;
        Entry next;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
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
    public static void main(String[] args) {
        MyHashMap<Integer, String> map = new MyHashMap<Integer, String>(16);
        map.put(1, "hi");
        map.put(2, "my");
        map.put(3, "name");
        map.put(4, "is");
        map.put(5, "Ashab");
        map.put(6, "how");
        map.put(7, "are");
        map.put(8, "you");
        map.put(9, "friends");
        map.put(10, "?");

        String value = map.get(8);
        System.out.println(value);

    }
}
