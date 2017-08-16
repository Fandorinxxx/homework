package ru.alternation.stepik.contest_java.generics;

/**
 # 3.12 Wildcards

 You are working in a Pie company. The business going well and bakeries are selling abroad. Sometimes due to custom
 rules and trade regulations it is necessary to pakage bakeries into box with more basic name like Bakery or Food.
 Full class hierarchy follows:

 ```...```

 There is Packer class available, but he is designed with buisiness rule violation and lacks implementation.
 Correct the Packer code to ensure that:

 - Any kind of Bakery could be repacked to the Box with more basic type (e.g. from box with Pie to box with Food)
 - Basic stuff like food can't be repacked into narrowly typed Box'es (e.g. with Cakes)
 - Arbitrary stuff like Strings or Objects can't be repacked without compile-time errors or warnings
 - Repacking actually happens

 ---------------
 **Sample Input:**
 Packer class
 ---------------
 **Sample Output:**
 Well done!

 */

public class Main12 {

    class Food {}

    class Bakery extends Food {}

    class Cake extends Bakery {}

    class Pie extends Bakery {}

    class Tart extends Bakery {}

    interface Box<T> {
        public void put(T item);
        public T get();
    }


    /**
     This packer has too much freedom and could repackage stuff in wrong direction.
     Fix method types in signature and add implementation.
     */
    class Packer {
        public void repackage(Box<? super Bakery> to, Box<? extends Bakery> from) {
            to.put(from.get());
        }
    }

    public static void main(String[] args) {}
}
