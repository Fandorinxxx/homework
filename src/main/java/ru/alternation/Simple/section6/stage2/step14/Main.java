package ru.alternation.Simple.section6.stage2.step14;

import java.util.HashSet;
import java.util.Set;

/**
 Реализуйте метод, вычисляющий симметрическую разность двух множеств.
https://ru.wikipedia.org/wiki/Симметрическая_разность

 Метод должен возвращать результат в виде нового множества. Изменять переданные в него множества не допускается.

 Пример:

 Симметрическая разность множеств {1, 2, 3} и {0, 1, 2} равна {0, 3}.
 */


public class Main  {

    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {

        Set<T> s1 = new HashSet<>(set1);
        Set<T> s2 = new HashSet<>(set2);
        Set<T> s = new HashSet<>();

        s1.removeAll(set2);
        s.addAll(s1);
        s2.removeAll(set1);
        s.addAll(s2);
        return s;
    }


    public static void main(String[] args) {

        Set<Integer> s1 = new HashSet<>();
        s1.add(1);
        s1.add(2);
        s1.add(3);
        Set<Integer> s2 = new HashSet<>();
        s2.add(0);
        s2.add(1);
        s2.add(2);

        System.out.println("s1 = " + s1);
        System.out.println("s2 = " + s2);
        Set<Integer> s = symmetricDifference(s1, s2);
        System.out.println("s  = " + s);


    }

}
