package com.debugagent.threads.syncrhonization;

import java.util.ArrayList;
import java.util.Collection;

public class SynchronizedMethod {
    private Collection<String> listOfNames = new ArrayList<>();

    public synchronized void addName(String name) {
        listOfNames.add(name);
    }

    public synchronized boolean isInList(String name) {
        return listOfNames.contains(name);
    }
}