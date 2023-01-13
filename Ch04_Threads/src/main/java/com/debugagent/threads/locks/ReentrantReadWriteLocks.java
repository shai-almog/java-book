package com.debugagent.threads.locks;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLocks {
    private final ReadWriteLock LOCK = new ReentrantReadWriteLock();
    private Collection<String> listOfNames = new ArrayList<>();

    public void addName(String name) {
        LOCK.writeLock().lock();
        try {
            listOfNames.add(name);
        } finally {
            LOCK.writeLock().unlock();
        }
    }

    public boolean isInList(String name) {
        LOCK.readLock().lock();
        try {
            return listOfNames.contains(name);
        } finally {
            LOCK.readLock().unlock();
        }
    }
}