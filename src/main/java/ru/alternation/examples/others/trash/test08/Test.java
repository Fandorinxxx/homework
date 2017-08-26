package ru.alternation.examples.others.trash.test08;

/**
 * http://docs.oracle.com/javase/specs/jls/se8/html/jls-12.html#jls-12.4.1
 */

public class Test {

    interface I {
        int i = 1, ii = Test.out("ii", 2);
    }
    interface J extends I {
        int j = Test.out("j", 3), jj = Test.out("jj", 4);
    }
    interface K extends J {
        int k = Test.out("k", 5);
    }


    public static void main(String[] args) {
        System.out.println(J.i);
        System.out.println(K.j);
    }
    static int out(String s, int i) {
        System.out.println(s + "=" + i);
        return i;
    }

}
