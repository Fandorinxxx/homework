package ru.alternation.examples.spliterator.logicbig;


import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;

public class SpliteratorCharacteristics {
    public static void main (String[] args) {
        List<String> list = new ArrayList<>();

        Spliterator<String> s = list.spliterator();

        if (s.hasCharacteristics(Spliterator.ORDERED)) {
            System.out.println("ORDERED");
        }
        if (s.hasCharacteristics(Spliterator.DISTINCT)) {
            System.out.println("DISTINCT");
        }
        if (s.hasCharacteristics(Spliterator.SORTED)) {
            System.out.println("SORTED");
        }
        if (s.hasCharacteristics(Spliterator.SIZED)) {
            System.out.println("SIZED");
        }

        if (s.hasCharacteristics(Spliterator.CONCURRENT)) {
            System.out.println("CONCURRENT");
        }
        if (s.hasCharacteristics(Spliterator.IMMUTABLE)) {
            System.out.println("IMMUTABLE");
        }
        if (s.hasCharacteristics(Spliterator.NONNULL)) {
            System.out.println("NONNULL");
        }
        if (s.hasCharacteristics(Spliterator.SUBSIZED)) {
            System.out.println("SUBSIZED");
        }
    }
}
