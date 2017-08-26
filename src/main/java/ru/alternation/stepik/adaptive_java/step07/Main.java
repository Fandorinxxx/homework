package ru.alternation.stepik.adaptive_java.step07;


import java.util.Scanner;
import java.util.stream.IntStream;

/**

 # 1.7 Desks

 Some school have decided to create three new math groups and equip classrooms for them with the new desks.
 Only two students may sit at any desk. The number of students in each of the three groups is known.
 Output the smallest amount of desks, which will need to be purchased. Each new group sits in its own classroom.

 Input data format
 The program receives the input of the three non-negative integers: the number of students in each of the three classes
 (the numbers do not exceed 1000).

 Sample Input 1:
 20
 21
 22
 Sample Output 1:
 32

 Sample Input 2:
 16
 18
 20
 Sample Output 2:
 27

 */
class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int result = IntStream.range(0, 3)
                .map(students -> scanner.nextInt())
                //.map(students -> students % 2 == 1 ? students/2 + 1 : students/2)
//                .map(students -> students / 2 + students % 2)
                .map(students -> (int) Math.ceil(students / 2.0))
                .sum();

        System.out.println(result);
    }
}
