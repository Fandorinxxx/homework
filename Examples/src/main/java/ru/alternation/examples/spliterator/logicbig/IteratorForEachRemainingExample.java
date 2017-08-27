package ru.alternation.examples.spliterator.logicbig;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class IteratorForEachRemainingExample {

    public static void main (String[] args) {
        List<String> list = Arrays.asList("Apple", "Banana", "Orange");
        Iterator<String> i = list.iterator();
        i.next();
        i.forEachRemaining(System.out::println);
    }
}
