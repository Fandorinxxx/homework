package ru.alternation.stepik.contest_java.functionals;

import java.util.function.DoubleUnaryOperator;

/**
 2.13 Writing closures

 Using closure write a lambda expression that calculates a∗x^2+b∗x+c where a, b, c are context final variables.
 They will be available in the context during testing. Note, the result is double.

 You may write the lambda expression in any valid formats but with ; on the end.

 Examples: (x, y) -> x + y; (x, y) -> { return x + y; }

  */
public class Main13 {
    public static void main(String[] args) {

        double a = 1, b = 2, c = 3;

        DoubleUnaryOperator operator = x -> a*x*x + b*x + c;

        System.out.println(operator.applyAsDouble(1));

    }
}
