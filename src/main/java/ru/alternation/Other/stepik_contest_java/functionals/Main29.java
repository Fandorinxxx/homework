package ru.alternation.Other.stepik_contest_java.functionals;


import java.util.function.IntToDoubleFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 2.29 Collectors in practice: the product of squares

 Write a collector that evaluates the product of squares of integer numbers in a stream.

 You should write only the collector in any valid formats but without ; on the end.
 It will be passed as the argument to the collect() method of the stream.

 Examples of the valid solution formats: Collectors.reducing(...) or reducing(...).

 Sample Input 1:
 0 1 2 3
 Sample Output 1:
 0

 Sample Input 2:
 1 2
 Sample Output 2:
 4
 */
public class Main29 {
    public static void main(String[] args) {
        IntToDoubleFunction intToDoubleFunction = (int e) -> e;

        Collectors.reducing(1, (Integer i) -> i*i, (Integer acc, Integer value) -> acc * value);

        int i = Stream.of(0, 1, 2, 3)
                .collect(Collectors.reducing(1, integer -> integer * integer, (integer, integer2) -> integer * integer2));
        System.out.println(i);
    }
}

