package ru.alternation.stepik.contest_java.collections_framework;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

/**
 1.27 Using Stream API with collections

 Given string as "JButton Button JMenu..." to stdin of your program
 1. Add all elements from this string to List<String>
 2. Next, using Stream API remove all items not starting with J and items beginning with J replace with the same
 elements but without the J, for example JFrame -> Frame
 3. next, print all the remaining elements in reverse order(using .println())

 *in the lesson ListIterator. set() it was necessary to perform the same logic, but using ListIterator.
  You can compare these 2 solutions

 Sample Input:
 ImageButton JTextField JTextArea CheckBox JMenu

 Sample Output:
 Menu
 TextArea
 TextField
 */
public class Main27 {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = new ByteArrayInputStream("ImageButton JTextField JTextArea CheckBox JMenu".getBytes());
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream)); // System.in

//        List<String> list = reader.lines()
//                .map(s -> s.split("\\s"))
//                .flatMap(Arrays::stream)
//                .filter(s -> s.startsWith("J"))
//                .map(s -> s.substring(1)) // substring(1, s.length())
//                .collect(Collectors.toList());
//        Collections.reverse(list);
//        list.forEach(System.out::println);


        reader.lines()
                .map(s -> s.split("\\s"))
                .flatMap(Arrays::stream)
                .filter(s -> s.startsWith("J"))
                .map(s -> s.substring(1))
                .collect(Collectors.collectingAndThen(Collectors.toList(), strings -> { // !
                    Collections.reverse(strings);
                    return strings;
                })).forEach(System.out::println); // либо сохранить в List<String> list, и уже потом на нем .forEach

    }
}
