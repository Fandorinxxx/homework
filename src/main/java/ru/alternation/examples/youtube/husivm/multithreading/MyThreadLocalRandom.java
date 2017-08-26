package ru.alternation.examples.youtube.husivm.multithreading;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 https://youtu.be/ilClO46x4Ig
 */
public class MyThreadLocalRandom {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(Math.random());
        System.out.println(ThreadLocalRandom.current().nextInt());

        System.out.println();
        System.out.println(TimeUnit.DAYS.toMillis(1));
        System.out.println(TimeUnit.DAYS.toSeconds(1));
        System.out.println(TimeUnit.DAYS.toMinutes(1));

        Thread.sleep(TimeUnit.SECONDS.toMillis(3));
    }
}
