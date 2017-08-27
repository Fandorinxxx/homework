package ru.alternation.csc.reflection2.junit.tests;

import ru.alternation.csc.reflection2.junit.Test;

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
