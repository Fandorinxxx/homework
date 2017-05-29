package ru.alternation.Trash.javasampleapproach.completable_future;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.function.Supplier;

/**
 http://javasampleapproach.com/java/java-advanced/java-8-completablefutures
 */

public class MainApp {

    private static ArrayList<String> numbers = new ArrayList<String>(Arrays.asList("0", "1", "2"));

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        // ForkJoinPool.commonPool();

        System.out.println("Requesting");

        CompletableFuture<String> future = createCF(1);

        future = future.thenApply(Integer::parseInt).thenApply(r -> r * 2 * Math.PI).thenApply(s -> "apply>> " + s);
        //future.complete("foo");
        future.thenAccept(result -> System.out.println("accept: " + result));

        // other statements
        for (int i = 1; i <= 3; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("running outside... " + i + " time");
        }

//      future.complete("foo");
        String contents = future.get();
        System.out.println("Future result: " + contents);
    }

    public static CompletableFuture<String> createCF(int index) {
        return CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                try {
                    System.out.println("inside future: waiting for detecting...");
                    for (int i = 1; i <= 5; i++) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("running inside Future... " + i + " sec");
                    }
                    System.out.println("inside future: done...");

                    return numbers.get(index);
                } catch (Throwable e) {
                    return "not detected";
                }
            }
        });
    }
}
