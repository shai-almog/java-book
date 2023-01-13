package com.debugagent.threads.pools;

import java.util.concurrent.Executors;

public class LimitsOfPool {
    public static void main(String[] argv) {
        var pool = Executors.newFixedThreadPool(20);
        for(int iter = 0 ; iter < 20000 ; iter++) {
            var currentThread = iter;
            pool.execute(() -> System.out.println("In thread " + currentThread));
        }
    }
}
