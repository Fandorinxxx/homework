package ru.alternation.stepik.alt;

import java.util.Arrays;

/**
 Sometimes overloading is used to preset default values for some arguments before executing the main logic inside a method.

 Implement two methods with the same name findIndexOfMaxInArray. You need to add arguments to the declarations of
 these methods as well.

 The first method should take two arguments: an array of integers and a boolean flag findFirst. The flag is used to set
 the method should find the first or the last max in the given array.

 The second method should take only one argument - an array of integers. It has to call the first method with
 the preset boolean flag as a true.

 Use the provided template, do not change it.

 Sample Input:
 1 2 2 1
 Sample Output:
 1 2

 */

public class Main006 {
    public static void main(String[] args) {

    }
    public static int findIndexOfMaxInArray(int[] array, boolean findFirst) {

        int index = 0;
        if (findFirst){
            for (int i = 1; i < array.length; i++) {
                if (array[index] < array[i]) {
                    index = i;
                }
            }
        } else {
            for (int i = 1; i < array.length; i++) {
               if (array[index] <= array[i]) {
                   index = i;
               }
            }
        }
        return index;
    }

    public static int findIndexOfMaxInArray(int[] array) {
        return findIndexOfMaxInArray(array, true);
    }

}