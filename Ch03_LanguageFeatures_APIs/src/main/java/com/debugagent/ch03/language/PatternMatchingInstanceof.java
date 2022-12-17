package com.debugagent.ch03.language;

public class PatternMatchingInstanceof {
    private static int processOldWay(Number number) {
        if(number instanceof Float) {
            Float f = (Float) number;
            return Math.round(f);
        }
        if(number instanceof Integer) {
            Integer i = (Integer) number;
            return i;
        }
        throw new IllegalArgumentException();
    }

    private static int processWithPattern(Number number) {
        if(number instanceof Float f) {
            return Math.round(f);
        }
        if(number instanceof Integer i) {
            return i;
        }
        throw new IllegalArgumentException();
    }

    public static void main(String[] argv) {
        processOldWay(1.7f);
        processWithPattern(1.8f);
    }
}
