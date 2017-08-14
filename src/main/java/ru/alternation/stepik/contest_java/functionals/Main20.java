package ru.alternation.stepik.contest_java.functionals;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
    2.20 Matching
 */
public class Main20 {
    public static void main(String[] args) {
        boolean result = LongStream
                .rangeClosed(1, 100_000)
                .anyMatch(val -> val == 100_000);

        System.out.println(result);

        //

        boolean result2 = !IntStream
                .generate(() -> 100)
                .limit(101)
                .allMatch(val -> val >= 100);

        System.out.println(result2);

        //
        boolean result3 = IntStream
                .iterate(0, n -> n + 1)
                .limit(100)
                .filter(n -> n % 2 != 0)
                .noneMatch(n -> n % 2 == 0);

        System.out.println(result3);

    }
}
