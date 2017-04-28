package ru.alternation.Other.stepik_contest_java.functionals;

import com.google.common.base.Function;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 2.12 Getting distinct strings

 Write a lambda expression that accepts a list of strings and returns new list of distinct strings (without repeating).
 The order of elements in the result list may be any (elements will be sorted by the testing system).

 If the input list doesn't contain any strings or contains only empty strings then the result is an empty string ("").

 Hints: it is possible to use sets, maps, lists and so on for helping.

 You may write the lambda expression in any valid formats but with ; on the end.

 Examples: (x, y) -> x + y; (x, y) -> { return x + y; };


 Sample Input 1:
 java scala java clojure clojure
 Sample Output 1:
 clojure java scala

 Sample Input 2:
 the three the three the three an an a
 Sample Output 2:
 a an the three

  */
public class Main12 {
    public static void main(String[] args) {

        UnaryOperator<List<String>> function = (List<String> list) ->
                list.stream()
                        .distinct()
                        .collect(Collectors.toCollection(ArrayList::new));

        Function<List<String>, List<String>> function2 = list -> {
            Set<String> set = new HashSet<>(list);
            return new ArrayList<>(set);
        };


        System.out.println(function.apply(Arrays.asList("java", "scala", "java","clojure", "clojure")));
        System.out.println(function.apply(Arrays.asList("the", "three", "the", "three","the", "three", "an","an", "a")));


    }
}
