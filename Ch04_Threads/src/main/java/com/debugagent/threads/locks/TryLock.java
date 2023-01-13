package com.debugagent.threads.locks;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class TryLock {
    private static final ReentrantLock LOCK = new ReentrantLock();

    private static void tryLock(int number) {
        try {
            LOCK.tryLock(10, TimeUnit.MILLISECONDS);
        } catch (InterruptedException err) {
            System.out.println("Interrupted thread: " + number);
            return;
        }
        try {
            System.out.println("Entered thread " + number);
            Thread.sleep(30);
            System.out.println("Exiting thread "+ number);
        } catch (InterruptedException err) {
            System.out.println("Sleep Interrupted: " + number);
        } finally {
            LOCK.unlock();
        }
    }

    public static void main(String[] argv) throws InterruptedException {
        Executor executor = Executors.newFixedThreadPool(10);
        executor.execute(() ->tryLock(1));
        executor.execute(() -> tryLock(2));
    }
}