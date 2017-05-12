package ru.alternation.Trash.Youtube.mailru.concurrency.interference;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;


public class InterferenceExample {
    private static final int HundredMillion = 100_000_000;
    private AtomicInteger counter = new AtomicInteger();

    public boolean stop() {
        return counter.incrementAndGet() > HundredMillion;
    }

    public void example() throws InterruptedException {
        // инкримент HundredMillion раз
        long start = System.currentTimeMillis();
        InterferenceThread thread1 = new InterferenceThread(this);
        InterferenceThread thread2 = new InterferenceThread(this);
        thread1.start();
        thread2.start();
        thread1.join();
        System.out.println("Expected: " + HundredMillion);
        System.out.println("Result: " + thread1.getI());
        System.out.println("Time passed: " + (System.currentTimeMillis() - start));
    }

    /** run */
    public static void main(String[] args) throws InterruptedException {
        new InterferenceExample().example();
    }
}
