package ru.alternation.Simple.section5.stage3.step13;

import java.util.Locale;
import java.util.Scanner;

/**
 Sample Input 1:
 1 2 3
 Sample Output 1:
 6.000000

 Sample Input 2:
 a1 b2 c3
 Sample Output 2:
 0.000000

 Sample Input 3:
 -1e3
 18 .111 11bbb
 Sample Output 3:
 -981.889000
  */

public class Test {
    public static void main(String[] args) {
        sumOfDouble("1 2 3");
        sumOfDouble("a1 b2 c3");
        sumOfDouble("-1e3\n" +
                "18 .111 11bbb");
        sumOfDouble("a1 2 3");

    }
    private static void sumOfDouble(String str){
        Scanner scanner = new Scanner(str).useLocale(Locale.forLanguageTag("en"));

        double data = 0.0;
        while (scanner.hasNext()){
            if (scanner.hasNextDouble()) {
                data += scanner.nextDouble();
            } else {
                scanner.next();
            }
        }
        System.out.printf(Locale.ENGLISH,"%.6f\n", data);
    }
}
