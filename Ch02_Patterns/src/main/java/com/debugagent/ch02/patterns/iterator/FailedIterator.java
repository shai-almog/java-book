package com.debugagent.ch02.patterns.iterator;

import java.util.ArrayList;
import java.util.List;

public class FailedIterator {
    public static void main(String[] argv) {
        List<String> list = new ArrayList<>(List.of("One", "Two", "Three"));
        var iterator = list.iterator();
        while (iterator.hasNext()) {
            String current = iterator.next();
            if(current.equalsIgnoreCase("one")) {
                list.remove(current);
            }
        }
    }
}
