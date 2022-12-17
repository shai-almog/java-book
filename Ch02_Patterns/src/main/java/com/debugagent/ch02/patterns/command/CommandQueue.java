package com.debugagent.ch02.patterns.command;

import java.util.ArrayList;
import java.util.List;

public class CommandQueue {
    private List<Command> performedCommands = new ArrayList<>();
    private List<Command> undoneCommands = new ArrayList<>();
    public void perform(Command cmd) {
        cmd.perform();
        performedCommands.add(cmd);
        undoneCommands.clear();
    }

    public boolean canUndo() {
        return !performedCommands.isEmpty();
    }

    public boolean canRedo() {
        return !undoneCommands.isEmpty();
    }

    public void undo() {
        Command cmd = performedCommands.remove(performedCommands.size() - 1);
        cmd.undo();
        undoneCommands.add(cmd);
    }

    public void redo() {
        Command cmd = undoneCommands.remove(undoneCommands.size() - 1);
        cmd.perform();
        performedCommands.add(cmd);
    }
}
