package com.debugagent.ch02.patterns.command;

public abstract class Command {
    public abstract void perform();
    public abstract void undo();
}
