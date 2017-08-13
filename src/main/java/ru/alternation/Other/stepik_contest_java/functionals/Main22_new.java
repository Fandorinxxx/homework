package ru.alternation.Other.stepik_contest_java.functionals;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 2.22 Understanding of flatMap together with stream creating

 You have a list numbers:

 List<Integer> numbers = Stream.of(1, 2, 3, 4, 5).collect(Collectors.toList());
 What numbers does the list generated contain?

 a)
 List<Integer> generated = numbers.stream()
    .flatMap(n -> Stream.generate(() -> n).limit(n))
    .collect(Collectors.toList());

 b)
 List<Integer> generated = numbers.stream()
    .flatMapToInt(n -> IntStream.rangeClosed(1, n))
    .boxed()
    .collect(Collectors.toList());

 c)
 List<Integer> generated = numbers.stream()
    .flatMapToInt(n -> IntStream.iterate(n, val -> val + 1).limit(n))
    .boxed()
    .collect(Collectors.toList());

 d)
 List<Integer> generated = numbers.stream()
    .flatMap(Stream::of)
    .collect(Collectors.toList());


 */

public class Main22_new {
    public static void main(String[] args) {

        List<Integer> numbers = Stream.of(1, 2, 3, 4, 5).collect(Collectors.toList());

        System.out.println("Answers: ");
        System.out.println(numbers.stream()
                .flatMap(n -> Stream.generate(() -> n).limit(n))
                .collect(Collectors.toList()));

        System.out.println(numbers.stream()
                .flatMapToInt(n -> IntStream.rangeClosed(1, n))
                .boxed()
                .collect(Collectors.toList()));

        System.out.println(numbers.stream()
                .flatMapToInt(n -> IntStream.iterate(n, val -> val + 1).limit(n))
                .boxed()
                .collect(Collectors.toList()));

        System.out.println(numbers.stream()
                .flatMap(Stream::of)
                .collect(Collectors.toList()));
    }
}
