package ru.alternation.examples.youtube.husivm.multithreading;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * https://youtu.be/mHkvGWks_YQ
 */
public class MyCyclicBarier {
        public static void main(String[] args) {
            CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new Run());
            new Sportsman(cyclicBarrier);
            new Sportsman(cyclicBarrier);
            new Sportsman(cyclicBarrier);
        }


    static class Run extends Thread {
        @Override
        public void run() {
            System.out.println("Run is begun");
        }
    }

    static class Sportsman extends Thread {
        CyclicBarrier barrier;

        public Sportsman(CyclicBarrier barrier) {
            this.barrier = barrier;
            start();
        }

        @Override
        public void run() {
            try {
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}
