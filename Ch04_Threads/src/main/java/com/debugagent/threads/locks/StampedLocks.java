package com.debugagent.threads.locks;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.StampedLock;

public class StampedLocks {
    private final StampedLock LOCK = new StampedLock();
    private Collection<String> listOfNames = new ArrayList<>();

    public void addName(String name) {
        long stamp = LOCK.readLock();
        try {
            if(!listOfNames.contains(name)) {
                long writeLock = LOCK.tryConvertToWriteLock(stamp);
                if(writeLock == 0) {
                    throw new IllegalStateException();
                }
                listOfNames.add(name);
            }
        } finally {
            LOCK.unlock(stamp);
        }
    }

    public boolean isInList(String name) {
        long stamp = LOCK.readLock();
        try {
            return listOfNames.contains(name);
        } finally {
            LOCK.unlockRead(stamp);
        }
    }
}