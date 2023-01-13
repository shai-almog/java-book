package com.debugagent.threads.syncrhonization;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ProblematicEvent {
    private final Object LOCK = new Object();
    private Collection<String> listOfNames = new ArrayList<>();
    private Collection<NameAdded> listeners = new ArrayList<>();

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
            for(NameAdded current : listeners) {
                current.nameAdded(name);
            }
        }
    }

    public boolean isInList(String name) {
        synchronized (LOCK) {
            return listOfNames.contains(name);
        }
    }
}