package ru.alternation.stepik.contest_java.functionals;

import java.util.function.Function;

/**
 2.32 Understanding currying

 You have a curried function:

 (arg1) -> (arg2) -> arg1 - arg2;
 Select all possible types of its.

 */

public class Main32_new {
    public static void main(String[] args) {
      //Function<Long, Function<Long, Function<Long, Long>>> a = (arg1) -> (arg2) -> arg1 - arg2;
        Function<Integer, Function<Integer, Integer>>        b = (arg1) -> (arg2) -> arg1 - arg2;
      //Function<String, Function<String, String>>           c = (arg1) -> (arg2) -> arg1 - arg2;
        Function<Double, Function<Double, Double>>           d = (arg1) -> (arg2) -> arg1 - arg2;
    }
}
