package ru.alternation.stepik.adaptive_java.step18;

import java.util.Arrays;
import java.util.Scanner;

/**

 # 1.18 Triangle

 Given three natural numbers A, B, C. Define if the triangle with such sides exists.
 If the triangle exists - output the YES string, otherwise - output NO.
 Triangle is a three points that are not located on a single straight line.

 Sample Input:
 3
 4
 5
 Sample Output:
 YES

 */

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

//        int A           = scanner.nextInt();
//        int B           = scanner.nextInt();
//        int C           = scanner.nextInt();

//        if (A + B > C && C >= A && C >= B) {
//            System.out.println("YES");
//        } else if (A + C > B && B >= A && B >= C) {
//            System.out.println("YES");
//        } else if (B + C > A && A >= C && A >= B) {
//            System.out.println("YES");
//        } else {
//            System.out.println("NO");
//        }


        // ---
//        System.out.println(A + B > C && B + C > A && C + A > B ? "YES" : "NO");


        // ---
        int[] a = new int[3];
        for (int i = 0; i < 3; i++) {
            a[i] = scanner.nextInt();
        }

        Arrays.sort(a);
        System.out.println(a[0] + a[1] > a[2] ? "YES" : "NO");
    }
}
