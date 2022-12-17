package com.debugagent.ch02.functional;

import java.util.*;
import java.util.stream.Collectors;

public class StreamsSample {
    private static boolean test(Integer num) {
        return num % 2 == 0 && num > 0;
    }

    private static Collection<Integer> evenStream(List<Integer> numbers) {
        return numbers.stream()
                .filter(StreamsSample::test)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }

    private static Collection<Integer> evenLoop(List<Integer> numbers) {
        Set<Integer> uniqueValues = new TreeSet<>();
        for (Integer num : numbers) {
            if (num % 2 == 0 && num > 0) {
                uniqueValues.add(num);
            }
        }
        return uniqueValues;
    }

    public static void main(String[] argv) {
        List<Integer> numbers = new ArrayList<>();
        Random random = new Random();
        for(int iter = 0 ; iter < 10000000 ; iter++) {
            numbers.add(random.nextInt());
        }
        long t1 = System.currentTimeMillis();
        var even = evenStream(numbers);
        t1 = System.currentTimeMillis() - t1;

        long t2 = System.currentTimeMillis();
        even = evenLoop(numbers);
        t2 = System.currentTimeMillis() - t2;

        //var even = evenLoop(numbers);
        System.out.println("Stream took " + t1 + " loop took " + t2);
    }
}
