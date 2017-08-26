package ru.alternation.stepik.adaptive_java.step13;

import java.math.BigInteger;
import java.util.Scanner;

/**
 # 1.13 Power

 Write a program, which reads two integers a and b (separated by a line break), and outputs the value of abab. The operator ** is used in Python for exponentiation.

 Sample Input:
 16
 64
 Sample Output:
 115792089237316195423570985008687907853269984665640564039457584007913129639936

 */
class Main {
    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);
        int base = scanner.nextInt();
        int exp = scanner.nextInt();

        System.out.println(BigInteger.valueOf(base).pow(exp));


//        BigInteger val1 = new BigInteger(Integer.toString(base));
//        //BigInteger val2 = new BigInteger(Integer.toString(exp));
//        System.out.println(val1.pow(exp));



    }

}
