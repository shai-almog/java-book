package com.debugagent.threads.synchronizers;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class CountDown {
    public static void main(String[] argv) throws InterruptedException {
        Executor executor = Executors.newFixedThreadPool(10);
        CountDownLatch latch = new CountDownLatch(10);
        for(int iter = 0 ; iter < 10 ; iter++) {
            executor.execute(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                latch.countDown();
            });
        }
        latch.await();
        System.out.println("All 10 threads completed");
    }
}
