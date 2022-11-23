package com.debugagent.ch01.encapsulation;

public class SampleUsage {

    public static void main(String[] argv) {
        // Good Usage
        var first = new Fraction(1, 2);
        var second = new Fraction(2, 3);
        var result = first.add(second);
        System.out.println(first + " + " + second+ " = " + result);

        var third = new Fraction(1, 2);

        // will throw an exception...
        var forth = new Fraction(2, 0);
        var secondResult = third.add(forth);
        System.out.println(third + " + " + forth+ " = " + secondResult);
    }
}
