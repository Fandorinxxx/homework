package ru.alternation.stepik.contest_java.collections;

import java.util.Map;
import java.util.TreeMap;

/**
 # 4.24 Maps. Creating

 Create TreeMap by name map in any way known to you and fill it with the following three key - value pairs:
    Omega - 24
    Alpha - 1
    Gamma - 3
 where strings - keys and numbers - values.

 The code for displaying the map is already written.

 Sample Output:
 {Alpha=1, Gamma=3, Omega=24}

 */

public class Main24 {

    public static void main(String[] args) {

        Map<String, Integer> map = new TreeMap<String, Integer>() {
            {
                put("Omega", 24);
                put("Alpha", 1);
                put("Gamma", 3);
            }
        };

        System.out.println(map);
    }
}
