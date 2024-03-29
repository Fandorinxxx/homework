package ru.alternation.examples.spliterator.logicbig;


import java.util.Arrays;
import java.util.List;

public class SpliteratorExample {
    public static void main (String[] args) {
        List<String> list = Arrays.asList("Apple", "Banana", "Orange");

        System.out.println(list.spliterator().characteristics());
        for (String s : list) {
            System.out.println(s);
        }
    }
}

