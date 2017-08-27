package ru.alternation.stepik.contest_java.functionals;

import java.util.function.BiFunction;
import java.util.function.Function;
/**
 2.32 Understanding currying

 You know a type of a curried function:

 BiFunction<Integer, Integer, BiFunction<Integer, Integer, Function<Integer, Integer>>>

 Select all suitable curried functions.

 */

public class Main32_new_2 {
    public static void main(String[] args) {

        BiFunction<Integer, Integer, BiFunction<Integer, Integer, Function<Integer, Integer>>> var;

        var = (Integer arg1, Integer arg2) -> (arg3, arg4) -> (arg5) -> arg1 + arg2 + arg3 + arg4 + arg5;
        var = (arg1, arg2) -> (arg3, arg4) -> (arg5) -> arg1;
      //var = (arg1) -> (arg2, arg3) -> (arg4, arg5) -> arg1 + arg2 + arg3 + arg4 + arg5;
        var = (arg1, arg2) -> (arg3, arg4) -> (arg5) -> arg1 + arg2 + arg3 + arg4 + arg5;
      //var = (arg1, arg2) -> (arg3, arg4) -> (String arg5) -> arg1;
      //var = (arg1) -> (arg2, arg3) -> (arg4, arg5) -> arg5;
    }
}
