package ru.alternation.stepik.contest_java.questions;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 4.26 Maps. Comparison

 The following 2 maps are given, what will be the result of their comparison using the equals method ?

 Map<String, Object> map1 = new TreeMap<>();
 map1.put("Gamma",  3);
 map1.put("Omega", 24);
 map1.put("Alpha",  1);

 Map<String, Object> map2 = new HashMap<>();
 map2.put("Omega", 24);
 map2.put("Gamma",  3);
 map2.put("Alpha",  1);

 System.out.println("map1.equals(map2) ? " + map1.equals(map2));


 null
 true   +
 false
 Exception

 */
public class MapsComparison {
    public static void main(String[] args) {
        Map<String, Object> map1 = new TreeMap<>();
        map1.put("Gamma",  3);
        map1.put("Omega", 24);
        map1.put("Alpha",  1);

        Map<String, Object> map2 = new HashMap<>();
        map2.put("Omega", 24);
        map2.put("Gamma",  3);
        map2.put("Alpha",  1);

        System.out.println("map1.equals(map2) ? " + map1.equals(map2));
    }
}
