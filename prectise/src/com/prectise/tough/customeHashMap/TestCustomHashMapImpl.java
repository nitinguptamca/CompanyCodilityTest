package com.prectise.tough.customeHashMap;

public class TestCustomHashMapImpl {
    public static void main(String[] args) {
        CustomHashMap<Integer, Integer> hashMapCustom = new CustomHashMap<>(4);
        hashMapCustom.put(21, 12);
        hashMapCustom.put(25, 121);
        hashMapCustom.put(30, 151);
        hashMapCustom.put(33, 15);
        hashMapCustom.put(35, 89);
        hashMapCustom.put(211, 12);
        hashMapCustom.put(215, 121);
        hashMapCustom.put(310, 151);
        hashMapCustom.put(313, 15);
        hashMapCustom.put(315, 89);

        System.out.println("value corresponding to key 21=" + hashMapCustom.get(21));
        System.out.println("value corresponding to key 51=" + hashMapCustom.get(51));

        System.out.print("Displaying : ");
        hashMapCustom.display();

        System.out.println("\n\nvalue corresponding to key 21 removed: " + hashMapCustom.remove(21));
        System.out.println("value corresponding to key 51 removed: " + hashMapCustom.remove(51));

        System.out.print("Displaying : ");
        hashMapCustom.display();
    }
}
