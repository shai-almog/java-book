package com.debugagent.threads.syncrhonization;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Executors;

public class WaitAndNotify {
    private final Object LOCK = new Object();
    private Collection<String> listOfNames = new ArrayList<>();
    private Collection<NameAdded> listeners = new ArrayList<>();

    private final Object EVENT_THREAD_LOCK = new Object();
    private List<String> pending = new ArrayList<>();

    public WaitAndNotify() {
        new Thread(() -> {
            try {
                while(true) {
                    String[] newStrings;
                    NameAdded[] listenersArray;
                    synchronized (EVENT_THREAD_LOCK) {
                        if(pending.isEmpty()) {
                            EVENT_THREAD_LOCK.wait();
                        }
                        newStrings = new String[pending.size()];
                        pending.toArray(newStrings);
                        pending.clear();
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
        synchronized (LOCK) {
            listeners.add(callback);
        }
    }

    public void stopListeningNameIsAdded(NameAdded callback) {
        synchronized (LOCK) {
            listeners.remove(callback);
        }
    }

    public void addName(String name) {
        synchronized (LOCK) {
            listOfNames.add(name);
        }
        synchronized (EVENT_THREAD_LOCK) {
            pending.add(name);
            EVENT_THREAD_LOCK.notify();
        }
    }

    public boolean isInList(String name) {
        synchronized (LOCK) {
            return listOfNames.contains(name);
        }
    }
}