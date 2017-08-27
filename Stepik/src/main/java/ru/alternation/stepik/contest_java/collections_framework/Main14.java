package ru.alternation.stepik.contest_java.collections_framework;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 # 1.14 HashSet. Symmetric Difference

 Symmetrical difference
 https://en.wikipedia.org/wiki/Symmetric_difference﻿

 1.Find Symmetrical difference of sets on symDifference(Set<T> set1, Set<T> set2) and return it.
 ﻿* For example ﻿sets:{1 2 3 4} {3 4 5 6} --> Symmetrical difference = ﻿{1 2 5 6}
 ﻿
 Sample Input:
 3 14 16 5 13 2 20 10 6 9;2 4 6 8 10 12 14 16 18 20
 Sample Output:
 3
 4
 5
 8
 9
 12
 13
 18


 */


public class Main14 {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3, 4));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 4, 5, 6));
        Set<Integer> set3 = symDifference(set1, set2);
        set3.forEach(System.out::println);
    }

    public static Set<Integer> symDifference(Set<Integer> set1, Set<Integer> set2){


        return Stream.concat(set1.stream().filter(integer -> !set2.contains(integer)),
                             set2.stream().filter(integer -> !set1.contains(integer)))
                .collect(Collectors.toSet());

//        return Stream.concat(set1.stream(), set2.stream())
//                .filter(integer -> !(set1.contains(integer) && set2.contains(integer)))
//                .collect(Collectors.toSet());


//        Set<Integer> result = new HashSet<>(set1);
//        result.addAll(set2);
//        return result.stream()
//                .filter(integer -> !(set1.contains(integer) && set2.contains(integer)))
//                .collect(Collectors.toSet());
    }
}
