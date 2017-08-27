package ru.alternation.stepik.contest_java.questions;

import java.util.Map;
import java.util.TreeMap;

/**
 4.26 Maps. Comparison 2

 The following 2 maps are given, what will be the result of their keys comparison using the equals method ?

 Map<String, Object> map1 = new TreeMap<>();
 map1.put("Gamma", 1);
 map1.put("Omega", 2);
 map1.put("Alpha", 3);

 Map<String, Object> map2 = new TreeMap<>();
 map2.put("Omega", 777);
 map2.put("Gamma", 777);
 map2.put("Alpha", 777);


 System.out.println("map1.keys.equals(map2.keys) ? " + map1.keySet().equals(map2.keySet()));

 false
 true  +
 null
 Exception

 */
public class MapsComparison2 {
    public static void main(String[] args) {
        Map<String, Object> map1 = new TreeMap<>();
        map1.put("Gamma", 1);
        map1.put("Omega", 2);
        map1.put("Alpha", 3);

        Map<String, Object> map2 = new TreeMap<>();
        map2.put("Omega", 777);
        map2.put("Gamma", 777);
        map2.put("Alpha", 777);


        System.out.println("map1.keys.equals(map2.keys) ? " + map1.keySet().equals(map2.keySet()));
    }
}
