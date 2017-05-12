package ru.alternation.Trash.Youtube.mailru.concurrency.interference;

public class StateObject {
    private int i;

    public synchronized void increment() {
        i++;
    }

    public int getI() {
        return i;
    }
}