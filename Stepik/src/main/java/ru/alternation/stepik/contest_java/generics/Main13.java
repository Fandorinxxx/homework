package ru.alternation.stepik.contest_java.generics;

import java.util.ArrayList;
import java.util.List;

/**
 # 3.13 Wildcard Capture

 https://docs.oracle.com/javase/tutorial/java/generics/capture.html

 You are provided with the backbone of ListMultiplicator class that has multiply method that takes list and multiplies
 its content specified number of times. The original list content should be changed after method returns.
 The task is to add implementation to the method without changing its signature.

 You are guaranteed that:
 - list is non null
 - n is equals or greater than zero

 ﻿n stands for number of times the original list repeated in the result.
 So if n equals zero the resulting list should be empty.


 For original list:
 [1, 2, 3]

 and n equals 2 the result should be:
 [1, 2, 3, 1, 2, 3]



 ---------------
 **Sample Input:**
 ListMultiplicator class
 ---------------
 **Sample Output:**
 Well done!

 */



/**
 Class to modify
 */

//class ListMultiplicator {
class Main13 {

    /**
     Multiplies original list provided numper of times

     @param list list to multiply
     @param n times to multiply, should be zero or greater
     */
    public static void multiply(List<?> list, int n) {
        // Add implementation here
        multiplyHelper(list, n);
    }
    private static <T> void multiplyHelper(List<T> list, int n) {
        if (n == 0) {
            list.clear();
        } else {
            List<T> origin = new ArrayList<>(list);
            while (--n > 0) {
                list.addAll(origin);
            }
//            int size = list.size();
//            for (int i = 1; i < n; i++) {
//                for (int j = 0; j < size; j++) {
//                    list.add(list.get(j));
//                }
//            }
        }
    }


    public static void main(String[] args) {

    }

}
