package ru.alternation.stepik.contest_java.generics;

import java.io.Serializable;

/**
 There are different points of view on "Apples and Oranges" problem. You are provided with implementation that allows
 comparison of apples with oranges, the task is to redesign type system and implementation in a classical way that
 prohibits comparison of Oranges and Apples.

 Following requirements exists:
 - Comparison of Apples with Apples and Oranges with Oranges should be allowed
 - Comparison of Apples with Oranges and Oranges with Apples should be restricted at a compile time
 - Class hierarchy should be preserved
 - Fruits comparison doesn't matter, you may disable it
 - Solution should not raise compile-time warnings (e.g. "raw types")

 ---------------
 **Sample Input:**
 Apple and Orange classes
 ---------------
 **Sample Output:**
 Well done!

 */

public class Main17 {

    // This implementaion allows comparison of apples and oranges
    class Fruit<T extends Fruit<T>> implements Comparable<T> {

        private final int weight;

        public Fruit(int weight) {
            this.weight = weight;
        }

        @Override
        public int compareTo(T o) {
            // casting 'o' to 'Fruit<?>' is redundant -- но почему в Enum оно используется?
            // Видимо, оно там не нужно, но IDEA не палит.
            Fruit<?> other = (Fruit<?>)o;  // for other.weigth or
            return Integer.compare(this.weight, other.weight);  // 'weigth' has private access in 'ru.alternation.stepik.contest_java.generics.Main17.Fruit'
        }

        public int getWeigth() {
            return this.weight;
        }

    }

    class Apple extends Fruit<Apple> {
        public Apple(int weight) {
            super(weight);
        }

    }

    class Orange extends Fruit<Orange> {
        public Orange(int weight) {
            super(weight);
        }
    }
}
