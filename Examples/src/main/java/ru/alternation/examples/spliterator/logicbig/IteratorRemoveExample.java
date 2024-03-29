package ru.alternation.examples.spliterator.logicbig;


import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class IteratorRemoveExample {
    public static void main (String[] args) {
        List<String> list = new Stack<>();
        list.add("a");

        for (Iterator<String> i = list.iterator(); i.hasNext(); ) {
            String next = i.next();
            System.out.println(next);
            i.remove();
        }
        System.out.println(list);
    }
}
