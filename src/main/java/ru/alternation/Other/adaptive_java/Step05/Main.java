package ru.alternation.Other.adaptive_java.Step05;

import java.util.Scanner;

/**
    Difference of times

 Given the values of the two moments in time in the same day: hours, minutes and seconds for each of the time moments.
 It is known that the second moment in time happened not earlier than the first one.
 Find how many seconds passed between these two moments of time.

 Input data format:
 The program gets the input of the three integers: hours, minutes, seconds, defining the first moment of time
 and three integers that define the second moment time.


 Output data format:
 Output the number of seconds between these two moments of time.
 _________________________________________
 Sample Input 1:
 1
 1
 1
 2
 2
 2

 Sample Output 1:
 3661
 _________________________________________

 Sample Input 2:
 1
 2
 30
 1
 3
 20

 Sample Output 2:
 50

 */

// import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Moment moment1 = new Moment(sc);
        Moment moment2 = new Moment(sc);


        System.out.println(moment2.passed(moment1));
    }
    static class Moment {
        private int hours;
        private int minutes;
        private int seconds;
        Moment(Scanner sc){
            hours = sc.nextInt();
            minutes = sc.nextInt();
            seconds = sc.nextInt();
        }
        int getTotalSeconds(){
            return seconds + minutes*60 + hours*60*60;
        }

        int passed(Moment before){
            return getTotalSeconds() - before.getTotalSeconds();
        }

    }
}