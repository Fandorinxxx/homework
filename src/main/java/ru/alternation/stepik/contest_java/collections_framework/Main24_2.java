package ru.alternation.stepik.contest_java.collections_framework;

import java.util.Arrays;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 # 1.24 Map basic methods

 Given an array of strings,

  - On wordCount(): return a SortedMap<String, Integer> with a key for each different string,
    with the value the number of times that string appears in the array.
  - On printMap(): Using System.out.println() print all items of the Map ("key : value")

 Sample Input:
 a b b c d a b
 Sample Output:
 a : 2
 b : 3
 c : 1
 d : 1

 */


public class Main24_2 {
    public static SortedMap<String, Integer> wordCount(String[] strings) {
        return Stream.of(strings)
                .collect(Collectors.groupingBy(java.util.function.Function.identity(),
                                               TreeMap::new,
                                               Collectors.reducing(0, o -> 1, Integer::sum)));
    }

    // или так
    public static SortedMap<String, Integer> wordCount2(String[] strings) {
        return new TreeMap<>(Arrays.stream(strings).collect(Collectors.toMap(k -> k, v -> 1, Integer::sum)));
    }

    // еще
    public static SortedMap<String, Integer> wordCount3(String[] strings) {
        SortedMap<String, Integer> map = new TreeMap<>();
        for (String s : strings){
            map.merge(s, 1, Integer::sum);
        }
        return map;
    }

    public static void printMap(Map<String, Integer> map){
        map.forEach((s, integer) -> System.out.println(s + " : " + integer));
    }
}
