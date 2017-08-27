package ru.alternation.stepik.contest_java.functionals;

import java.util.function.IntFunction;
import java.util.function.IntUnaryOperator;

/**
 2.35 Currying

 Write a curried form of the function f(x,y,z)=x+y*y+z*z*z using lambda expressions in Java 8 style.
 The result and x, y, z must be integer numbers.

 You may write the result in any valid formats but with ; on the end.

 An example: x -> y -> { };

 Sample Input 1:
 1 1 1
 Sample Output 1:
 3

 Sample Input 2:
 2 3 4
 Sample Output 2:
 75



 */
public class Main35 {
    public static void main(String[] args) {

        IntFunction<IntFunction<IntFunction<Integer>>> function0 = x -> y -> z -> x+y*y+z*z*z;
        IntFunction<IntFunction<IntUnaryOperator>> function = x -> y -> z -> x+y*y+z*z*z;

        IntFunction<IntUnaryOperator> f1 = function.apply(1);
        IntUnaryOperator f2 = f1.apply(2);
        System.out.println(f2.applyAsInt(3));
    }
}
