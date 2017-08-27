package ru.alternation.stepik.contest_java.functionals;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 2.24 Calculating a factorial

 Many java developers wrote methods to calculate a factorial value using a recursive or iterative algorithm.
 It's time to do it with streams.

 The factorial of n is calculated by the product of integer number from 1 to n (inclusive).
 The factorial of 0 is equal to 1.

 Use the given template for your factorial method. Pay attention to type of an argument and the returned value.
 Please, don't use cycles or recursion.

 Sample Input 1:
 0
 Sample Output 1:
 1

 Sample Input 2:
 1
 Sample Output 2:
 1

 Sample Input 3:
 2
 Sample Output 3:
 2

 */
public class Main24 {
    /**
     * Calculates the factorial of the given number n
     *
     * @param n >= 0
     *
     * @return factorial value
     */
    public static long factorial(long n) {
        return LongStream
                .rangeClosed(2, n)
                .reduce(1, (acc, elem) -> acc * elem);
    }
//    public static long factorial2(long n) {
//        return LongStream
//                .rangeClosed(0, n)
//                .filter(value -> value > 0)
//                .reduce(1, (left, right) -> left*right);
//    }

    public static void main(String[] args) {
        IntStream.rangeClosed(0, 5).forEach(x -> System.out.println(factorial(x)));
    }
}
