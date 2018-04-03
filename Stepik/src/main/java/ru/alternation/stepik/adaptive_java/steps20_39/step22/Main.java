package ru.alternation.stepik.adaptive_java.steps20_39.step22;

import java.util.Scanner;

/**
 # 1.22 Shape

 Write a program, which reads the number of the shape (1 – square, 2 – circle, 3 – triangle, 4 – rhombus) and prints
 the text "You have chosen a square" (or circle, or triangle, or rhombus, depending on the number). If it is a number,
 which doesn't correspond to any of the listed shapes, the program should output: "There is no such shape!".

 Note: output text should exactly match the sample! Including letters case and location of spaces.


 Sample Input:
 1

 Sample Output:
 You have chosen a square

 */

public class Main {
    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);
        String[] strings = new String[] {"square", "circle", "triangle", "rhombus"};

        int num = scanner.nextInt();

        if (num >= 1 && num <= 4) {
            System.out.println("You have chosen a " + strings[num - 1]);
        } else {
            System.out.println("There is no such shape!");
        }
    }
}
