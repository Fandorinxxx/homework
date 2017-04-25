package ru.alternation.Other.stepik_contest_java.collections_framework;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

/**
 1.20 ListIterator. add() , output

 Additional code
 1.Using ListIterator iterate over the elements of list from the beginning to the end and after each word "Hip" add "Hop"
 2.Using ListIterator print the all elements(using .println())


 Sample Input:
 Iterator Hip Hoi Hap Iterator Hip Hi

 Sample Output:
 Iterator
 Hip
 Hop
 Hoi
 Hap
 Iterator
 Hip
 Hop
 Hi
 */
public class Main20 {

    public static void main(String[] args) throws IOException {
        //InputStream inputStream = new ByteArrayInputStream("Iterator Hip Hoi Hap Iterator Hip Hi".getBytes());
        //inputStream = System.in;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> list = Arrays.stream(reader.readLine().split("\\s")).collect(Collectors.toList());


        ListIterator<String> iterator = list.listIterator();
        while (iterator.hasNext()){
            if ("Hip".equals(iterator.next())){
                iterator.add("Hop");
            }
        }
        //list.forEach(System.out::println);
        list.listIterator().forEachRemaining(System.out::println);

    }
}
