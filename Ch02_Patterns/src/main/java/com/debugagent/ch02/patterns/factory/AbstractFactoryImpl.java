package com.debugagent.ch02.patterns.factory;

class AbstractFactoryImpl implements AbstractFactory {
    @Override
    public AbstractBase createInstance() {
        return new CreatedClass();
    }
}
