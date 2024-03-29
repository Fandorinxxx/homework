package ru.alternation.stepik.contest_java.functionals;

import java.util.stream.LongStream;

/**
 2.21 Checking if a number is prime

 Write a method using Stream API to check the input number is prime or not. Let's agree that input value is always
 greater than 1 (i.e. 2, 3, 4, 5, ....). Use the provided template for your method.

 A prime number is a value greater than 1 that has no positive divisors other than 1 and itself.
 See https://en.wikipedia.org/wiki/Prime_number

 This problem has a simple and clear solution with streams. Please, do not use cycles.

 Sample Input 1:
 2
 Sample Output 1:
 True

 Sample Input 2:
 3
 Sample Output 2:
 True

 Sample Input 3:
 4
 Sample Output 3:
 False

 */
public class Main21 {

    /**
     * Checking if a number is prime
     *
     * @param number to test >= 2
     * @return true if number is prime else false
     */
    public static boolean isPrime(final long number) {
        return LongStream.rangeClosed(2, (long) Math.sqrt(number))
                .noneMatch(value -> number % value == 0);

//        return LongStream.range(2, number)
//                .noneMatch(value -> number % value == 0);
    }

    public static void main(String[] args) {

        //System.out.println(isPrime(2));
        System.out.println(isPrime(3));
        System.out.println(isPrime(4));
    }
}
