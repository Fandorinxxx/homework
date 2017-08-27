package ru.alternation.stepik.adaptive_java.step08;


import java.util.Scanner;

/**

 # 1.8 Next even number

 Given a natural number N, not greater than 10000. Output the even number following this N.

 Sample Input 1:
 7
 Sample Output 1:
 8

 Sample Input 2:
 8
 Sample Output 2:
 10

 */
class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int result = scanner.nextInt();
        result = (result & 1) == 0 ? result + 2 : result + 1; // result % 2 == 0
        System.out.println(result);
    }
}
