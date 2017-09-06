package ru.alternation.stepik.alt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 # Reversing strings

 Implement a method for reversing a given an array of strings. The array can have any size.

 The method may reverse and return existing array or returns a new array.

 Example: the sequence of strings "java", "programming", "methods" is reversed as "methods", "programming", "java".
 */

public class Main004 {
    public static void main(String[] args) {

        String[] strings = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        System.out.println(Arrays.toString(reverse(strings)));
    }

    private static String[] reverse(String... words) {

//        ArrayList<String> collect = Arrays.stream(words)
//                .collect(ArrayList::new,
//                        (list, e) -> list.add(0, e),
//                        (list1, list2) -> list1.addAll(0, list2));
//
//        return collect.toArray(new String[0]);

        for (int i = 0; i < words.length  / 2; i++) {
            int swapment = words.length-i-1;
            String temp = words[i];
            words[i] = words[swapment];
            words[swapment] = temp;
        }
        return words;
    }

}
