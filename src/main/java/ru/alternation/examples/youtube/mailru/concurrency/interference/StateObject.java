package ru.alternation.examples.youtube.mailru.concurrency.interference;

public class StateObject {
    private int i;

    public synchronized void increment() {
        i++;
    }

    public int getI() {
        return i;
    }
}