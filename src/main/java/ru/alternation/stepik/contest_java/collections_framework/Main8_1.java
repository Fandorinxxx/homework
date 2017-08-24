package ru.alternation.stepik.contest_java.collections_framework;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

/**
 2.1 ArrayList basic

 You need to find the max element in the collection. Just write your own implementation of the method
 public static Integer maxElem(List<Integer> list)

 ***If you have any problems:
 View the documentation of class Collections
 search method


 Sample Input:
 362 348 270 662 236 658 202 282 337 254

 Sample Output:
 662

 */
public class Main8_1 {
    public static Integer maxElem(List<Integer> list){
        return Collections.max(list);
    }

    public static Integer maxElem2(List<Integer> list){
        OptionalInt optionalInt = list.stream().mapToInt(Integer::intValue).max();
        return optionalInt.getAsInt();
    }

    public static Integer maxElem3(List<Integer> list){
        return list.stream().mapToInt(Integer::intValue).max().getAsInt();

//        optionalInt.ifPresent(System.err::println);
//        if (optionalInt.isPresent()) {
//            return optionalInt.getAsInt();
//        } else
//            throw new RuntimeException("");
    }

    public static Integer maxElem4(List<Integer> list){
        Optional<Integer> integerOptional = list.stream().max(Comparator.comparingInt(Integer::intValue));
        return integerOptional.get();
    }
    public static Integer maxElem5(List<Integer> list){
        return list.stream().max(Comparator.comparingInt(Integer::intValue)).get();
    }
    public static Integer maxElem6(List<Integer> list){
        return list.stream().reduce((i1, i2) -> i1 > i2 ? i1 : i2).get();
    }
    public static Integer maxElem7(List<Integer> list){
        return list.stream().reduce(Math::max).get();
    }
    public static Integer maxElem8(List<Integer> list){
        return list.stream().reduce(Integer.MIN_VALUE, Math::max);
    }

}
