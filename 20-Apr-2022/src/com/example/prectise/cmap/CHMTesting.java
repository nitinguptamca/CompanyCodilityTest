package com.example.prectise.cmap;

public class CHMTesting {
    public static void main(String[] args) {
        CustomHashMap<Integer, Integer> map = new CustomHashMap<>(4);
        map.put(1, 1);
        map.put(12, 2);
        map.put(3, 3);
        map.put(5, 3);
        map.put(11, 42);
        map.put(13, 12);
        map.put(16, 14);
        map.put(122, 14);
        map.put(1, 10);
        map.printAll();
        map.remove(12);
        map.printAll();
        map.get(122);
    }
}
