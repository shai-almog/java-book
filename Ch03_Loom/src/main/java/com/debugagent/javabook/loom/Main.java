package com.debugagent.javabook.loom;

import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        for(int iter = 0 ; iter < 1000 ; iter++) {
            Thread.startVirtualThread(() -> System.out.println("Loom thread " +
                        atomicInteger.addAndGet(1))
            );
        }
    }
}