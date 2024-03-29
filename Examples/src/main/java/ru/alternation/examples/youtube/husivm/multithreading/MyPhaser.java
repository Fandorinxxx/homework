package ru.alternation.examples.youtube.husivm.multithreading;

import java.util.concurrent.Phaser;

/**
 * https://youtu.be/_Xku6QGzUwY
 */
public class MyPhaser {
    public static void main(String[] args) {
        Phaser phaser = new Phaser(2);
        new Washer(phaser);
        new Washer(phaser);
    }

    static class Washer extends Thread {
        Phaser phaser;

        public Washer(Phaser phaser) {
            this.phaser = phaser;
            start();
        }

        @Override
        public void run() {
            for (int i = 0; i < 3; i++) {
                System.out.println(getName() + " washing the car");
                phaser.arriveAndAwaitAdvance();
            }
        }
    }
}