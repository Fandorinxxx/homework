package ru.alternation.stepik.adaptive_java.steps20_39.step25;

import java.util.Scanner;

/**
 # 1.25 Positive number

 Write a program that reads the number and prints YES if it is positive. Otherwise, the program should print NO.

 Sample Input:
 7

 Sample Output:
 YES

 */

public class Main {
    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();

        System.out.println(input > 0 ? "YES " : "NO");

    }

}
