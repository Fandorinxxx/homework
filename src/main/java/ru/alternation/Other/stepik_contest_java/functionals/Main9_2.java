package ru.alternation.Other.stepik_contest_java.functionals;

 import java.util.function.LongUnaryOperator;

/**
 2.9 Writing simple lambda expressions

 Write a lambda expression that accepts a long value and returns a next even number.

 It is guaranteed an input number is non-negative.

 You may write the expression in any valid format but with ; on the end.

 Examples: x -> x; (x) -> x; (x) -> { return x; };

 Sample Input 1:
 2
 Sample Output 1:
 4
 Sample Input 2:
 317
 Sample Output 2:
 318

  */
public class Main9_2 {
    public static void main(String[] args) {
        LongUnaryOperator nextEvenLong = x -> (x + 1) % 2 == 0 ? x + 1 : x + 2;
        System.out.println(nextEvenLong.applyAsLong(100));
        System.out.println(nextEvenLong.applyAsLong(103));
    }
}
