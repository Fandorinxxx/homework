package ru.alternation.Other.stepik_contest_java.collections_framework;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 2.1 ArrayList basic

 On static List<String> changeList(List<String> list) method you must do:

 1. find the longest string in list
       -if you use method max of class Collections : don't forget to implement a comparator for this method
          Collections.max(list, (s1,s2)->{...})
          by default, this method compares strings alphabetically!
        -of course you can use other approaches(for example comparison in a for-loop)
 1. replace all list items with this row
 2. return modified list

 Sample Input:
 hi hello goodmorning ass

 Sample Output:
 goodmorning
 goodmorning
 goodmorning
 goodmorning

 */
public class Main1_2 {
    static List<String> changeList(List<String> list){

        String longerString = list.stream().sorted(Comparator.comparing(String::length).reversed()).findFirst().get();
        int size = list.size();
        //list.clear(); // Exception

        Collections.fill(list, longerString);
//        for (int i = 0; i < size; i++) {
//            list.set(i, longerString);
//        }
        return list;
    }

    static List<String> changeList2(List<String> list){

        String longerString = Collections.max(list, Comparator.comparing(String::length));
        return Collections.nCopies(list.size(), longerString); // но это уже другой лист
    }
}
