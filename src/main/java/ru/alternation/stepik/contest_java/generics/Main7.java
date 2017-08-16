package ru.alternation.stepik.contest_java.generics;

/**
 You are asked to help with Java programming in a Pie company. At the moment they bake and sell pies,
 cakes and tarts packed in a nice boxes. Unfortunately, approach to boxes programming is quite outdated
 – each pie type requires its own box class. This approach is poorly scalable and will turn the situation into
 a nightmare with product range growth (imagine all these ApplePieBox, StrawberryPieBox, etc.).

 To avoid this implement universal Box class that will accomodate anything with put and give it back with get methods.

 Sample Input:
 Magical Box class

 Sample Output:
 Well done!

 */
public class Main7 {

    /**     Box for cakes     */
    class CakeBox {

        private Cake cake;

        public void put(Cake cake) {
            this.cake = cake;
        }

        public Cake get() {
            return this.cake;
        }
    }

    /**     Box for pies     */
    class PieBox {

        private Pie pie;

        public void put(Pie pie) {
            this.pie = pie;
        }

        public Pie get() {
            return this.pie;
        }
    }


    /**     Box for tarts     */
    class TartBox {

        private Tart tart;

        public void put(Tart tart) {
            this.tart = tart;
        }

        public Tart get() {
            return this.tart;
        }

    }
    private class Tart {}
    private class Cake {}
    private class Pie {}


    /*
        Hundred more such boring classes OR ...
        magic class for everything everybody is waiting for
    */

    class Box <T> {

        private T t;

        public void put(T t) {
            this.t = t;
        }

        public T get() {
            return this.t;
        }
    }

    public static void main(String[] args) {

    }
}


