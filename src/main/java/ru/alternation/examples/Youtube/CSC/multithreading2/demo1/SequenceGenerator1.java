package ru.alternation.examples.Youtube.CSC.multithreading2.demo1;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.youtube.com/watch?v=umTVNoG3760&list=PLlb7e2G7aSpRSBWi5jbGjIe-v_CjRO_Ug&index=11
 */
public class SequenceGenerator1 {

    private static volatile int counter = 0;

    public static int nextInt() {
        return counter++; // broken!
    }


    public static void main(String[] args) throws Exception {
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 1000; ++i) {
            Thread thread = new Thread(() -> System.out.println(nextInt()));
            thread.start();
            threads.add(thread);
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("Counter final value: " + counter); // ~1000
    }
}
