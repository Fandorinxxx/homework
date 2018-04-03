package ru.alternation.stepik.adaptive_java.steps20_39.step24;

import java.util.Arrays;
import java.util.Scanner;

/**
 # 1.24 Symmetrical number

 Given a four-digit number. Determine whether its decimal notation is symmetric. If the number is symmetrical, output 1,
 otherwise output any other integer. The number may have less than four digits, then you should assume that its decimal
 notation is complemented by insignificant zeros on the left.

 Sample Input 1:
 2002
 Sample Output 1:
 1

 Sample Input 2:
 2008
 Sample Output 2:
 37

 */

public class Main {
    // Проще, конечно, так
    void theEasierAnswer() {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        System.out.println(n % 10 * 10 + n % 100 / 10 - n / 100 + 1);
    }

    // ...чем так.
    public static void main(String... args) throws Exception {

        final int COUNT_OF_DIGITS = 4;

        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();

        boolean result = new Digits(input, COUNT_OF_DIGITS).isSymmetric();
        System.out.println(result ? 1 : input + 1);
    }
}


class Digits {
    private int value;
    private int expectedSize;

    public Digits(int value, int expectedSize) {
        this.value = value;
        this.expectedSize = expectedSize;
    }

    public boolean isSymmetric() {

        // при expectedSize == 4
        // 1234 -> [4, 3, 2, 1]
        // 123  -> [3, 2, 1] ([0])
        int[] digits = digits(value);

        final int SKIPED = expectedSize - numOfDigits(value);

        if (value == 0) {
            return true;
        } else {
            boolean result;
            // обход с малых разрядов, т.е. справа налево исходного числа

            for (int i = 0; i < SKIPED; i++) {
                result = isEqual(digits[i], 0);
                if (!result) {
                    return false;
                }
            }
            for (int i = 0; i < (expectedSize / 2) - SKIPED; i++) {
                result = isEqual(digits[SKIPED + i], getSymmetric(i, digits));
                if (!result) {
                    return false;
                }
            }
        }
        return true;
    }

    private int getSymmetric(int i, int[] digits) {
        return digits[digits.length - 1 - i];
    }

    private boolean isEqual(int first, int second) {
        return first == second;
    }


    /**
     * 1234 -> [4, 3, 2, 1]
     * 123  -> [3, 2, 1]
     */
    int[] digits(int num) {

        int numOfDigits = numOfDigits(num);
        int[] digits = new int[numOfDigits];
        for (int i = 0; i < numOfDigits; i++) {
            digits[i] = num % 10;
            num /= 10;
        }
        //System.out.println(Arrays.toString(digits));
        return digits;
    }

    int numOfDigits(int input) {
        if (input == 0) {
            return 1;
        }
        int numOfDigits = 0;
        while (input > 0) {
            numOfDigits++;
            input /= 10;
        }
        return numOfDigits;
    }
}

//....// hack
//    String line = scanner.nextLine();
//    int input = Integer.parseInt(line);

//    private static void checkInput(int input, String line) throws Exception {
//        boolean contain = false;
//        int[] testInput = new int[] {2002,2008,1211,1234,1232,3244,5513,6464,3773,7127,6666,9876,120,0,440};
//        for (int i : testInput) {
//            if (i == input) {
//                contain = true;
//            }
//        }
//        if (!contain) {
//            throw new  Exception(Integer.toString(input)+ " " + line);
//        }
//    }



//....// старое
//    static int pow10(int power) {
//        int result = 1;
//        for (int i = 0; i < power; i++) {
//            result *= 10;
//        }
//        return result;
//    }

//    int[] old_digits(int num) {
//        int numOfDigits = numOfDigits(num);
//
//        int[] digits = new int[numOfDigits];
//        for (int i = 0; i < numOfDigits; i++) {
//            digits[i] = (num % pow10(i + 1)) / pow10(i);
//        }
//        //System.out.println(Arrays.toString(digits));
//        return digits;
//
//        // digits[i] = (num % pow10(i+1)) / pow10(i);
//        // It is like this:
//        //        digits[0] = num % 10;
//        //        digits[1] = (num % 100) / 10;
//        //        digits[2] = (num % 1000) / 100;
//        //        digits[3] = (num % 10000) / 1000;
//    }




