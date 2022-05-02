package com.example.prectise;

class A {
    A() {
        greeting();
        prints();

    }

    static void prints() {
        System.out.println("sattic print A");

    }

    void greeting() {
        System.out.println("greeting A");

    }

}

class B extends A {
    B() {
        ///super();
        greeting();
        prints();
    }

    static void prints() {
        System.out.println("sattic print B");

    }

    void greeting() {
        System.out.println("greeting B");

    }

}

public class ArrayOfTypeT<T> {

    public static void main(String[] args) {
        //// T[] result=new T[10];
        // TODO Auto-generated method stub
        A a=new B();
        System.out.println("*************************");
        B b = new B();
        System.out.println("*************************");
        A a1 = new A();
    }

}
