package ru.alternation.stepik.adaptive_java.step10;

import java.util.Scanner;

/**
 # The number of tens

 Given a non-negative integer N (0 ≤ N ≤ 1000000), find the number of tens in it (i.e. next to last digit of the number).
 If there is no next to last digit, you can consider that the number of tens equals to zero.

 Sample Input:
 173
 Sample Output:
 7

 */
class Main {
    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);
        System.out.println(scanner.nextInt() % 100 / 10);
    }
}
