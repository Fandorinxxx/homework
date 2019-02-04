package ru.alternation.examples.yandex.c;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.function.IntPredicate;


/**

 Несмотря, что в этом решение не создаются String'и, минимум динамического выделения памяти, – работает оно хуже Main.
 Но тест может пройти (или нет)

 */


public class Another {
    public static void main(String... args) throws IOException {

        IntPredicate isNew = new IntPredicate() {
            private long previous = Long.MIN_VALUE; // первое число может быть равно Integer.MIN_VALUE
            private int count = 0;

            @Override
            public boolean test(int current) {

                count++;
                if (count == 15000) {
                    System.gc();
                    count = 0;
                }

                if (current == previous) {
                    return false;
                } else {
                    previous = current;
                    return true;
                }
            }
        };

        InputStream reader = new BufferedInputStream(new FileInputStream("./input.txt"));
//        InputStream reader = new FileInputStream("./input.txt");

        int count = readInt(reader);

        for (int i = 0; i < count; i++) {
            int number = readInt(reader);
            if (isNew.test(number)) {
                System.out.println(number);
            }
        }

    }


    private static final int[] digitArray = new int[String.valueOf(Integer.MAX_VALUE).length()]; //  Integer.MAX_VALUE.length == 10 // 2_147_483_647 == 2147483647

    private static int readInt(InputStream reader) throws IOException {

//        int[] digitArray = new int[String.valueOf((long)Integer.MAX_VALUE*2).length()]; //  Integer.MAX_VALUE.length == 10 // 2_147_483_647 == 2147483647

        int data;
        int order = 0;
        boolean isNegative = false;

        while ( (data = reader.read()) != -1) {

            if (isMinusSymbol(data)) {
                isNegative = true;
                continue;
            }

            if (!isDigitSymbol(data)) {
                break;
            }

            digitArray[order] = charToInt(data);
            order++;
        }

        return getNumFromArray(digitArray, order) * (isNegative ? -1 : 1);
    }

    private static int getNumFromArray(int[] digitArray, int order) {
        int result = 0;

        for (int i = 0; i < order; i++) {
            result = result + digitArray[i] * pow(10, order - i -1);
        }

        return result;
    }

    private static int pow(int num, int power) {
        if (power == 0) {
            return 1;
        }

        int result = 1;
        for (int i = 0; i < power; i++) {
            result = result * num;
        }

        return result;
    }

    private static int charToInt(int data) {
        return data - zeroCode;
    }

    private static final int tCode = (int)'\t';   // 9
    private static final int nCode = (int)'\n';   // 10
    private static final int zeroCode = (int)'0'; // 48
    private static final int nineCode = (int)'9'; // 57
    private static final int dashCode = (int)'-';

    private static boolean isMinusSymbol(int data) {
        return data == dashCode;
    }

    private static boolean isDigitSymbol(int data) {

        if (data == tCode || data == nCode) {
            return false;
        }

        if (data < zeroCode || data > nineCode) {
            return false;
        }

        return true;
    }

}
