package ru.alternation.examples.Youtube.husivm.multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * https://youtu.be/SWKvCA8eClg
 */
public class MyRunAndCallable {

    public static void main(String[] args) throws Exception {
        Callable<Integer> callable = new MyCallable();
        FutureTask<Integer> futureTask = new FutureTask<>(callable);
        new Thread(futureTask).start();
        System.out.println(futureTask.get());
    }

    static class MyCallable implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            int j = 0;
            for (int i = 0; i < 10; i++, j++) {
                Thread.sleep(300);
            }
            return j;
        }
    }
}
