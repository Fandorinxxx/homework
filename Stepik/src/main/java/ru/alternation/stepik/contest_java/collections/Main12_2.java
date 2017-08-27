package ru.alternation.stepik.contest_java.collections;

import java.util.ArrayList;
import java.util.List;

/**
 # 4.12 Lists. Converting

 The list of GreekLetter objects is given.
 ﻿  List<GreekLetter> letterList = new ArrayList<>();
 Convert it to the object array by name objArray.
 The code for displaying the array is already written.


 Sample Output:
 {letter='Gamma', position=3}
 {letter='Omega', position=24}
 {letter='Alpha', position=1}

 */

public class Main12_2 {
    public static void main(String[] args) {

        List<GreekLetter> letterList = new ArrayList<>();
        letterList.add(new GreekLetter("Gamma",  3));
        letterList.add(new GreekLetter("Omega", 24));
        letterList.add(new GreekLetter("Alpha",  1));


        //write your code here
        Object[] objArray = letterList.toArray();


        for (int i = 0; i < objArray.length; i++) {
            System.out.println(objArray[i]);
        }
    }

    static class GreekLetter {

        private String letter;
        private Integer position;

        public GreekLetter(String letter, Integer position) {
            this.letter = letter;
            this.position = position;
        }

        @Override
        public String toString() {
            return "{" +
                    "letter='" + letter + '\'' +
                    ", position=" + position +
                    '}';
        }
    }
}
