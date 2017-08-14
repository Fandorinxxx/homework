package ru.alternation.examples.Youtube.husivm.multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 https://youtu.be/vVyjcJLFNWQ
 */
public class MyExecutor {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(new MyRunable());
        System.out.println(executorService.submit(new MyCallable()).get());
        executorService.shutdown();
    }

    static class MyRunable implements Runnable {
        @Override
        public void run() {
            System.out.println(1);
        }
    }

    static class MyCallable implements Callable<String> {
        @Override
        public String call() throws Exception {
            return "2";
        }
    }
}
