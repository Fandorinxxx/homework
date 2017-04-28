package ru.alternation.Other.stepik_contest_java.functionals;

import java.util.function.Consumer;
import java.util.function.IntUnaryOperator;

/**
 2.17 Understanding of the function composition

 */
public class Main17 {
    public static void main(String[] args) {
        //You have the following part of a code:
        IntUnaryOperator mult2 = num -> num * 2;
        IntUnaryOperator add3 = num -> num + 3;

        IntUnaryOperator combinedOperator = add3.compose(mult2.andThen(add3)).andThen(mult2);
        int result = combinedOperator.applyAsInt(5);
        //The result is ...

        // mult2 -> add3 -> add3 -> mult2 
        // 5, 10, 13, 16, 32.



        //You have the following part of a code:
        Consumer<Integer> printer = System.out::println;
        Consumer<Integer> devNull = (val) -> { int v = val * 2; };

        Consumer<Integer> combinedConsumer = devNull.andThen(devNull.andThen(printer));
        combinedConsumer.accept(100);
        // What does this code print?
    }
}
