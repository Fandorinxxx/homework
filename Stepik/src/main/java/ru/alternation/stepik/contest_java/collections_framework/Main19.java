package ru.alternation.stepik.contest_java.collections_framework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 # 1.19 Iterator

 Using BufferedReader read one string with numbers written across the space ("1 2 3 4 5 ...").

 Put this numbers to any Collection of Integers. Sort this collection!

 Using Iterator remove all even annoying numbers(death for elem%2=0 !) from your Collection

 Print all remaining elements to console (use System.out.println() method)

 Sample Input:
 1 2 3 4 5 6 7 8 9 10
 Sample Output:
 1
 3
 5
 7
 9


 */


public class Main19 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //lets go

        String ss = "  4 3  4 5  2 ".trim().replaceFirst("\\s+", "");
        System.out.println(ss);

        Stream.of(reader.readLine()) // для 1 итерации
        //reader.lines()
                .map(s -> s.split("\\s+"))
                //.map(Arrays::asList)
                //.flatMap(List::stream)
                .flatMap(Arrays::stream)
                .peek(System.out::println)
                .map(Integer::parseInt)
                .filter(integer -> !(integer % 2 == 0))
                .sorted()
                .forEach(System.out::println);
    }
}
