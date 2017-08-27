package ru.alternation.examples.others.trash.overload;


//  http://www.quizful.net/interview/java/method-overloading-java
public class Main {

    private static void method(int a, double b) {

    }

    private static int method(double a, int b) {
        return 0;
    }



    public static void main(String[] args) {

        //method(6,8);
        //method(6.0,8.0);

        method(6.0,8);
        method(6,8.0);
    }
}

class A {
    Object get() { return null; }
}
class B extends A { // оверрайдит
    Number get() { return null; }
}
