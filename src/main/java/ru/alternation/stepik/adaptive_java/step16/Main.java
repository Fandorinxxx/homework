package ru.alternation.stepik.adaptive_java.step16;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.Scanner;

/**
 # 1.16 Calculator

 Write a simple calculator that reads the three input lines: the first number, the second number and the operation,
 after which it applies the operation to the entered numbers ("first number" "operation" "second number") and outputs
 the result to the screen. Note that the numbers can be real.

 Supported operations: +, -, /, *, mod, pow, div; where
 mod — taking the residue,
 pow — exponentiation,
 div — integer division.

 If a user performs the division and the second number is 0, it is necessary to output the line "Division by 0!".

 Sample Input 1:
 5.0
 0.0
 mod
 Sample Output 1:
 Division by 0!


 Sample Input 2:
 -12.0
 -8.0
 *
 Sample Output 2:
 96.0


 Sample Input 3:
 5.0
 10.0
 /
 Sample Output 3:
 0.5

 */
class Main {
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        double first        = scanner.nextDouble();
        double second       = scanner.nextDouble();
        String operation    = scanner.next();

        //NumberFormat englishFormat = NumberFormat.getInstance(Locale.ENGLISH);
        //englishFormat.setParseIntegerOnly(false);
        //englishFormat.parse(operation);
        //System.out.println(englishFormat.parse(operation));

//        double first  = -67.5;
//        double second =   7.5;
////        int first  = -67;
////        int second =   5;
////        //  -14 -13 -13 and 3 -2 -2
//
//        System.out.println(Math.floorDiv((int) first, (int) second)); // -10
//        System.out.println((int) first / (int) second);               //  -9
//        System.out.println((int)(first / second));                    //  -9
//
//        System.out.println(Math.floorMod((int) first, (int) second)); //   3
//        System.out.println(((int) first) % ((int) second));           //  -4
//        System.out.println((int) (first % second));                   //   0




        switch (operation) {
            case "+":
//                System.out.println(first+second);
                break;
            case "-":
                System.out.println(first-second);
                break;
            case "/":
                if (second == 0) {
                    System.out.println("Division by 0!");
                    break;
                }
                System.out.println(first/second);
                break;
            case "*":
                System.out.println(first*second);
                break;
            case "mod":
                if (second == 0) {
                    System.out.println("Division by 0!");
                    break;
                }
                System.out.println(Math.floorMod((int) first, (int)second));
                break;
            case "pow":
                System.out.println(Math.pow(first,second));
                break;
            case "div":
                if (second == 0) {
                    System.out.println("Division by 0!");
                    break;
                }
                System.out.println(Math.floorDiv((int) first, (int) second));
                break;
        }



    }

}
