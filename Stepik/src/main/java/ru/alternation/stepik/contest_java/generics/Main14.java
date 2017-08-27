package ru.alternation.stepik.contest_java.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 # 3.14 Type Bounds

 You are asked to design CaloryGrader that is supposed to take list of anything that has calories and return list of
 the same items in order of ascending calories. The Calorie interface describing target items and some of
 the implementing classes are listed:

 ...

 Design GaloryGrader.grade method type signatures and provide suitable implementation to ensure:
 - Lists of anything implementing Calorie could be graded
 - Lists of anything else couldn't be graded (should fail at compile time)
 - Method signature should be as general as possible
 - Grading order is correct
 - The original list isn't modified by grading process


 ---------------
 **Sample Input:**
 CaloryGrader class
 ---------------
 **Sample Output:**
 Well done!

 */

public class Main14 {

    // Interface that defines that item has calories and may be compared by it
    interface Calorie extends Comparable<Calorie> {
        public int compareTo(Calorie object);
        public int getCalories();
    }

    // Examples of classes CaloryGrader is supposed to work with
    class Drink implements Calorie {
        // Some implemenation...
        public int compareTo(Calorie object) {return 0;}
        public int getCalories() {return 0;}
    }

    class Bakery implements Calorie {
        // Some implementation...
        public int compareTo(Calorie object) {return 0;}
        public int getCalories() {return 0;}
    }

    class Cake extends Bakery {
        // Some implementation...
    }


    /**
     * Grades different items by calories.
     *
     */
    class CaloryGrader {

        /**
         * Returns sorted in ascending order copy of items list.
         * <p>
         * Sort order is defined by item calories.
         *
         * @param items collection of items to sort
         * @return sorted copy
         */
        public List grade1(List<? extends Calorie> items) {
            return items.stream()
                    .sorted()
                    .collect(Collectors.toList());
        }

        public <T extends Calorie> List grade2(List<T> items) {
            List<T> sorted_items = new ArrayList<>(items);
            Collections.sort(sorted_items);
            return sorted_items;
        }

        public <T extends Comparable<? super T>> List grade(List<T> items) {
            return items.stream()
                    .sorted()
                    .collect(Collectors.toList());
        }



        // не позволят присвоить List<Cake> to List<Bakery>
        public <T extends Calorie> List<T> grade3(List<T> items) {
            return items.stream()
                    .sorted()
                    .collect(Collectors.toList());
        }
        public <T extends Calorie> List<T> grade4(List<T> items) {
            List<T> sorted_items = new ArrayList<>(items);
            Collections.sort(sorted_items);
            return sorted_items;
        }
        public <T extends Comparable<? super T>> List<T> grade5(List<T> items) {
            List<T> sorted_items = new ArrayList<>(items);
            Collections.sort(sorted_items);
            return sorted_items;
        }
    }

//     Кто-то так сделал: (Работает, если не указывать тип при создании)
//    class CaloryGrader<T extends Calorie> {
//        public List<T> grade(List<T> items) {
//            List<T> sorted_items = new ArrayList<>(items);
//            sorted_items.sort(Comparator.naturalOrder()); //( left, right) -> left.compareTo(right)
//            return sorted_items;
//        }
//    }

    public static void main(String[] args) {

        List<Bakery> list = new ArrayList<>(Arrays.asList(new Bakery[3]));
        List<Cake>  list2 = new ArrayList<>(Arrays.asList(new Cake[3]));


        List<Bakery> l2 = (new Main14().new CaloryGrader()).grade(list);
        List<Bakery> l3 = (new Main14().new CaloryGrader()).grade(list2);
        List<? extends Bakery> l4 = (new Main14().new CaloryGrader()).grade(list);
        List<? extends Bakery> l5 = (new Main14().new CaloryGrader()).grade(list2);

    }
}
