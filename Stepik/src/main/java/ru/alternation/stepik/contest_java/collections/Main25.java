package ru.alternation.stepik.contest_java.collections;

import java.util.Map;
import java.util.TreeMap;

/**
 # 4.25 Maps. Bypassing

 The map is given.
 Output each its key-value pair in the loop with a new line.
 Each line must be in form of key=value (for example, Gamma=3)

 Sample Output:
 Alpha=1
 Gamma=3
 Omega=24


 */
public class Main25 {
    public static void main(String[] args) {


        Map<String, Integer> map = new TreeMap<>();
        map.put("Gamma",  3);
        map.put("Omega", 24);
        map.put("Alpha",  1);

//        for (Map.Entry<String, Integer> entry : map.entrySet()) {
//            System.out.println(entry);
//        }

        map.entrySet().forEach(System.out::println);

    }
}
