package com.debugagent.threads.locks;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLocks {
    private final ReentrantLock LOCK = new ReentrantLock();
    private Collection<String> listOfNames = new ArrayList<>();

    public void addName(String name) {
        LOCK.lock();
        try {
            listOfNames.add(name);
        } finally {
            LOCK.unlock();
        }
    }

    public boolean isInList(String name) {
        LOCK.lock();
        try {
            return listOfNames.contains(name);
        } finally {
            LOCK.unlock();
        }
    }
}