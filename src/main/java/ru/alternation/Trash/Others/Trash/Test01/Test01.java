package ru.alternation.Trash.Others.Trash.Test01;



class A{

    //private A(){}

    void fooA(){
        System.out.println(1);
    }

    public void method() {  }

    public class InnerClass {
        public void method() { }

        public void anotherMethod() {
            method();
            A.this.method();
        }
    }

}

class B extends A{
    public B(){}

    void fooA(){
        System.out.println(2);
        super.fooA();
        System.out.println(2);
    }
}


public class Test01 {

    public static void main(String[] args)  {

        B b = new B();
        b.fooA();

    }
}