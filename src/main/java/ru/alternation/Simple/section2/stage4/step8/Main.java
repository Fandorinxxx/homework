package ru.alternation.Simple.section2.stage4.step8;

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

public class Main {

    /**
     * Calculates factorial of given <code>value</code>.
     *
     * @param value positive number
     * @return factorial of <code>value</code>
     */
    public static BigInteger factorial(int value) {

        BigInteger bigInteger = new BigInteger("1");

        for (int i = 1; i <= value; i++) {
            bigInteger = bigInteger.multiply(new BigInteger(Integer.toString(i)));
        }

        return bigInteger;
    }

    public static void main(String[] args) {
        System.out.println(factorial(0));
        System.out.println(factorial(1));
        System.out.println(factorial(2));
        System.out.println(factorial(3));
        System.out.println(factorial(4));
        System.out.println(factorial(5));
    }
}
