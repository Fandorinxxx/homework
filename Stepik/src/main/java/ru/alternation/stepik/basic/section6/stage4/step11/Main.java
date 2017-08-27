package ru.alternation.stepik.basic.section6.stage4.step11;

import java.util.stream.IntStream;


/**
 Напишите метод, возвращающий стрим псевдослучайных целых чисел. Алгоритм генерации чисел следующий:

 1. Берется какое-то начальное неотрицательное число (оно будет передаваться в ваш метод проверяющей системой).
 2. Первый элемент последовательности устанавливается равным этому числу.
 3. Следующие элементы вычисляются по рекуррентной формуле "R(n+1) = mid((R^2)(n))", где mid — это функция,
 выделяющая второй, третий и четвертый разряд переданного числа. Например, mid(123456)=345.

 Алгоритм, конечно, дурацкий и не выдерживающий никакой критики, но для практики работы со стримами сойдет :)

 Пример:

 pseudoRandomStream(13) должен вернуть стрим, состоящий из следующих чисел:

 13, 16, 25, 62, 384, 745, 502, 200, 0, ... (дальше бесконечное количество нулей)
 */

public class Main {
    public static IntStream pseudoRandomStream(int seed) {
        return IntStream.iterate(seed, n -> (n * n / 10) % 1000);
    }


    public static void main(String[] args) {
        pseudoRandomStream(13).limit(15).forEach(System.out::println);
    }
}

// Плохая реализация mid()
//    static int mid(int value, int length, int offer){
//        int result = 0;
//        if(value/pow10(offer) != 0) {
//            for (int i = offer; i < length + offer; i++) {
//                int step1 = value % pow10(i + 1);
//                int step2 = pow10(i);
//                result += step1 / step2 * step2;
//            }
//        }
//        return result/pow10(offer);
//    }
//    static int pow10(int power){
//        int i = 1;
//        for (int j = 0; j < power; j++) {
//            i = i * 10;
//        }
//        return i;
//    }
//}
