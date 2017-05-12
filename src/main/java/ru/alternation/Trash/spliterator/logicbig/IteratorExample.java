package ru.alternation.Trash.spliterator.logicbig;
/**
 * http://logicbig.com/tutorials/core-java-tutorial/java-collections/iterator-spliterator/
 */

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class IteratorExample {

    public static void main (String[] args) {
        List<String> list = Arrays.asList("Apple", "Banana", "Orange");
        for (Iterator<String> i = list.iterator(); i.hasNext(); )
            System.out.println(i.next());
    }
}
