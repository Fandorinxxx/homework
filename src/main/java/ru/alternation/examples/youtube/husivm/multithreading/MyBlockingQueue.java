package ru.alternation.examples.youtube.husivm.multithreading;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * https://youtu.be/vqPXhzD2bl0
 */
public class MyBlockingQueue {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> queue = new PriorityBlockingQueue<>();

        new Thread() {
            @Override
            public void run() {
                try {
                    System.out.println(queue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                queue.add("this is string");
            }
        }.start();
    }
}
