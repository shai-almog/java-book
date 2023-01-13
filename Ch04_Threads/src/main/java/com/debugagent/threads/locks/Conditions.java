package com.debugagent.threads.locks;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Conditions {
    private final ReadWriteLock LOCK = new ReentrantReadWriteLock();
    private final Condition NOTIFICATION = LOCK.readLock().newCondition();
    private Collection<String> listOfNames = new ArrayList<>();
    private Collection<NameAdded> listeners = new ArrayList<>();

    private List<String> pending = new ArrayList<>();

    public Conditions() {
        new Thread(() -> {
            try {
                while(true) {
                    String[] newStrings;
                    NameAdded[] listenersArray;
                    LOCK.writeLock().lock();
                    try {
                        if(pending.isEmpty()) {
                            NOTIFICATION.await();
                        }
                        newStrings = new String[pending.size()];
                        pending.toArray(newStrings);
                        pending.clear();
                    } finally {
                        LOCK.writeLock().unlock();
                    }
                    synchronized (LOCK) {
                        listenersArray = new NameAdded[listeners.size()];
                        listeners.toArray(listenersArray);
                    }

                    for(String name : pending) {
                        for(NameAdded nameAdded : listenersArray) {
                            nameAdded.nameAdded(name);
                        }
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    interface NameAdded {
        void nameAdded(String name);
    }

    public void listenNameIsAdded(NameAdded callback) {
        LOCK.writeLock().lock();
        try {
            listeners.add(callback);
        } finally {
            LOCK.writeLock().unlock();
        }
    }

    public void stopListeningNameIsAdded(NameAdded callback) {
        LOCK.writeLock().lock();
        try {
            listeners.remove(callback);
        } finally {
            LOCK.writeLock().unlock();
        }
    }

    public void addName(String name) {
        LOCK.writeLock().lock();
        try {
            listOfNames.add(name);
            pending.add(name);
            NOTIFICATION.signal();
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