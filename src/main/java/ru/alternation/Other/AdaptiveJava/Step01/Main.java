package ru.alternation.Other.AdaptiveJava.Step01;

import java.util.Scanner;

/**
 * https://stepik.org/course/Adaptive-Java-2403/
 *
 *
 *                         1.1 Squirrels and nuts
 *
 Squirrels and nuts - 1

 N squirrels found K nuts and decided to divide them equally. Determine how many nuts each squirrel will get.

 Input data format:
 There are two positive numbers N and K, each of them is not greater than 10000.


 Sample Input:
 3
 14
 Sample Output:
 4
 */

//import java.util.Scanner;
class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int squirrels = sc.nextInt();
        int nuts = sc.nextInt();

        System.out.println(nuts/squirrels);
    }
}
