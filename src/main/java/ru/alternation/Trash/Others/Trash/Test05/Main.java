package ru.alternation.Trash.Others.Trash.Test05;

import java.util.*;

public class Main {



    private final static Set<String> NAMES = new HashSet<String>(){

        {
            add("fgh1");
            add("fgh2");
            add("fgh3");
        }

    };
    private final static String[] s =  {"ftgh","fhfghf"};





    private final static Set<String> NAMES2 = new HashSet<String>(Arrays.asList( "546", "5r46")) ;
    private final static Set<Integer> INT = new HashSet<Integer>(Arrays.asList(16, 19, 23 , 29 , 31, 37)) ;

    public static void main(String[] args) {


        NAMES2.add("fgh4");
        NAMES2.add("fgh344");
        System.out.println(INT);


        int[] smallPrimes = { 2, 3, 5, 7, 11, 13};

        smallPrimes = new int[]{ 17, 19, 23, 29, 31, 37 };
        System.out.println(Arrays.asList(smallPrimes));
        smallPrimes = new int [] { 16, 19, 23 , 29 , 31, 37};
        System.out.println(Arrays.asList(16, 19, 23 , 29 , 31, 37));
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(16, 19, 23 , 29 , 31, 37));
        List<Integer> list2 = Arrays.asList(16, 19, 23 , 29 , 31, 37);
        System.out.println(list);

    }


}