package ru.alternation.stepik.contest_java.collections_framework;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 # 1.23 Queue, Deque

 */
public class Main23_2 {
    public static void main(String[] args) {
        Deque<String> states = new ArrayDeque<String>();
        states.add("Germany");
        states.add("France");
        states.push("UK");
        states.offerLast("Norway");

//        while (states.peek() != null) {
//            System.out.print(states.pop());
//        } // UKGermanyFranceNorway

        String sFirst = states.pop(); // - UK
        String s = states.peek(); // Germany
        String sLast = states.peekLast(); // Norway
        states.offer(sFirst); // + UK at the end
        String s1 = states.pollLast(); // - UK


        while (states.peek() != null) {
            System.out.print(states.pop());
        } // GermanyFranceNorway
    }
}
