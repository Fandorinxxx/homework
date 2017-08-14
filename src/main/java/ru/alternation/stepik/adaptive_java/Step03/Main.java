package ru.alternation.stepik.adaptive_java.Step03;

import java.util.Scanner;

/**
 Snail

 Snail creeps up the vertical pole of height H feets.
 Per day it goes A feets up, and per night it goes B feets down.
 In which day the snail will reach the top of the pole?

 Input data format

 On the input the program receives non-negative integers H, A, B, where H > B and A > B.
 Every integer does not exceed 100.
___________________________________________
 Sample Input:
 10
 3
 2

 Sample Output:
 8

 */
//import java.util.Scanner;
class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int height = sc.nextInt();
        int up = sc.nextInt();
        int down = sc.nextInt();

        int current = up;
        int days = 1;

        while (current < height){
            current-=down;
            current+=up;
            days++;
        }

        System.out.println(days);
    }
}