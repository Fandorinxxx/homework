package ru.alternation.Trash;


public class InnerNested {

    private String privatNonStaticStr = "InnerNested";
    private String privatStaticStr = "InnerNestedStatic";


    public static void main(String[] args) {


        //Inner inner = new InnerNested().new Inner();
        InnerNested.Inner inner = new InnerNested().new Inner();
        inner.a();

        new InnerNested().m();

        //Nested nested = new Nested();
        InnerNested.Nested nested = new InnerNested.Nested();

        nested.a();

        Outer out = new Outer();
        out.a();

    }

    void m(){
        Inner inner = this.new Inner();
        inner.a();
    }

    // Как и другие поля класса, вложенные классы могут быть объявлены как private, public, protected, или package private.
    // Не статические классы имеют доступ к полям содержащего класса, даже если они объявлены как private.
    public class Inner{
        void a(){
            System.out.println("Inner");
            //System.out.println(privatNonStaticStr + "\n"); // Ok
            //System.out.println(privatStaticStr + "\n");    // Ok
        }
        //static int i;     // Bad (static)
        //static void b(){} // Bad (static)
    }

    // Как статические переменные и методы, вложенный (статический) класс связан с внешним классом.
    // И так же как и статические методы не может напрямую обращаться к полям объекта внешнего класса.
    public static class Nested{
        void a(){
            System.out.println("Nested");
            //System.out.println(privatNonStaticStr); // Bad
            //System.out.println(privatStaticStr);    // Bad
        }
        static int i = 7; // Ok (static)
        static void b(){} // Ok (static)
    }

}
class Outer{
    void a(){
        System.out.println("Out");
    }
}
