package ru.alternation.stepik.contest_java.collections_framework;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;

/**
 # 1.22 Spliterator

 1. On spliteratorWork( List<Double> lst ):
    -using Spliterator add to List<Double> sqrts all square roots of items from lst, if this item greater than 1
    -use Math.sqrt(number) to find square root : Math.sqrt(4)-> 2.0
 2. On print(List<Double> list):
    -get spliterator() of given list
    -divide spliterator into 2 parts ( use spliterator.trySplit())
    -print all items which >=2 from first part (use .println())
    -print empty string
    -print all items which >=10 from second part (use .println())


 *! remember when you use trySplit() method :
 List<Integer> lst = new ArrayList<>(Arrays.asList(1,1,1,2,2,2,2));

 Spliterator<Integer> split = lst.spliterator();
 split.trySplit()...//-> 1 1 1 (its your first path of spliterator)
 split...//2 2 2 2 (now split contains of second path)


 Sample Input:
 4 4 4 100 100 100
 Sample Output:
 2.0
 2.0
 2.0

 10.0
 10.0
 10.0

 */


public class Main22 {
    public static List<Double> spliteratorWork(List<Double> lst){
        List<Double> sqrs = new ArrayList<>();
        Spliterator<Double> spliterator = lst.spliterator();
//        while (spliterator.tryAdvance(aDouble -> {
//            if(aDouble > 1) {
//                sqrs.add(Math.sqrt(aDouble));
//            }
//        }));
        spliterator.forEachRemaining(aDouble -> {
            if(aDouble > 1) {
                sqrs.add(Math.sqrt(aDouble));
            }
        });

        return sqrs;
    }
    public static void print(List<Double> list){
        Spliterator<Double> spliterator1 = list.spliterator();
        Spliterator<Double> spliterator2 = spliterator1.trySplit(); // возвращает 1 половину
        spliterator2.forEachRemaining(aDouble -> {
            if (aDouble >= 2) {
                System.out.println(aDouble);
            }
        });
        System.out.println();
        spliterator1.forEachRemaining(aDouble -> {  // вторая половина
            if (aDouble >= 10) {
                System.out.println(aDouble);
            }
        });
    }
}
