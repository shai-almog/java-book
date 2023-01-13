package com.debugagent.threads.synchronizers;

import java.util.concurrent.Semaphore;

public class Semaphores {
    private final Semaphore limited = new Semaphore(20);
    private void restricted() throws InterruptedException {
        limited.acquire();
        try {
            // perform restricted activity
        } finally {
            limited.release();
        }
    }
}
