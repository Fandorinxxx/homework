package ru.alternation.Trash.Youtube.husivm.multithreading;

import java.util.concurrent.ThreadFactory;

/**
 * https://youtu.be/Bn4XARHucQI
 */
public class MyThreadFactory {
    public static void main(String[] args) throws Exception {
        ThreadFactory threadFactory = new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                thread.setPriority(Thread.MAX_PRIORITY);
                return thread;
            }
        };
        threadFactory.newThread(new MyRun()).start();
    }

    static class MyRun implements Runnable {
        @Override
        public void run() {
            System.out.println(1);
        }
    }
}
