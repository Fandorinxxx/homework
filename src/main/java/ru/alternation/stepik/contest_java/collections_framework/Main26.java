package ru.alternation.stepik.contest_java.collections_framework;

import java.util.List;
import java.util.stream.Collectors;

/**
 # 1.26 Stream API. Operations

 Given a list of strings, return a list of the strings, omitting any string length 4 or more.
 ["a", "bbb", "cccc", "dddddd"] → ["a", "bbb"]


 Sample Input:
 its no long string

 Sample Output:
 its
 no

 */


public class Main26 {
    public static List<String> noLongString(List<String> strings) {

        return strings.stream()
                .filter(s -> s.length() < 4)
                .collect(Collectors.toList());
    }
}
