package com.debugagent.ch01.records;

public record Fraction(int numerator, int denominator) {
    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
        if(denominator <= 0) {
            throw new IllegalArgumentException("Invalid denominator: " + denominator);
        }
    }

    public Fraction add(Fraction other) {
        int numerator = this.numerator * other.denominator +
                other.numerator * this.denominator;
        int denominator = this.denominator * other.denominator;
        return new Fraction(numerator, denominator);
    }

    public String toString() {
        return numerator + "/" + denominator;
    }
}
