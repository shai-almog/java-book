package com.debugagent.ch02.patterns.singleton;

public class SimpleSingleton {
    private static final SimpleSingleton INSTANCE = new SimpleSingleton();

    private SimpleSingleton() {}

    public static SimpleSingleton getInstance() {
        return INSTANCE;
    }

    public void doSomething() {
        // code
    }
}
