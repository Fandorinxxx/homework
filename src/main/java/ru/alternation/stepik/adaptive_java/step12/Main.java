package ru.alternation.stepik.adaptive_java.step12;

import java.util.Scanner;

/**
 # 1.12 Reversing

 Write a program that reads a three digit number, calculates the new number by reversing its digits,
 and outputs a new number.

 Sample Input:
 682
 Sample Output:
 286

 */
class Main {
    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);
        //int value = scanner.nextInt();
        //String s = Integer.toString(value);

        StringBuilder builder = new StringBuilder(scanner.nextLine());
        System.out.println(builder.reverse().toString());

        // или так
        //int n = scanner.nextInt();
        //System.out.println(n / 100 + ((n / 10) % 10) * 10 + (n % 10) * 100);



//        byte[] r = new byte[3];
//        System.in.read(r); // throws IOException
//        System.out.println("" + (char) r[2] + (char) r[1] + (char) r[0]);
    }

}
