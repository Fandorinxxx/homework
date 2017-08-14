package ru.alternation.examples.spliterator.logicbig;

import java.util.Arrays;
import java.util.List;

public class IteratorForEachExample {
    public static void main (String[] args) {
        List<String> list = Arrays.asList("Apple", "Banana", "Orange");
        list.forEach(System.out::println);
    }
}

