package ru.alternation.stepik.contest_java.collections_framework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 # 1.13 HashSet. Basic operations

 Additional code,son!
    1. Given a string as "1 2 3 4 5 6 ..." . String[] strings contains of element from given string ("1","2",..).
       Add all elements from String[] strings to Set<Integer> set.
    2. Add all the elements from helpList to set.
    3. Using Iterator remove/filter(Stream API)/"method-of-all-collections" all elements greater than 10(>) from set and return modified set.

 Sample Input:
 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20
 Sample Output:
 1
 2
 3
 4
 5
 6
 7
 8
 9
 10

 */


public class Main13 {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = reader.readLine().split(" ");
        List<Integer> helpList = getList();
        Set<Integer> set = new HashSet<>();
        //add elements from strings to set
        set.addAll(Stream.of(strings)
                .map(Integer::parseInt)
                .collect(Collectors.toSet()));
        //add elements from helpList to set
        set.addAll(helpList);

        set = removeAllNumbersMoreThan10(set);
        set.forEach(System.out::println);
    }

    public static Set<Integer> removeAllNumbersMoreThan10(Set<Integer> set){

        set.removeIf(integer -> integer > 10);
        return set;

        //return set.stream().filter(integer -> !(integer > 10)).collect(Collectors.toSet());
    }

    private static List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3));
    public static List<Integer> getList() {
        return list;
    }
}
