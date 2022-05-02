package com.example.prectise;

public class EqualityCheck {

        public static void main(String[] args) {

            String s = "java";
            Object o = s;
            if (o.equals(s)) {
                System.out.println("A");
            } else {
                System.out.println("B");
            }
            if (s==o) {
                System.out.println("C");
            } else {
                System.out.println("D");
            }

        }

   }


