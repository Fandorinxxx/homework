package ru.alternation.stepik.alt;

import java.util.Scanner;

/**
 * Input/output in code challenges - 1
 * <p>
 * There are several ways to read values from the standard input. The first way is to use java.util.Scanner.
 * <p>
 * Let's read two integer numbers from the standard input, sum up them and write the result in the standard output.
 * <p>
 * There are no problems here.
 * <p>
 * As a test, you can try to submit this code in the section below.
 * <p>
 * Sample Input 1:
 * 6 1
 * Sample Output 1:
 * 7
 * Sample Input 2:
 * 8 0
 * Sample Output 2:
 * 8
 */

public class Main001 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt(); // it reads an integer value from the standard input
        int b = scanner.nextInt(); // it reads another integer value from the standard input

        System.out.println(a + b); // it writes the result of a + b in the standard output
    }
}