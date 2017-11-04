package ru.alternation.examples.others.trash.test13;


class A {
    public String var = "A";

    String getVar() {
        return var;
    }
}


public class B extends A {

    public String var = "B";

    @Override
    String getVar() {
        return var;
    }

    public static void main(String[] args) {

        B b = new B();
        System.out.println(b.var);      // B
        System.out.println(b.getVar()); // B

        A a = new B();
        System.out.println(a.var);      // A
        System.out.println(a.getVar()); // B
    }
}
