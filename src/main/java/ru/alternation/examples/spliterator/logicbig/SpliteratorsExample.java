package ru.alternation.examples.spliterator.logicbig;


import java.util.Spliterator;
import java.util.Spliterators;

public class SpliteratorsExample {

    public static void main (String[] args) {
        Spliterator<String> s = Spliterators.spliterator(
                            new String[]{"one", "two"}, 0);
        s.forEachRemaining(System.out::println);
    }
}
