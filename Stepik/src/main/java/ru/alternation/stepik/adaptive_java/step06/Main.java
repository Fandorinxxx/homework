package ru.alternation.stepik.adaptive_java.step06;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 # Digital watches

 Digital watches display time in the h:mm:ss format (from 0:00:00 to 23:59:59), i.e. first goes the number of hours,
 then goes the two-digit number of minutes, followed by the two-digit number of seconds. If necessary, number of minutes
 and seconds are filled by zeroes to a two-digit number.

 N seconds passed from the beginning of the day. Output what the watches will display.

 Input data format:
    Given the natural number N on input, not exceeding 107107 (10000000).

 Sample Input 1:
 3602
 Sample Output 1:
 1:00:02

 Sample Input 2:
 129700
 Sample Output 2:
 12:01:40

 */
class Main {
    public static void main(String[] args) {


        int inSec = new Scanner(System.in).nextInt();
        System.out.println(LocalTime.MIN.plusSeconds(inSec).format(DateTimeFormatter.ofPattern("H:mm:ss")));


        //==============================================================================================================
        // так, конечно, проще

        int sec = new Scanner(System.in).nextInt();
        System.out.format("%d:%02d:%02d", sec / 3600 % 24, sec / 60 % 60, sec % 60);

        //==============================================================================================================



        Scanner scanner = new Scanner(System.in);
        System.out.println(getDigitTime(scanner.nextInt()));

        //System.out.println(getDigitTime(3602));
        //System.out.println(getDigitTime(129700));
    }

    private static String getHours(int all_seconds) {
        int hours = (all_seconds / (60 * 60)) % 24;
        return Integer.toString(hours) + ":";
    }

    private static String getMinutes(int all_seconds) {

        int result = (all_seconds / 60) % 60;
        if (result / 10 == 0) {
            return "0" + result + ":";
        }
        return result + ":";
    }

    private static String getSeconds(int all_seconds) {
        int result = all_seconds % 60;
        if (result / 10 == 0) {
            return "0" + result;
        }
        return Integer.toString(result);
    }

    public static String getDigitTime(int seconds) {
        return getHours(seconds) + getMinutes(seconds) + getSeconds(seconds);
    }

}
