package com.debugagent.ch01.noencapsulation;

public class SampleUsage {
    public static Fraction addFractions(Fraction first, Fraction second) {
        var newFraction = new Fraction();
        newFraction.numerator = first.numerator * second.denominator +
                second.numerator * first.denominator;
        newFraction.denominator = first.denominator * second.denominator;
        return newFraction;
    }

    public static void main(String[] argv) {
        // Good Usage
        var first = new Fraction();
        first.numerator = 1;
        first.denominator = 2;

        var second = new Fraction();
        second.numerator = 2;
        second.denominator = 3;

        var result = addFractions(first, second);
        System.out.println(first.numerator + "/" + first.denominator + " + " +
                second.numerator + "/" + second.denominator + " = " +
                result.numerator + "/" + result.denominator);

        // Bad Usage
        var third = new Fraction();
        third.numerator = 1;
        third.denominator = 2;

        var forth = new Fraction();
        forth.numerator = 2;

        // bug forgot to change that to forth...
        second.denominator = 3;

        var secondResult = addFractions(third, forth);
        System.out.println(third.numerator + "/" + third.denominator + " + " +
                forth.numerator + "/" + forth.denominator + " = " +
                secondResult.numerator + "/" + secondResult.denominator);
    }
}
