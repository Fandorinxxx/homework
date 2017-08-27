package ru.alternation.examples.others;

// https://www.youtube.com/watch?v=qAPWNjfx1bU
public class ClassToAccess {
    protected ClassToAccess() {
    }
    protected void print(){
        System.out.println("ClassToAccess");
    }
}


//import ClassToAccess;
//
//public class Test{
//
//    public static void main(String[] args) {
//
//        new ClassToAccess(){
//            @Override
//            protected void print() {
//                super.print();
//            }
//        }.print();
//
//        ClassToAccess classToAccess = new ClassToAccess(){
//            @Override
//            protected void print() {
//                super.print();
//            }
//        };
//        classToAccess.print(); // error
//
//
//        ClassToAccess classToAccess2 = new MySubClass();
//        classToAccess2.print(); // error

//        MySubClass classToAccess3 = new MySubClass();
//        classToAccess3.print();  // ok
//
//    }
//    static class MySubClass extends ClassToAccess{
//        @Override
//        public void print() {
//            super.print();
//        }
//    }
//
//}
