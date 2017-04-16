package ru.alternation.Trash.InnerNested;

/**
 * Анонимные классы, получается, можно создавать в статическом контексте.
 * При этом не будет доступна ссылка на внешний класс.
 */

public class Test01 {
    @Override
    public String toString() {
        return "Main{}";
    }

    private int aaa = 44;

    public static void main(String[] args) {


        new Runnable() {
            @Override
            public void run() {
                //Test01.this.toString(); // из статического контекста низя
            }
        }.run();

        Test01 main = new Test01();
        B b = main.new B();
        main = null;

        System.out.println(b);
    }

    private class B {
        private int bbb = 66;
        @Override
        public String toString() {

            new Runnable() {
                @Override
                public void run() {
                    System.out.println(B.this.bbb); // обращение к внешнему классу из анонимного класса
                }
            }.run();

            return "B{} " + aaa + " " + Test01.this.toString(); // обращение к внешнему классу

        }
    }

    private static class C {

    }
}