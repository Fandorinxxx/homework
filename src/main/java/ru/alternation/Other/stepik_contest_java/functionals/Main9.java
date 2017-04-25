package ru.alternation.Other.stepik_contest_java.functionals;

import java.util.function.BinaryOperator;

/**
 2.9 Writing simple lambda expressions

 Write a lambda expression that accepts two integers arguments and returns max of them.

 Try not to use the Math library.

 You may write the expression in any valid format but with ; on the end.

 Examples: (x, y) -> x + y; (x, y) -> { return x + y; };

 Sample Input:
 1 4
 Sample Output:
 4

 */
public class Main9 {
    public static void main(String[] args) {
        BinaryOperator<Integer> max = (x, y) -> x >= y ? x : y;
        System.out.println(max.apply(100, 120));
        System.out.println(max.apply(200, 120));
    }
}
