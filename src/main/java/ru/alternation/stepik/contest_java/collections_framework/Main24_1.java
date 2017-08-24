package ru.alternation.stepik.contest_java.collections_framework;

import java.util.Map;

/**
 # 1.24 Map basic methods

 Modify and return the given map as follows:
 - if the key "a" has a value, set the key "b" to have that same value.
 - In all cases remove the key "c", leaving the rest of the map unchanged.

 {"a":"abstraction","b":"boolean","c":"xyz"} -> {"a":"abstraction","b":"abstraction"}


 Sample Input:
 a:Abstraction,b:Boolean,c:xyz

 Sample Output:
 a : Abstraction
 b : Abstraction

 */


public class Main24_1 {
    public static Map<String, String> mapShare(Map<String, String> map) {

        if (map.containsKey("a")) {
            map.put("b", (map.get("a")));
        }
        map.remove("c");

        return map;
    }
}
