package ru.alternation.Simple.section3.stage5.step7;

import java.util.function.DoubleUnaryOperator;
import static java.lang.Math.sin;
import static java.lang.Math.cos;

/**
 *
 * Реализуйте метод, выполняющий численное интегрирование заданной функции на заданном интервале
 * по формуле левых прямоугольников.
 * <a href="ru.wikipedia.org/wiki/Метод_прямоугольников">Метод_прямоугольников</a>
 *
 https://ru.wikipedia.org/wiki/Метод_прямоугольников
 *
 * Функция задана объектом, реализующим интерфейс java.util.function.DoubleUnaryOperator.
 * Его метод applyAsDouble() принимает значение аргумента и возвращает значение функции в заданной точке.
 *
 * Интервал интегрирования задается его конечными точками a и b, причем a <= b.
 * Для получения достаточно точного результата используйте шаг сетки не больше 10^(−6).
 *
 * Пример. Вызов
 *
 * integrate(x -> 1, 0, 10)
 *
 * должен возвращать значение 10.
 *
 *
 * P.S. Если задача слишком легкая,
 * то дополнительно можете реализовать динамический выбор шага сетки по следующему алгоритму:
 *
 * Вычислить приближенное значение интеграла функции при начальном значении шага сетки (например, 1).
 * Вычислить приближенное значение интеграла функции при более мелком шаге сетки (например, уменьшить шаг сетки в два раза).
 * Если разность двух последовательных приближений интеграла функции достаточно мала,
 * то завершаем алгоритм и возвращаем текущее приближение в качестве результата.
 * Иначе возвращаемся к шагу 2.
 *
 */


public class Main {

    public static double integrate(DoubleUnaryOperator f, double a, double b) {

        double step = 1e-6;
        double result = 0;

        for (double i = a; i < b; i+=step) {
            result += f.applyAsDouble(i) * step;
        }

// пишут, так лучше. ибо может накопиться большая ошибка.
//        long i = 0;
//        for (double x = a; x < b; x = a + step * i++) {
//            result += step * f.applyAsDouble(x);
//        }
        return result;
    }


    public static double integrateWithDynamicStep(DoubleUnaryOperator f, double a, double b) {

        double step = 1.0; // можно, конечно, и только с этой переменной (без result, previousResult, difference)
        double result;
        double previousResult;
        double difference;

        do{
            previousResult = integrateWithStep(f, a, b, step);
            result = integrateWithStep(f, a, b, step/=2);

            difference = Math.abs(result - previousResult);
        } while (difference > 1e-5);

        return result;
    }
    private static double integrateWithStep(DoubleUnaryOperator f, double a, double b, double step)
    {
        double result = 0.0;

        for (double i = a; i < b; i+=step) {
            result += f.applyAsDouble(i) * step;
        }
        return result;
    }




    public static void main(String[] args) {

        System.out.println(integrate(x -> 1, 0, 10));

//        System.out.println(integrate(new DoubleUnaryOperator() {
//            @Override
//            public double applyAsDouble(double operand) {
//                return 1;
//            }
//        }, 0, 10));

        DoubleUnaryOperator func1 = x -> x*2;
        System.out.println(integrate(func1, 0, 10));
        System.out.println(integrate(func1.andThen(x -> 2), 0, 10));
        //func1.andThen(x -> 2).applyAsDouble(3.5);


        System.out.println(integrate(x -> sin(x)*sin(x) + cos(x)*cos(x), -1, 10));
        //System.out.println(integrateWithDynamicStep(x -> 1, 0, 10));
        //System.out.println(integrateWithDynamicStep(Math::sin, 0, 1));

        integrate(x ->Math.cos(x), 0, 1);
        integrate(Math::sin, 0, 10);

    }

}
