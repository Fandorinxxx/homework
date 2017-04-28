package ru.alternation.Trash;


import java.util.ArrayList;
import java.util.List;

public class Test{


    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        for (Integer i : list){
            i+=2;
        }
        System.out.println(list);



    }


}