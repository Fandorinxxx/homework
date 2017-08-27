package ru.alternation.stepik.contest_java.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 # 4.13 Lists. Big deal

 A list with numbers from 0 to 20 is given.
 Remove numbers less than 10 from it without additional lists or arrays usage.
 Modify the code so that it does not raise the ConcurrentModificationException.

 Hint ! Use the Iterator.


 Sample Output:
 [10, 11, 12, 13, 14, 15, 16, 17, 18, 19]

 */

public class Main13 {
    public static void main(String[] args) {

        List<Integer> delList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            delList.add(i);
        }


//        //*** change this code which raises ConcurrentModificationException
//        for (Integer num : delList) {
//            if (num < 10) delList.remove(num);
//        }
//        //***

        // ok
//        delList = delList.stream()
//                .filter(integer -> integer >= 10)
//                .collect(Collectors.toList());

//        Iterator<Integer> iterator = delList.iterator();
//        while (iterator.hasNext()) {
//            if (iterator.next() < 10) {
//                iterator.remove();
//            }
//        }

        delList.removeIf(integer -> integer < 10);







        System.out.println(delList);

    }
}

