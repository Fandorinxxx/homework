package ru.alternation.Other.stepik_contest_java.functionals;

import java.util.function.Function;

/**
 2.35 Currying

 Write a curried function (using lambdas) that accepts four string arguments and concatenated all in one string following the rules:
    String cases: in the result string, first and second arguments must be in lower cases and third and fourth in upper cases.
    Order of arguments concatenation: first, third, second, fourth.

 You may write the result in any valid formats but with ; on the end.

 An example: x -> y -> { };

 Sample Input:
 aa bb cc dd
 Sample Output:
 aaCCbbDD

 Sample Input 2:
 AAA bbb CCC ddd
 Sample Output 2:
 aaaCCCbbbDDD

 */
public class Main35_2 {
    public static void main(String[] args) {
        Function<String, Function<String, Function<String, Function<String, String>>>> function =
                (String a) -> (String b) -> (String c) -> (String d) -> a.toLowerCase() + c.toUpperCase() + b.toLowerCase() + d.toUpperCase();

        String result = function.apply("aa").apply("bb").apply("cc").apply("dd");
        System.out.println(result);

    }
}
