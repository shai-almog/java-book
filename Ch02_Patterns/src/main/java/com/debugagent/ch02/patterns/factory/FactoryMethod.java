package com.debugagent.ch02.patterns.factory;

public class FactoryMethod {
    public AbstractBase createInstance() {
        return new CreatedClass();
    }
}
