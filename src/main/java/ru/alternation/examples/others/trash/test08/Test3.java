package ru.alternation.examples.others.trash.test08;

public class Test3 {

    static class I {
        static int i  = 1;
        static { System.out.println("-Is-"); }
        static int ii = Test.out("ii", 2);
        { System.out.println("-I-"); }
    }
    static class J extends I {
        static int j  = Test.out("j",  3);
        static int jj = Test.out("jj", 4);

        static { System.out.println("-Js-"); }
        { System.out.println("-J-"); }
    }
    static class K extends J {
        static int k = Test.out("k", 5);

        static { System.out.println("-Ks-"); }
        { System.out.println("-K-"); }
    }


    public static void main(String[] args) {
        System.out.println("System.out.println " + J.i);
        System.out.println("System.out.println " + K.j);

        new I();
        new I();
    }

    static int out(String s, int i) {
        System.out.println(s + "=" + i);
        return i;
    }

}