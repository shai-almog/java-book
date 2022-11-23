package com.debugagent.ch01.generics;

public class CompareNumbers {
    public static <T extends Comparable<T>> T max(T a, T b) {
        return a.compareTo(b) > 0 ? a : b;
    }

    public static void main(String[] argv) {
        System.out.println(max(3, 5));
        //System.out.println(max(3.0, 5));
    }
}
