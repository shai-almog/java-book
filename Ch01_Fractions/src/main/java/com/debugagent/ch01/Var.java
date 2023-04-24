package com.debugagent.ch01;

public class Var {
    static class MyObject {}

    public static void main(String[] argv) {
        MyObject object1 = new MyObject();
        MyObject object2 = new MyObject();

        // Prints true
        System.out.println(object1.getClass() == object2.getClass());

        var arr1 = new MyObject[1];
        var arr2 = new MyObject[10];

        // Prints true, despite arrays of different size
        System.out.println(arr1.getClass() == arr2.getClass());

        var arr3 = new MyObject[10][10];

        // Compilation error of incomparable types
        //System.out.println(arr1.getClass() == arr3.getClass());
    }
}
