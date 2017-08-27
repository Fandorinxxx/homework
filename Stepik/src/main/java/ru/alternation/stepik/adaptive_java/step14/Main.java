package ru.alternation.stepik.adaptive_java.step14;

import java.util.Scanner;

/**
 # 1.14 Chocolate

 A chocolate bar has a shape of rectangle, divided into NxM segments. You can break down this chocolate bar into
 two parts by a single straight line (only once). Find whether you can break off exactly K segments from the chocolate.
 Each segment is 1x1.


 Input data format:
 The program gets an input of three integers: N, M, K

 Output data format:
 The program must output one of the two words: YES or NO.

 Sample Input 1:
 4
 2
 6
 Sample Output 1:
 YES

 Sample Input 2:
 2
 10
 7
 Sample Output 2:
 NO

 */
class Main {
    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int K = scanner.nextInt();

        if( K % N == 0 && K >= N && M >= K/N) {
            System.out.println("YES");
        } else if( K % M == 0 && K >= M && N >= K/M) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

        // or
        System.out.println(K <= N * M && (K % N == 0 || K % M == 0) ? "YES" : "NO");
    }

}
