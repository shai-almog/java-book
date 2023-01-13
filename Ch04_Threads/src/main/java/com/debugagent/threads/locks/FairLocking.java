package com.debugagent.threads.locks;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FairLocking {
    private static final ReentrantLock FAIR_LOCK = new ReentrantLock(true);
    private static final ReentrantLock UNFAIR_LOCK = new ReentrantLock();

    private static void print(Lock lock, int number) {
        lock.lock();
        try {
            System.out.print(" " + number);
        } finally {
            lock.unlock();
        }
    }

    private static void print(Executor executor, Lock lock) {
        for(int iter = 0 ; iter < 10 ; iter++) {
            var current = iter;
            executor.execute(() -> print(lock, current));
        }
    }

    public static void main(String[] argv) throws InterruptedException {
        Executor executor = Executors.newFixedThreadPool(10);
        System.out.println("Fair: ");
        print(executor, FAIR_LOCK);
        Thread.sleep(10);
        System.out.println("\nUnfair: ");
        print(executor, UNFAIR_LOCK);
        Thread.sleep(10);
    }
}