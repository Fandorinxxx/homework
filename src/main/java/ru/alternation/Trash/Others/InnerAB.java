package ru.alternation.Trash.Others;

/**
 * В Inner classes нельзя статик поля/методы
 */
public class InnerAB {
    private static String s = "s";
    public static void main(String[] args) {
        new InnerAB().new B().print();
    }

    class A {
        //private static String strs = "0s";
        private String str = "0_";
    }

     class B extends A {
        private String str = "1_";

        public void print(){
            System.out.println(super.str); // private
            System.out.println(str);       // private
            System.out.println(s);         // private
        }

    }
}
