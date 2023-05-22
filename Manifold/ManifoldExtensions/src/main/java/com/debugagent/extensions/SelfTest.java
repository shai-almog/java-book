package com.debugagent.extensions;

public class SelfTest {
    public static void main(String[] argv) {
        var size = new MySizeClass();
        //size.equals("");
        size.equals(new MySizeClass());

    }
}
