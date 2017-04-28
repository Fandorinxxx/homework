package ru.alternation.Other.stepik_contest_java.functionals;

/**

 2.16 Your own functional interface


 You need to write your own functional interface (TernaryIntPredicate) and use it with a lambda expression.
 The interface must have a single non-static (and non-default) method test with three int arguments that returns
 boolean value.

 Besides, you need to write a lambda expression with three int arguments using your TernaryIntPredicate.

 The lambda expression has to return true if all passed values are different otherwise false. The name of the instance
 is allValuesAreDifferentPredicate. It should be a static field.

 Use the provided template for your solution. Do not change it!

 Sample Input 1:
 1 1 1
 Sample Output 1:
 False

 Sample Input 2:
 2 3 4
 Sample Output 2:
 True

 */

public class Main16 {

    @FunctionalInterface
    public interface TernaryIntPredicate {
        boolean test(int a1, int a2, int a3);
    }

    public static final TernaryIntPredicate allValuesAreDifferentPredicate = (x, y, z) -> x !=z && x != y && z!= y;


    public static void main(String[] args) {
        System.out.println(allValuesAreDifferentPredicate.test(1,2,3));
        System.out.println(allValuesAreDifferentPredicate.test(1,1,3));

    }
}
