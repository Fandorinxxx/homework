package ru.alternation.Trash.spliterator.logicbig;


import java.util.Arrays;
import java.util.List;
import java.util.Spliterator;

public class SpliteratorTrySplitExample {
    public static void main (String[] args) {
        List<String> list = Arrays.asList("Apple", "Banana", "Orange");

        Spliterator<String> s = list.spliterator();
        Spliterator<String> s1 = s.trySplit();

        s.forEachRemaining(System.out::println);
        System.out.println("-- traversing the other half of the spliterator --- ");
        s1.forEachRemaining(System.out::println);
    }
}
