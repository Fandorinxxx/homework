package ru.alternation.Other.stepik_contest_java.functionals;

 import java.util.function.LongBinaryOperator;
 import java.util.stream.LongStream;
 import java.util.stream.Stream;

/**
 2.11 Calculating production of all numbers in the range

 Write a lambda expression that accepts two long arguments as a range borders and calculates production of all numbers
 in this range (inclusively). It's guaranteed that 0 <= left border <= right border. if left border == right border
 then the result is any border.

 You may write the lambda expression in any valid formats but with ; on the end.

 Examples: (x, y) -> x + y; (x, y) -> { return x + y; };

 Sample Input 1:
 0 1
 Sample Output 1:
 0

 Sample Input 2:
 2 2
 Sample Output 2:
 2

 Sample Input 3:
 1 4
 Sample Output 3:
 24

  */
public class Main11 {
    public static void main(String[] args) {

        LongBinaryOperator operator =
                (l, r) -> LongStream
                        .rangeClosed(l, r)
                        .reduce(1L, (acc, x) -> acc * x);

//        LongBinaryOperator operator2 =
//                (x, y) -> LongStream
//                        .rangeClosed(x, y)
//                        .reduce(1, x == y ?
//                                (left, right) -> right :    // ! only right
//                                (left, right) -> left * right);
//
//        // Another answer
//        LongBinaryOperator operator3 =
//                (x, y) -> LongStream
//                        .rangeClosed(x, y)
//                        .reduce(x == y ?
//                                (left, right) -> left :
//                                (left, right) -> left * right).getAsLong();

        // Tests
        System.err.println(operator.applyAsLong(0, 1)); // 0
        System.err.println(operator.applyAsLong(2, 2)); // 2
        System.err.println(operator.applyAsLong(1, 4)); // 24
        System.err.println(operator.applyAsLong(4, 5)); // 20
    }
}
