package ru.alternation.Other.stepik_contest_java.functionals;

import java.util.function.UnaryOperator;

/**
 Using closure write a lambda expression that adds prefix (before) and suffix (after) to its single string argument;
 prefix and suffix are final variables and will be available in the context during testing.

 All whitespaces on the both ends of the argument must be removed. Do not trim prefix, suffix and the result string.

 You may write the lambda expression in any valid formats but with ; on the end.

 Examples: (x, y) -> x + y; (x, y) -> { return x + y; }

 */
public class Main13_2 {
    public static void main(String[] args) {
       final String prefix = "prefix";
       final String suffix = "suffix";

        UnaryOperator<String> operator = s -> prefix + s.trim() + suffix;
        UnaryOperator<String> operator2 = s -> prefix + s.replaceAll(" ","") + suffix; // no



        System.out.println(operator.apply(" GGG  _ "));
        System.out.println(operator2.apply(" GGG  _ "));
    }
}
