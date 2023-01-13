package com.debugagent.threads.syncrhonization;

import java.util.ArrayList;
import java.util.Collection;

public class SynchronizedBlock {
    private final Object LOCK = new Object();
    private Collection<String> listOfNames = new ArrayList<>();

    public void addName(String name) {
        synchronized (LOCK) {
            listOfNames.add(name);
        }
    }

    public boolean isInList(String name) {
        synchronized (LOCK) {
            return listOfNames.contains(name);
        }
    }
}