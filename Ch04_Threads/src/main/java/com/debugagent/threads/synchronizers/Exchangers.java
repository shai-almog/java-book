package com.debugagent.threads.synchronizers;

import java.util.concurrent.Exchanger;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Exchangers {
    public static void main(String[] argv) {
        Exchanger<String> exchanger = new Exchanger<>();
        Executor executor = Executors.newFixedThreadPool(2);

        // send commands
        executor.execute(() -> {
            try {
                String result = exchanger.exchange("List Variables");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        // send perform command and return results
        executor.execute(() -> {
            try {
                String command = exchanger.exchange(null);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
