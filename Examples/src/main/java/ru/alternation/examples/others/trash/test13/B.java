package ru.alternation.examples.others.trash.test13;


class A {
    public String var = "A";

    String getVar() {
        return var;
    }

}


public class B extends A {

    public String var = "B";
    public String var2 = "B2";

    @Override
    String getVar() {
        return var;
    }

    void print() {
        System.out.println("super.var      = " + super.var);
        System.out.println("super.getVar() = " + super.getVar());
        System.out.println("this.var       = " + this.var);
        System.out.println("this.getVar()  = " + this.getVar());
    }

    public static void main(String[] args) {

        B b = new B();
        System.out.println(b.var);      // B
        System.out.println(b.var2);     // B2
        System.out.println(b.getVar()); // B

        b.print(); // просто две переменные с одинаковым именем в обоих классах

        A a = new B();
        System.out.println(a.var);      // A
        //System.out.println(a.var2);     // Error. java: cannot find symbol:   variable var2
        System.out.println(a.getVar()); // B // полиморфизм
    }
}
