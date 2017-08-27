package ru.alternation.stepik.contest_java.collections_framework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 # 1.21 ListIterator. set()

 Given string as "JButton Button JMenu..." to stdin of your programm
 1.Add all elements from this string to List<String>
 2.Next, using ListIterator
    - remove all items not starting with J and
    - items beginning with J replace with the same elements but without the J,
    for example JFrame -> Frame
 3.next, print all the remaining elements in reverse order(using .println())


 Sample Input:
 ImageButton JTextField JTextArea CheckBox JMenu
 Sample Output:
 Menu
 TextArea
 TextField


 */


public class Main21 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> list;
        //enter your code here

        list = Stream.of(reader.readLine().split("\\s+")).collect(Collectors.toList());

        ListIterator<String> iterator = list.listIterator();
        while (iterator.hasNext()) {
            String str = iterator.next();
            if (!str.startsWith("J")) {
                iterator.remove();
            } else {
                iterator.set(str.substring(1));
            }
        }
        iterator = list.listIterator(list.size()); // можно закомментировать, указатель все равно на нужной позиции
        while (iterator.hasPrevious()) {
            System.out.println(iterator.previous());
        }
    }

    // another
    void func() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Arrays.stream(reader.readLine().split("\\s+"))
                .filter(s -> s.substring(0, 1).equals("J"))
                .map((s) -> s.substring(1))
                .collect(ArrayList::new,
                        (list, item) -> list.add(0, item),
                        ArrayList::addAll) // (list1, list2) -> list1.addAll(list2))
                .forEach(System.out::println);
    }
}
