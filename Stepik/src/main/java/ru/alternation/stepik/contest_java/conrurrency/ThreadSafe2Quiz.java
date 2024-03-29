package ru.alternation.stepik.contest_java.conrurrency;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean; //

/**
 5.13 Make the following code thread-safe (ex. 2)

 Make the following code below thread safe.

 Hint: is there something from the atomic package could be used?
 */
public class ThreadSafe2Quiz {
    public static void main(final String[] args) throws Exception {
        final ThreadSafe2 runnable = new ThreadSafe2();
        new Thread(runnable).start();
        TimeUnit.SECONDS.sleep(5);
        runnable.cancel();
    }

    public static class ThreadSafe2 implements Runnable {

        private final AtomicBoolean done = new AtomicBoolean(false); //

        @Override
        public void run() {
            while (!done.get()) {
                System.out.println("Running");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (final InterruptedException ex) {
                    // reset the interruption status
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println("Done");
        }

        public void cancel() {
            done.set(true);
        }
    }
}