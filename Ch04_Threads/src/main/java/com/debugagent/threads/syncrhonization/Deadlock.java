package com.debugagent.threads.syncrhonization;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Deadlock {
    private static void dead(String name, Object lock1, Object lock2) {
        try {
            synchronized (lock1) {
                System.out.println("Thread " + name + " Holding...");
                Thread.sleep(2);
                synchronized (lock2) {
                    System.out.println("Thread " + name + " Got it!");
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] argv) {
        Object LOCK1 = new Object();
        Object LOCK2 = new Object();
        Executor executor = Executors.newFixedThreadPool(2);
        executor.execute(() -> dead("One", LOCK1, LOCK2));
        executor.execute(() -> dead("Two", LOCK2, LOCK1));
    }
}
