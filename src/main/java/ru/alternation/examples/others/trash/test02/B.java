package ru.alternation.examples.others.trash.test02;

//https://ru.stackoverflow.com/questions/464028/Что-раньше-инициализируется-поля-класса-или-конструктор

class A
{
    int a = 9;
    static int s = 9;

    {
        System.out.print("3");
//        System.out.println(" ."+s+". ");
//        System.out.println(" ."+a+". ");
    }

    static {
        System.out.print("1");
//        System.out.println(" ."+s+". ");
    }

    public A() {
        System.out.print("4");
    }

    public static void main(String[] args) {
        new A();
    }
}

public class B extends A {
    {
        System.out.print("5");
    }

    static {
        System.out.print("2");
    }

    public B() {
        System.out.print("6");
    }

}