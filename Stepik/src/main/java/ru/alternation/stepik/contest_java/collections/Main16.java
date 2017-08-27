package ru.alternation.stepik.contest_java.collections;

import java.util.*;
/**
 4.16 Sets. Bypassing

 The set of strings is given.

 Set<String> nameSet = new TreeSet<>(Arrays.asList("Mr.Green", "Mr.Yellow", "Mr.Red"));

 Output each its element in the loop with a new line.
 _______________________________________________________________________________________________________________________
 Sample Input:
 _______________________________________________________________________________________________________________________
 Sample Output:
 Mr.Green
 Mr.Red
 Mr.Yellow

 */
public class Main16 {
    public static void main(String[] args) {
        Set<String> nameSet = new TreeSet<>(Arrays.asList("Mr.Green", "Mr.Yellow", "Mr.Red"));
        nameSet.forEach(System.out::println);
    }
}