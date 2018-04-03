package ru.alternation.stepik.adaptive_java.steps20_39.step23;

import java.util.Scanner;

/**
 # 1.23 Direction

 Write a program, which reads the number of direction (1 – up, 2 – down, 3 – left, 4 – right, 0 – stay) and outputs
 the text «move up» (or «move down», or «move left», or «move right», or «do not move» depending on the entered number).
 If it is a number that does not belong to any of the listed directions, the program should output: «error!»

 Note: the output text should exactly match the sample! Including letters case and location of spaces.

 Sample Input:
 1
 Sample Output:
 move up

 */

public class Main {

    enum Direction {
        STAY {
            @Override
            public String toString() {
                return "do not move";
            }},
        UP() {
            @Override
            public String toString() {
                return "move up";
            }
        },
        DOWN("down") {},
        LEFT("left"),
        RIGHT("right");

        private String name;

        Direction() {
        } // for STAY, UP
        Direction(String name) {
            this.name = name;
        } // for DOWN, LEFT, RIGHT

        @Override
        public String toString() {
            return "move " + name;
        }
    }

    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        Direction[] values = Direction.values();

        if (checkRange(num)) {
            System.out.println(values[num]); // It invoke Direction's toString()
        } else {
            System.out.println("error!");
        }
    }

    private static boolean checkRange(int i) {
        return i >=0 && i <=4;
    }
}
