package ru.alternation.stepik.contest_java.collections_framework;

import java.util.NavigableMap;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 # 1.25 TreeMap

 Modify and return the given map as follows:
    - if the first key % 2 != 0 return sub map from First Key inclusive to FirstKey+4 inclusive in descending order
    - else return sub map from LastKey-4 inclusive to the Last Key inclusive in descending order


 Sample Input:
 1:one 2:two 3:three 4:four 5:five 6:six 7:seven

 Sample Output:
 5 : five
 4 : four
 3 : three
 2 : two
 1 : one

 */


public class Main25 {

    public static void main(String[] args) {
        NavigableMap<Integer, String> map = new TreeMap<>();
        map.put(1, "1");
        map.put(2, "2");
        map.put(3, "3");
        map.put(4, "4");
        map.put(5, "5");
        map.put(6, "6");
        map.put(7, "7");


        System.out.println(getSubMap(map));

    }

    public static NavigableMap<Integer, String> getSubMap(NavigableMap<Integer, String> map){
        return map.firstKey() % 2 != 0
                ? map.subMap(map.firstKey(), true, map.firstKey() + 4, true).descendingMap()
                : map.subMap(map.lastKey() - 4, true, map.lastKey(), true).descendingMap();
    }

    public static NavigableMap<Integer, String> getSubMap2(NavigableMap<Integer, String> map){

        SortedMap<Integer, String> out;

        Integer firstKey = map.firstKey();
        if (map.firstKey() % 2 != 0) {
            out = map.subMap(firstKey, firstKey+4 + 1);
        } else {
            Integer lastKey = map.lastKey();
            out = map.subMap(lastKey-4, lastKey + 1);
        }
        return ((NavigableMap<Integer, String>)out).descendingMap();
    }
}
