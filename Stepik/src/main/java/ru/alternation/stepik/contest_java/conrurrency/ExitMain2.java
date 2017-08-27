package ru.alternation.stepik.contest_java.conrurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 Java allows you to provide the custom ThreadFactory to the executor to be used to construct the pool's threads,
 by setting the corresponding thread's properties.

 Make the corresponding change in the program below to allow the program to terminate after all threads are completed.

 Hint: remember the difference between daemon and non-daemon thread.
 */
public class ExitMain2 {
    private static final int POOL_SIZE = 50;
    public static void main(final String[] args) throws Exception {
        final ExecutorService executor = Executors.newFixedThreadPool(POOL_SIZE, runnable -> {
            final Thread thread = new Thread(runnable);
            thread.setDaemon(true); // !!
            return thread;
        });
        for (int i = 0; i < POOL_SIZE; i++) {
            executor.submit(() -> System.out.printf("Running %s%n", Thread.currentThread().getName()));
        }
    }
}