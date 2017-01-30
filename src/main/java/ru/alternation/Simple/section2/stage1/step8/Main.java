package ru.alternation.Simple.section2.stage1.step8;

import java.util.GregorianCalendar;

/**
 В Григорианском календаре год является високосным в двух случаях: либо он кратен 4, но при этом не кратен 100, либо кратен 400.

 Реализуйте метод, вычисляющий количество високосных лет с начала нашей эры (первого года) до заданного года включительно.
 На самом деле Григорианский календарь был введен значительно позже, но здесь для упрощения мы распространяем его действие на всю нашу эру.

 Ввод-вывод обеспечивает проверяющая система. Вам надо только проанализировать переданное в метод значение и вернуть результат.
 В программу всегда подается положительный номер года.
 Предполагается решение без циклов. Вам надо придумать и записать несложную формулу, использующую только арифметические операторы.
 */

public class Main {

//    private static boolean isLeapYear(int year){
//        return (year%4 == 0) &&  (year %400 == 0 || (year %100 != 0) );
//    }

    public static void main(String[] args) {
//        System.out.println(isLeapYear(2012));
//        System.out.println(isLeapYear(2014));
//        System.out.println(isLeapYear(2000));



//// https://www.tutorialspoint.com/java/util/gregoriancalendar_isleapyear.htm
//
//        // create a new calendar
//        GregorianCalendar cal =
//                (GregorianCalendar) GregorianCalendar.getInstance();
//
//        // print the current date and time
//        System.out.println("" + cal.getTime());
//
//        // check if it is a leap year
//        boolean isLeapYear = cal.isLeapYear(cal.get(GregorianCalendar.YEAR));
//        System.out.println("Is leap year: " + isLeapYear);
//
//        int year = 2013;
//        // check if 2013 is a leap year
//        isLeapYear = cal.isLeapYear(year);
//        System.out.println("Is "+ year + " leap year: " + isLeapYear);


    }

// The answer:
    public static int leapYearCount(int year) {
        return year/4 - year/100 + year/400;
    }
}
