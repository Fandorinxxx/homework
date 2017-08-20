package ru.alternation.stepik.contest_java.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 # 4.12 Lists. Converting

 The list of strings is given.
    List<String> nameList = new ArrayList<>(Arrays.asList("Mr.Green", "Mr.Yellow", "Mr.Red"));
 Convert it to the string array by name strArray.
 The code for displaying the array is already written.


 Sample Output:
 Mr.Green
 Mr.Yellow
 Mr.Red

 */

public class Main12_1 {
    public static void main(String[] args) {

        List<String> nameList = new ArrayList<>(Arrays.asList("Mr.Green", "Mr.Yellow", "Mr.Red"));


        //write your code here
        String[] strArray = nameList.toArray(new String[0]);
        // String[] strArray = nameList.stream().toArray(String[]::new);


        for (int i = 0; i < strArray.length; i++) {
            System.out.println(strArray[i]);
        }

//        // то же самое, но в таком цикле значения массива не поменяешь
//        for (String aStrArray : strArray) {
//            System.out.println(aStrArray);
//        }

    }
}
