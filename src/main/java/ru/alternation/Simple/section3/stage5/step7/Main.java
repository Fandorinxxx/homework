package ru.alternation.Simple.section3.stage5.step7;

import java.util.function.DoubleUnaryOperator;

/**
 *
 * Реализуйте метод, выполняющий численное интегрирование заданной функции на заданном интервале
 * по формуле левых прямоугольников.
 * https://ru.wikipedia.org/wiki/Метод_прямоугольников
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
        return f.applyAsDouble(a);
    }



    public static void main(String[] args) {



    }


}
