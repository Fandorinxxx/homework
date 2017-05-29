package ru.alternation.Trash.javasampleapproach.future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 http://javasampleapproach.com/java/java-core/java-future
 */

public class MainApp {
    static ExecutorService executor = Executors.newFixedThreadPool(10);

    public static void main(String[] args) throws Exception {

        Future<String> future = makeFuture("running Future");

        // other statements
        for (int i = 1; i <= 3; i++) {
            try {
                Thread.sleep(502);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("running outside... " + i + " time");
        }

        String contents = future.get();
        System.out.println(contents);
    }

    static Future<String> makeFuture(String inString) throws Exception {
        return executor.submit(() -> {
            for (int i = 1; i <= 5; i++) {
                try {
                    Thread.sleep(1002);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("running inside Future... " + i + " sec");
            }
            return "Done " + inString;
        });
    }
}
