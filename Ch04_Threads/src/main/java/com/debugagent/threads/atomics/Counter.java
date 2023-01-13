package com.debugagent.threads.atomics;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

public class Counter {
    private static long regular;
    private static volatile long vol;
    private static Long obj = 0L;
    private static volatile Long volObj = 0L;
    private static AtomicLong atomicLong = new AtomicLong(0);
    public static void main(String[] argv) throws InterruptedException {
        Executor executor = Executors.newFixedThreadPool(20);
        CountDownLatch countDownLatch = new CountDownLatch(20);
        for(int iter = 0 ; iter < 20 ; iter++) {
            executor.execute(() -> {
                for(int x = 0 ; x < 1_000_000 ; x++) {
                    regular++;
                    vol++;
                    obj = obj++;
                    volObj = volObj++;
                    atomicLong.incrementAndGet();
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        System.out.println("regular: " + regular + " volatile: " + vol + " object: " + obj +
                " volatile object: " + volObj + " atomic: " + atomicLong.get());
    }
}
