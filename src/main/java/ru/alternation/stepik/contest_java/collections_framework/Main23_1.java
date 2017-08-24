package ru.alternation.stepik.contest_java.collections_framework;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 # 1.23 Queue, Deque

 Remember that the first element in the queue in alphabetical order, and the other is not!

 Enter the result of the execution of this code:
 ...

 */

public class Main23_1 {
    public static void main(String[] args) {
        Queue<String> queue = new PriorityQueue<>();
        queue.offer("a");
        queue.offer("c");
        queue.offer("b");

        String name = queue.peek();
        String name1 = queue.poll();
        String name2 = queue.poll();
        queue.offer(name);

        queue.forEach(System.out::print);
    }
}
