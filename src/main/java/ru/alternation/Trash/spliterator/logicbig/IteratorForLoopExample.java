package ru.alternation.Trash.spliterator.logicbig;


import java.util.Arrays;
import java.util.List;

public class IteratorForLoopExample {
    public static void main (String[] args) {
        List<String> list = Arrays.asList("Apple", "Banana", "Orange");
        for (String s : list) {
            System.out.println(s);
        }
    }
}
