package ru.alternation.stepik.adaptive_java.steps20_39.step21;

import java.util.Scanner;

/**
 # 1.21 Floor-space of the room

 Residents of the Malevia country often experiment with the plan of their rooms.
 Rooms can be triangular, rectangular and round. To quickly calculate the floorage it is required to write a program,
 which gets the type of the room shape and the relevant parameters as input
 - the program should output the area of the resulting room.

 The value of 3.14 is used instead of the number π in Malevia.

 Input format used by the Malevians:

    triangle
    a
    b
    c
 where a, b and c — lengths of the triangle sides.

    rectangle
    a
    b
 where a and b —lengths of the rectangle sides.

    circle
    r
 where r — circle radius.

 ____________________________________________________________________________________________________
 Sample Input 1:
 rectangle
 4
 10

 Sample Output 1:
 40.0

 ____________________________________________________________________________________________________
 Sample Input 2:
 circle
 5

 Sample Output 2:
 78.5

 ____________________________________________________________________________________________________
 Sample Input 3:
 triangle
 3
 4
 5

 Sample Output 3:
 6.0

 */

public class Main {
    public static void main(String... args) {

        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        double floorage = 0;

        switch (str) {
            case "circle": {
                double a = scanner.nextDouble();
                floorage = 3.14 * a * a;
                break;
            }
            case "rectangle": {
                double a = scanner.nextDouble();
                double b = scanner.nextDouble();
                floorage = a * b;
                break;
            }
            case "triangle": {
                double a = scanner.nextDouble();
                double b = scanner.nextDouble();
                double c = scanner.nextDouble();
                double p = (a + b + c) / 2;
                floorage = Math.sqrt(p * (p - a) * (p - b) * (p - c));
                break;
            }
        }
        System.out.println(floorage);
    }
}
