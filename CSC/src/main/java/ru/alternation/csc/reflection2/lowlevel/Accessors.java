package ru.alternation.csc.reflection2.lowlevel;

public class Accessors {

    public static void main(String[] args) {
        Inner.i = 10;
    }

    static class Inner {
        private static int i;
    }
}
