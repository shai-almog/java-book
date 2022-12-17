package com.debugagent.ch02.patterns.adapter;

import java.awt.event.ActionListener;

public class CallableAdapter {
    public ActionListener callableAdapter(Runnable runnable) {
        return e -> runnable.run();
    }
}
