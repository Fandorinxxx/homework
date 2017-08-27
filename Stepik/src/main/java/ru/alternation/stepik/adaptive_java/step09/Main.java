package ru.alternation.stepik.adaptive_java.step09;

import java.io.IOException;
import java.util.Scanner;

/**
 # 1.9 The sum of digits of a three-digit number

 Given a three-digit integer (i.e. an integer from 100 to 999). Find the sum of its digits.

 Sample Input:
 476
 Sample Output:
 17

 */
class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int value = scanner.nextInt();
        int result = value%10 + (value/10)%10 + value/100;
        System.out.println(result);


        // or
        //System.out.print(System.in.read() + System.in.read() + System.in.read() - 3*'0');
    }
}
