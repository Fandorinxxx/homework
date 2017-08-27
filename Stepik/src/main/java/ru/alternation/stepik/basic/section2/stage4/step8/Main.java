package ru.alternation.stepik.basic.section2.stage4.step8;

import java.math.BigInteger;

/**
 Реализуйте метод, вычисляющий факториал заданного натурального числа.

 Факториал NN вычисляется как 1⋅2⋅...⋅N1⋅2⋅...⋅N.

 Поскольку это очень быстро растущая функция, то даже для небольших NN вместимости типов int и long очень скоро не хватит.
 Поэтому будем использовать BigInteger.

 Воспользуйтесь предоставленным шаблоном. Декларацию класса, метод main и обработку ввода-вывода добавит проверяющая система.

 Sample Input 1:
 1
 Sample Output 1:
 1

 Sample Input 2:
 3
 Sample Output 2:
 6

 */

    // https://pr0java.blogspot.ru/2015/05/biginteger-bigdecimal_70.html
    // http://rabotaet.livejournal.com/5006.html
    // https://habrahabr.ru/post/113128/

public class Main {

    /**
     * Calculates factorial of given <code>value</code>.
     *
     * @param value positive number
     * @return factorial of <code>value</code>
     */
    public static BigInteger factorial(int value) {

//        BigInteger bigInteger =  BigInteger.ONE;
//        for (int i = 1; i <= value; i++) {
//            bigInteger = bigInteger.multiply(new BigInteger(Integer.toString(i)));
//        }
//        return bigInteger;


        return value == 0 ? BigInteger.ONE :  BigInteger.valueOf(value).multiply(factorial(--value));
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(factorial(i));
        }
    }
}
