package ru.alternation.stepik.adaptive_java.step19;

import java.util.Scanner;

/**

 # 1.19 Interval

 Given an integer as input.
 Output True if its value is within the interval (-15,12]∪(14,17)∪[19,+∞), and False otherwise (case sensitive).

 Please note the different brackets, which are used to specify intervals.
 The problem uses semi-open and open intervals. You can read more about it on the Wikipedia.
 https://en.wikipedia.org/wiki/Interval_(mathematics)#Including_or_excluding_endpoints


 Sample Input 1:
 20
 Sample Output 1:
 True

 Sample Input 2:
 -20
 Sample Output 2:
 False

 */

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input       = scanner.nextInt();

        boolean expression = (input > -15 && input <= 12) || (input > 14 && input < 17) || (input >= 19);

        System.out.println(expression ? "True" : "False");
    }
}
