package ru.alternation.Other.stepik_contest_java.functionals;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.IntPredicate;

/**
 2.18 Composing predicates

 Write the disjunctAll method that accepts a list of IntPredicate's and returns a single IntPredicate.
 The result predicate is a disjunction of all input predicates.

 If the input list is empty then the result predicate should return false for any integer value (always false).

 Pay attention to the provided method template. Do not change it.
 */
public class Main18 {

    /**
     * The method represents a disjunct operator for a list of predicates.
     * For an empty list it returns the always false predicate.
     */
    public static IntPredicate disjunctAll(List<IntPredicate> predicates) {
        //Optional<IntPredicate> predicate = predicates.stream().reduce(IntPredicate::or);

        //return predicates.stream().reduce(IntPredicate::or).orElseGet(() -> x -> false);

        return predicates.stream().reduce(x -> false, IntPredicate::or);
    }

    private static IntPredicate disjunctAll2(List<IntPredicate> predicates) {
        IntPredicate predicate = (x) -> false;
        for (IntPredicate p : predicates) {
            predicate = predicate.or(p);
        }
        return predicate;
    }

    public static void main(String[] args) {
        IntPredicate intPredicate1 = x -> x > 10;
        IntPredicate intPredicate2 = x -> x > 20;

        List<IntPredicate> list = Arrays.asList(intPredicate1, intPredicate2);
        IntPredicate intPredicate = disjunctAll(list);

        System.out.println(intPredicate.test(15));

    }
}
