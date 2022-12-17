package com.debugagent.ch02.patterns.facade;

public class Facade {
    private final InternalAPI1 internalAPI1 = new InternalAPI1();
    private final InternalAPI2 internalAPI2 = new InternalAPI2();
    private final InternalAPI3 internalAPI3 = new InternalAPI3();

    public void api1() {
        internalAPI1.api1();
    }

    public void api2() {
        internalAPI2.api2();
    }

    public void api3() {
        internalAPI3.api3();
    }
}
