package ru.alternation.stepik.contest_java.collections_framework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 # 1.16 TreeSet. "from several to one"

 Additional code, Soldier!
 Given one input string as "1 2 3 4 5;6 7 8 9 10;11 12 13 14 15"(it's 3 lists)
 1. String[] sets consists of these lists. Add all elements from each list to correct set(see the comments in the code) sets[0] = {"1 2 3 4 5"} - its string and so on
    *use split(" ") to separate elements from string
 2. On unionTreeLargeNumber(Set<Integer> set1,Set<Integer> set2,Set<Integer> set3):
    1)In each Set find the maximum element
    2)create TreeSet, add the resulting elements to TreeSet
    3)return this TreeSet with elements sorted in descending order:
           *you can use special method from class TreeSet or rather NavigableSet interface to change the order of storage on the reverse
 3.Using System.out.println() print elements of resultTreeSet


 Sample Input:
 6 11 9 18 10;12 13 19 8 16;3 4 5 15 20
 Sample Output:
 20
 19
 18

 */

public class Main16 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] sets = reader.readLine().split(";");

        Set<Integer> set1;
        //your code(add elements to set1 from sets[0])
        set1 = Arrays.stream(sets[0].split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(HashSet::new));

        Set<Integer> set2 = Arrays.stream(sets[1].split(" ")).map(Integer::parseInt).collect(Collectors.toCollection(HashSet::new));
        Set<Integer> set3 = Arrays.stream(sets[2].split(" ")).map(Integer::parseInt).collect(Collectors.toCollection(HashSet::new));

        Set<Integer> resultTreeSet = unionTreeLargeNumber(set1, set2, set3);

        //print elements of resultTreeSet(using System.out.printLn()) below
        resultTreeSet.forEach(System.out::println);
    }

    public static TreeSet<Integer> unionTreeLargeNumber(Set<Integer> set1, Set<Integer> set2, Set<Integer> set3){

        TreeSet<Integer> resultSet = new TreeSet<>(Arrays.asList(Collections.max(set1), Collections.max(set2), Collections.max(set3)));
        return  (TreeSet<Integer>) resultSet.descendingSet();
    }


    static void anotherAnswer() {
        new BufferedReader(new InputStreamReader(System.in)).lines()
                .map(string -> string.split(";"))  // String   -> String[]
                .flatMap(Arrays::stream)                 // String[] -> stream of String's
                .map(string -> string.split(" "))  // String   -> String[]
                .map(Arrays::asList)                     // String[] -> List<String>
                .map(x -> x.stream().map(Integer::parseInt).collect(Collectors.toList())) // List<String> -> List<Integer>
                .map(Collections::max)                   // List<Integer> -> Integer
                .collect(Collectors.toCollection(() -> new TreeSet<>(Collections.reverseOrder()))) // stream of Integer's -> TreeSet<>(Collections.reverseOrder())
                .forEach(System.out::println);
    }
}
