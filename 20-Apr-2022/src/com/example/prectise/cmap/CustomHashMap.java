package com.example.prectise.cmap;

public class CustomHashMap<K extends Comparable<K>, V> {

    private Entry<K, V>[] table;
    private int capcity;

    public CustomHashMap(int capcity) {
        this.capcity = capcity;
        table = new Entry[capcity];
    }

    public void put(K newKey, V newValue) {
        int newHashValue = getHashValue(newKey);
        Entry<K, V> newEntry = new Entry<>(newKey, newValue, null);
        if (table[newHashValue] == null) {
            table[newHashValue] = newEntry;
        } else {
            Entry<K, V> previous = null;
            Entry<K, V> current = table[newHashValue];

            while (current != null) { // we have reached last entry of bucket.
                if (current.key.equals(newKey)) {
                    if (previous == null) { // node has to be insert on first of bucket.
                        newEntry.next = current.next;
                        table[newHashValue] = newEntry;
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

    private int getHashValue(K newKey) {
        return newKey.hashCode() % capcity;
    }


    public void printAll() {
        System.out.println();
        for (int i = 0; i < table.length; i++) {
            Entry<K, V> entry = table[i];
            while (entry != null) {
                System.out.print(entry);
                entry = entry.next;
            }
        }
    }

    public boolean remove(K searchKey) {
        int hashValue = getHashValue(searchKey);
        if (table[hashValue] == null) {
            return false;
        } else {
            Entry<K, V> current = table[hashValue];
            while (current != null) {
                if (current.key.compareTo(searchKey) == 0) {
                    table[hashValue] = table[hashValue].next;
                }
                current = current.next;

            }
            return true;
        }
    }

    public V get(K searchKey) {
        int hashcode = getHashValue(searchKey);
        if (table[hashcode] == null) {
            return null;
        } else {
            Entry<K, V> entry = table[hashcode];
            while (entry != null) {
                if (entry.key.compareTo(searchKey) == 0) {
                    return entry.value;
                }
                entry = entry.next;
            }
        }
        return null;
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
            return " { " + "key=" + key + ", value=" + value + '}';
        }
    }
}
