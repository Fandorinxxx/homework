package ru.alternation.examples.others.trash.test08;

public class Test2 {

    static class I {
        static int i  = 1;
        static int ii = Test.out("ii", 2);
    }
    static class J extends I {
        static int j  = Test.out("j",  3);
        static int jj = Test.out("jj", 4);
    }
    static class K extends J {
        static int k = Test.out("k", 5);
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
