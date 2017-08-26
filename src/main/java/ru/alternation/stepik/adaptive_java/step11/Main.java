package ru.alternation.stepik.adaptive_java.step11;

import java.io.IOException;
import java.util.Scanner;

/**
 # 1.11 First digit of the two-digit number
 First digit of the two-digit number

 Given a two-digit number. Output its first digit (i.e. the number of tens).

 Sample Input:
 42
 Sample Output:
 4

 */
class Main {
    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);
        int value = scanner.nextInt();

        System.out.println(value/10);

//============================================================
        //System.out.print((char)System.in.read()); // throws IOException

    }

}
