package com.debugagent.threads.syncrhonization;

import java.util.List;
import java.util.concurrent.Executors;

public class RaceCondition {
    private static List<String> stringList;
    public static void main(String[] argv) {
        Executors.newFixedThreadPool(1).
                execute(() -> {
                    System.out.print(stringList);
                });
        stringList = List.of("ZZ", "XX", "LL", "DDD");
    }
}
