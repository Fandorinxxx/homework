package ru.alternation.stepik.contest_java.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 # 4.10 Lists. Bypassing

 The list of strings is given.

 List<String> nameList = new ArrayList<>(Arrays.asList("Mr.Green", "Mr.Yellow", "Mr.Red"));

 Output each its element in the loop with a new line.


 Sample Output:
 Mr.Green
 Mr.Yellow
 Mr.Red

 */
public class Main10 {
    public static void main(String[] args) {

        List<String> nameList = new ArrayList<>(Arrays.asList("Mr.Green", "Mr.Yellow", "Mr.Red"));

        nameList.forEach(System.out::println);

//        Iterator<String> iterator = nameList.iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }

    }
}
