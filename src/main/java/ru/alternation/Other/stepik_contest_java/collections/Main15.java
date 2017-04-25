package ru.alternation.Other.stepik_contest_java.collections;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

/**
 4.15 Sets. Creating

 Create TreeSet by name set in any way known to you and fill it with the following three strings "Gamma", "Alpha", "Omega" .

 The code for displaying the set is already written.

 Sample Input:

 Sample Output:
 [Alpha, Gamma, Omega]

 */
public class Main15 {

    public static void main(String[] args) {
        Set<String> set = new TreeSet<>(Arrays.asList("Alpha", "Gamma", "Omega"));
        System.out.println(set);
    }
}
