package ru.alternation.stepik.contest_java.collections;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 # 4.22 Queues & Stacks. Different operations

 There is a queue of 4 elements. Put in it one more element - the number 5, and then get 2 items out of the queue.

 Sample Output:
 [3, 4, 5]

 */
public class Main22 {
    public static void main(String[] args) {

        Deque<Integer> queue = new ArrayDeque<>(Arrays.asList(1,2,3,4));

        queue.add(5);
        queue.poll();
        queue.poll();

        System.out.println(queue);

    }
}
