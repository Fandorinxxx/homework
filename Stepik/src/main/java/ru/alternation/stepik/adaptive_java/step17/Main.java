package ru.alternation.stepik.adaptive_java.step17;

import java.util.Scanner;

/**

 # 1.17 Swimming pool

 Ian was swimming in the pool having size of N×M feets and got tired. At this moment he realized that he is at
 a distance of X feets from one of the long ledge (not necessarily from the nearest one) and Y feets from one of
 the short ledges. What is the minimum distance (in feets) Ian needs to swim in order to reach the swimming pool ledge?

 The program input contains numbers N, M, X, Y.


 Sample Input:
 23
 52
 8
 43

 Sample Output:
 8

 */

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N           = scanner.nextInt();
        int M           = scanner.nextInt();
        int X           = scanner.nextInt(); // distance from one of the long ledge
        int Y           = scanner.nextInt(); // distance from one of the short ledge

        int longLedge  = Math.max(N, M);
        int shortLedge = Math.min(N, M);

        int fromLL = shortLedge - X;  // distance from OTHER one of the long ledge
        int fromSL = longLedge  - Y;  // distance from OTHER one of the short ledge

        int minFromLL = Math.min(fromLL, X);
        int minFromSL = Math.min(fromSL, Y);


        int answer = Math.min(minFromLL, minFromSL);
        System.out.println(answer);


        // or // работает быстрее
        //System.out.println(Collections.min(Arrays.asList(X, Y, Math.min(N, M) - X, Math.max(N, M) - Y)));
    }
}
