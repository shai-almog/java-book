package com.debugagent.ch02.patterns.iterator;

import java.util.List;

public class IteratorSample {
    public static void main(String[] argv) {
        List<String> list = List.of("Hi", "World");
        var iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
