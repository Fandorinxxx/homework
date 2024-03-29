package ru.alternation.examples.youtube.mailru.concurrency.run;

public class RandomRunExample extends Thread {
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }

    public static void example() {
        for (int i = 0; i < 10; ++i) {
            Thread thread = new RandomRunExample();
            thread.start();
        }
    }

    /** run */
    public static void main(String[] args) {
        RandomRunExample.example();
    }
}