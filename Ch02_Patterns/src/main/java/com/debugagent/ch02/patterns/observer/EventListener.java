package com.debugagent.ch02.patterns.observer;

import java.util.Map;

public interface EventListener {
    void onEvent(Map<String, Object> eventMetadata);
}
