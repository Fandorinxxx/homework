package ru.alternation.Trash.Youtube.mailru.concurrency.interference;

public final class InterferenceThread extends Thread {
    private final InterferenceExample checker;
    private static int i; // статик, и с ней работают 2 потока
    private static StateObject so = new StateObject(); // или так


    public InterferenceThread(InterferenceExample checker) {
        this.checker = checker;
    }

    public void run() {
        while (!checker.stop()) {
            increment();
        }
    }

    public void increment() {
        synchronized(InterferenceThread.class) { // fix // но заметно дольше выполняется теперь 1387 ms -> 8226 ms
            i++;
        } //
        //so.increment();
    }

    public int getI() {
        return i;
        //return so.getI();
    }
}