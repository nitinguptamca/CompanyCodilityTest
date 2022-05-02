package com.prectise.tough.customeHashMap;

public class CustomHashMap<K extends Comparable<K>, V> {
    private Entry<K, V>[] table;
    private int capacity = 4;

    public CustomHashMap(int capacity) {
        table = new Entry[capacity];
    }

    private static class Entry<K extends Comparable<K>, V> {
        K key;
        V value;
        Entry<K, V> next;

        Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public String toString() {
            return "{" + "key=" + key + ", value=" + value + '}';
        }
    }

    public void put(K newKey, V newValue) {
        //base case
        if (newKey == null) return;
        int hash = hashFunction(newKey);
        Entry<K, V> newEntry = new Entry<K, V>(newKey, newValue, null);

        if (table[hash] == null) {
            table[hash] = newEntry;
        } else {
            Entry<K, V> previous = null;
            Entry<K, V> current = table[hash];
            while (current != null) {
                if (current.key.compareTo(newKey) == 0) {
                    if (previous == null) { // node has to be insert on first of bucket.
                        newEntry.next = current.next;
                        table[hash] = newEntry;
                        return;
                    } else {
                        newEntry.next = current.next;
                        previous.next = newEntry;
                        return;
                    }
                }
                previous = current;
                current = current.next;
            }
            previous.next = newEntry;
        }

    }

    public void display() {

        for (int i = 0; i < capacity; i++) {
            if (table[i] != null) {
                Entry<K, V> entry = table[i];
                while (entry != null) {
                    System.out.print(entry);
                    entry = entry.next;
                }
            }
        }

    }

    public boolean remove(K deleteKey) {

        int hash = hashFunction(deleteKey);

        if (table[hash] == null) {
            return false;
        } else {
            Entry<K, V> previous = null;
            Entry<K, V> current = table[hash];

            while (current != null) { // we have reached last entry node of bucket.
                if (current.key.compareTo(deleteKey) == 0) {
                    if (previous == null) { // delete first entry node.
                        table[hash] = table[hash].next;
                        return true;
                    } else {
                        previous.next = current.next;
                        return true;
                    }
                }
                previous = current;
                current = current.next;
            }
            return false;
        }

    }

    public V get(K key) {
        int hash = hashFunction(key);
        if (table[hash] == null) {
            return null;
        } else {
            Entry<K, V> temp = table[hash];
            while (temp != null) {
                if (temp.key.compareTo(key) == 0)
                    return temp.value;
                temp = temp.next; // return value corresponding to key.
            }
            return null; // returns null if key is not found.
        }
    }

    private int hashFunction(K newKey) {
        return Math.abs(newKey.hashCode()) % capacity;
    }
}
