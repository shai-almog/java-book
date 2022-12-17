package com.debugagent.ch02.patterns.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Observable {
    private List<EventListener> listeners = new ArrayList<>();
    public void addListener(EventListener listener) {
        listeners.add(listener);
    }

    public void removeListener(EventListener listener) {
        listeners.remove(listener);
    }

    public void fireEvent(Map<String, Object> metadata) {
        for(EventListener e : listeners) {
            e.onEvent(metadata);
        }
    }
}
