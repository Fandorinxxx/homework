package ru.alternation.Simple.section6.stage3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.DoubleUnaryOperator;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.ToIntFunction;

/**
 * Consumer - потребитель, он получает на вход значение, что-то с ним делает, но ничего не возвращает.
 * Predicate - утверждение, получает на вход значение и возвращает истину/ложь в зависимости от значения.
 * Function - функция, думаю понятно как работает.
 * Supplier - поставщик, предоставляет значения, на вход ничего не принимает.
 * Operator - оператор, как функция, только принимает и возвращает значения одного типа.
 *
 * https://paste.ubuntu.com/23353841/
 */

public class Lecture {
    public static void main(String[] args) {

        ToIntFunction<String> intParser = Integer::parseInt;
        Consumer<Object> printer = System.out::println;
        Function<Object, String> objectToString = Object::toString;
        IntFunction<String[]> arrayAllocator = String[]::new;


        //Consumer<Object> printer = System.out::println;
        List<Object> objects = new ArrayList<>();
        Consumer<Object> collector = objects::add;
        Consumer<Object> combinedConsumer = printer.andThen(collector);

        DoubleUnaryOperator square = x -> x * x;
        DoubleUnaryOperator sin = Math::sin;
        DoubleUnaryOperator complexFunction1 = sin.andThen(square);
        DoubleUnaryOperator complexFunction2 = sin.compose(square);

        Comparator<Double> absoluteValueComparator0 = (a, b) -> Double.compare(Math.abs(a), Math.abs(b));
        Comparator<Double> absoluteValueComparator = Comparator.comparingDouble(Math::abs);
        Comparator<Double> absoluteValueComparator2 = Comparator.comparing(Math::abs, Double::compare);
    }
}
