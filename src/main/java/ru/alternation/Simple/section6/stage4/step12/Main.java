package ru.alternation.Simple.section6.stage4.step12;


import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 Напишите метод, находящий в стриме минимальный и максимальный элементы в соответствии порядком, заданным Comparator'ом.

 Найденные минимальный и максимальный элементы передайте в minMaxConsumer следующим образом:
    minMaxConsumer.accept(min, max);

 Если стрим не содержит элементов, то вызовите
    minMaxConsumer.accept(null, null);

 */
public class Main {

    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {

        List<T> objects = stream.collect(Collectors.toList());
        objects.sort(order);

        if (objects.size() > 0) {
            minMaxConsumer.accept(objects.get(0), objects.get(objects.size()-1));
        } else {
            minMaxConsumer.accept(null, null);
        }
    }

}
