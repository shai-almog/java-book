package com.debugagent.testing;

public class MyObject {
    public int myMethod() {
        return 42;
    }

    public void myMethodThatThrowsException() {
        throw new IllegalStateException();
    }
}
