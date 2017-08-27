package ru.alternation.stepik.contest_java.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 # 4.9 Lists. Creating

 Create ArrayList by name list in any way known to you and fill it with the following four numbers 2, 0, 1, 7 .

 The code for displaying the list is already written.

 Sample Output:
 [2, 0, 1, 7]
 */


public class Main9 {
    public static void main(String[] args) {

        //List<Integer> list = new ArrayList<>(Arrays.asList(2, 0, 1, 7));
        List<Integer> list = new ArrayList<Integer>() {
            {
                add(2);
                add(0);
                add(1);
                add(7);
            }
        };

        System.out.println(list);
    }
}

