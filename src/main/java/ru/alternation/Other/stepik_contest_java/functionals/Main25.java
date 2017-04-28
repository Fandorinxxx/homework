package ru.alternation.Other.stepik_contest_java.functionals;

import java.util.stream.LongStream;

/**
 2.25 The sum of odd numbers

 Write a method for calculating the sum of odd numbers in the given interval (inclusively) using Stream API.

 Use the provided template for your method. Pay attention to type of an argument and the returned value.
 Please, don't use cycles.

 Sample Input 1:
 0 0
 Sample Output 1:
 0

 Sample Input 2:
 7 9
 Sample Output 2:
 16

 Sample Input 3:
 21 30
 Sample Output 3:
 125

 */
public class Main25 {
    /**
     * The method calculates the sum of odd numbers in the given range
     *
     * @param start of a range, start >= 0
     * @param end of a range (inclusive), end >= start
     *
     * @return sum of odd numbers
     */
    public static long sumOfOddNumbersInRange(long start, long end) {
        return LongStream.rangeClosed(start, end)
                .filter(value -> value % 2 != 0)
                .reduce(0, Long::sum);
    }
}
