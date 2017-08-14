package ru.alternation.examples.Youtube.CSC.reflection2.junit.tests;

import ru.alternation.examples.Youtube.CSC.reflection2.junit.Test;

public class Test1 {

    @Test
    public void test1() {
        System.out.println("Hello from test1!");
    }

    @Test
    public static void test2() {
        System.out.println("Hello from test2!");
    }
}
