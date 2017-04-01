package ru.alternation.Trash.Others.Trash.Test04;

// https://youtu.be/J88M_hYINUw
public class Test{


    static interface DemoInter { // static   не нужен
        abstract void apply1();  // abstract не нужен // public по-умолчанию
        default  void apply2(){}
    }

    abstract static class DemoAbsr{
        void apply1(){}
        void apply2(){}
    }

    abstract static class DemoAbsrOne{
        abstract void apply1();
        void apply2(){}
    }

    public static void main(String[] args) {

        DemoInter o =
                new DemoInter() {
                    @Override
                    public void apply1() {

                    }
                };

        DemoAbsr demoAbsr=new DemoAbsr() {}; // просто анонимный класс

        DemoAbsrOne demoAbsrOne=new DemoAbsrOne() { // с реализацией abstract метода
            @Override
            void apply1() {

            }
        };











    }


}