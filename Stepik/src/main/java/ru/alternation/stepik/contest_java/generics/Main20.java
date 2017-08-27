package ru.alternation.stepik.contest_java.generics;

import java.util.ArrayList;
import java.util.List;

/**
 3.20 Type Violator

 You are asked to perform security audit in a company that bakes Bakery and different sublasses of it and sells it in
 a nice boxes. Before release to customer all boxes are checked with carefully designed NaiveQualityControl class.
 Numerous cases when something other than Bakery (e.g. Paper) was packed in Boxes and escaped the quality
 check happened recently.

 Short look at NaiveQualityControl leads to conclusion that it's quite easy to provide NaiveQualityControl with Box
 filled with Paper that will pass QC, and you task is to demonstrate this. Code of related classes follows:

 ...

 You need to add implementation to Violator.defraud() method that will do the following:
 ﻿- Create List of Boxes<? extends Bakery> according to method signature
 - Put Paper object in at least one Box in the list
 - The resulting list should pass NaiveQualityControl check

 You shouldn't change method signature or change code of any other classes, just add implementaiton to defraud method.

 ---------------
 **Sample Input:**
 Violator class
 ---------------
 **Sample Output:**
 Well done!

 */

// This class and its subclasses should pass quality check
class Bakery {}

class Cake extends Bakery {}

// But this should not
class Paper {}

// These boxes are used to pack stuff
class Box<T> {
    void put(T item) { /* implementation omitted */ }
    T get() { /* implementation omitted */ return null;}
}

// This quality checker ensures that boxes for sale contain Bakery and anything else
class NaiveQualityControl {

    public static boolean check(List<Box<? extends Bakery>> boxes) {
        // Method signature guarantees that all illegal calls will produce compile-time error... or not?
        return true;
    }

}

/**
 * Class to work with
 */
class Violator {

    public static List<Box<? extends Bakery>> defraud() {

        Box<Paper> paperBox = new Box<>();
        paperBox.put(new Paper());

        List listRaw = new ArrayList();
        listRaw.add(paperBox);

        // можно и присвоить сырой тип дженерику на свой риск
        //List<Box<? extends Bakery>> list = listRaw; // 'ok'

        return listRaw;
    }

}


public class Main20 {
    public static void main(String[] args) {
        NaiveQualityControl.check(Violator.defraud());

        // Т.е. можно передать сырой тип с любым содержимым в метод, принимающий дженерик
        List list = new ArrayList();
        list.add(100);
        NaiveQualityControl.check(list);
    }
}
