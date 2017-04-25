package ru.alternation.Other.adaptive_java.Step04;

import java.util.Scanner;

/**
 * 1.4 MKAD

 MKAD

 The length of the Moscow Ring Road (MKAD) is 109 kilometers.
 Biker Vasya starts from the zero kilometer of MKAD and drives with a speed of V kilometers per hour.
 On which mark will he stop after T hours?

 Input data format

 The program gets integers V and T as input. If V > 0, then Vasya moves in a positive direction along MKAD,
 if the value of V < 0 – in the negative direction. 0 ≤ T ≤ 1000, -1000 ≤ V ≤ 1000.


 Output data format

 The program should output an integer from 0 to 108 - the mark on which Vasya stops.

 Sample Input 1:
 60
 2
 Sample Output 1:
 11

 Sample Input 2:
 -1
 1
 Sample Output 2:
 108

 */
// import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int speed = sc.nextInt();
        int hours = sc.nextInt();
        int distance = speed * hours;
        int length = 109;

        int mark = distance % length; // may be negative
        System.err.println(mark);

        mark = (mark + length) % length;
        System.out.println(mark);
    }
}

// Step by step
/*
    int mark = distance % length; // may be negative [1]
    mark = (mark + length);       // if [1] is negative
    mark = mark % length;         // if [1] is positive
*/

