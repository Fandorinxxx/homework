package ru.alternation.stepik.contest_java.collections;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 4.21 Queues & Stacks. Creating

 Create ArrayDeque by name queue in any way known to you and push the following four numbers 2, 0, 1, 7 .

 The code for displaying the queue is already written.

 Sample Input:
 Sample Output:
 [2, 0, 1, 7]
 */
public class Main21 {
    public static void main(String[] args) {

        Queue<Integer> queue = new ArrayDeque<Integer>(){{
            add(2);
            add(0);
            add(1);
            add(7);
        }};
        //Queue<Integer> queue = new ArrayDeque<>(Arrays.asList(2, 0, 1, 7));
        //                       Stream.of(2, 0, 1, 7).collect(Collectors.toCollection(ArrayDeque::new));


        System.out.println(queue);
    }
}
