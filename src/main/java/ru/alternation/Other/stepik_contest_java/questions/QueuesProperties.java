package ru.alternation.Other.stepik_contest_java.questions;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.Queue;

/**
 4.19 Queues. Properties

 Select true characteristics of queues.


 Implement the principle of "FIFO" (first in, first out)+
 Elements can be accessed by index
 Can store only numbers
 Store key-value pairs
 Can store only unique values
 Elements can be accessed by key
 Can be bypassed in a loop+
 Implement the principle of "LIFO" (last in, first out)
 Can be a replacement for arrays
 Can store only strings

 @see java.util.Queue
 */
public class QueuesProperties{
    public static void main(String[] args) {
        Queue<String> stringQueue = new ArrayDeque<>();
        stringQueue.add("1_");
        stringQueue.add("2_");
        stringQueue.add("3_");
        stringQueue.add("4_");

        stringQueue.forEach(System.out::println);
        System.out.println();


        Deque<String> stringDeque = new ArrayDeque<>();
        stringDeque.add("1="); // addLast()
        stringDeque.add("2=");
        stringDeque.push("3="); // addFirst()

        stringDeque.forEach(System.out::println);
        System.out.println();


        Iterator<String> iterator = stringDeque.descendingIterator();
        iterator.forEachRemaining(System.out::println);
//        while (iterator.hasNext()){
//            System.out.println(iterator.next());
//        }



    }
}

