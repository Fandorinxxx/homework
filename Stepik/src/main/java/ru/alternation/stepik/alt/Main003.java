package ru.alternation.stepik.alt;

/**
 Summing numbers

 Implement a method sumInRange for calculating the sum of numbers in the range from (inclusive), to (exclusive).

 Use the provided template, do not change it!

 Sample Input 1:
 1 2
 Sample Output 1:
 1
 Sample Input 2:
 5 5
 Sample Output 2:
 5
 Sample Input 3:
 10 15
 Sample Output 3:
 60
 */

public class Main003 {
    public static void main(String[] args) {
        System.out.println(sumInRange(1, 2));
        System.out.println(sumInRange(5, 5));
        System.out.println(sumInRange(10, 15));

    }
    public static long sumInRange(int from, int to) {
        long acc = from;
        for (int i = from+1; i < to; i++) {
            acc += i;
        }
        return acc;
    }
}
