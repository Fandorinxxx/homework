package ru.alternation.Simple.section6.stage2.step14;

import java.util.Collections;
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
        Set<T> result = new HashSet<>(); // можно, конечно, и без вспомогательной переменной

        s1.removeAll(set2);
        result.addAll(s1);
        s2.removeAll(set1);
        result.addAll(s2);
        return result;
    }

    public static <T> Set<T> symmetricDifference2(Set<? extends T> set1, Set<? extends T> set2) {
        Set<T> result = new HashSet<>(set1);
        set2.forEach( e -> {
            if (result.contains(e)) {
                result.remove(e);
            } else {
                result.add(e);
            }
        });
        return result;
    }

    public static <T> Set<T> symmetricDifference3(Set<? extends T> set1, Set<? extends T> set2) {
        Set<T> all = new HashSet<>(set1);
        all.addAll(set2);

        Set<T> result = new HashSet<>();
        all.forEach( e -> {
            if (set1.contains(e) ^ set2.contains(e)) { // исключающее или
                result.add(e);
            }
        });
        return result;
    }

    public static <T> Set<T> symmetricDifference4(Set<? extends T> set1, Set<? extends T> set2) {
        Set<T> all = new HashSet<>(set1);
        //all.addAll(set2);
        Collections.addAll(all, (T[]) set2.toArray());

        Set<T> retained = new HashSet<>(set1);
        retained.retainAll(set2);

        all.removeAll(retained);
        return all;
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
