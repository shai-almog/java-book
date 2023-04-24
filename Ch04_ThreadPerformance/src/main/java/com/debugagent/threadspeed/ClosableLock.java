package com.debugagent.threadspeed;

import java.util.concurrent.locks.ReentrantLock;

public class ClosableLock implements AutoCloseable {
    private final ReentrantLock lock;

    public ClosableLock() {
        this.lock = new ReentrantLock();
    }

    public ClosableLock(boolean fair) {
        this.lock = new ReentrantLock(fair);
    }

    @Override
    public void close() throws Exception {
        lock.unlock();
    }

    public ClosableLock lock() {
        lock.lock();
        return this;
    }

    public ClosableLock lockInterruptibly() throws InterruptedException {
        lock.lock();
        return this;
    }

    public void unlock() {
        lock.unlock();
    }
}
