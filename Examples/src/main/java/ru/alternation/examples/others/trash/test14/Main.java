package ru.alternation.examples.others.trash.test14;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Number[] numbers = new Integer[10];

        numbers[0] = new Integer("0");
        //numbers[1] = new BigDecimal(""); // java.lang.NumberFormatException
        numbers[1] = new BigDecimal("0"); // java.lang.ArrayStoreException
    }
}
