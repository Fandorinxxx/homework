package ru.alternation.stepik.basic.section6.stage4.step12;


import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
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



    /**
     У стрима есть методы min() и max(), но воспользоваться ими «в лоб» нельзя, т.к. оба являются терминальными операциями.
     Использовав одну из них, вторую уже вызвать нельзя — стрим бросит IllegalStateException. Некоторые обходили это ограничение,
     собирая элементы стрима в коллекцию, из которой можно было получить новый стрим столько раз, сколько нужно.
     Это решение проходит тесты, но его большой недостаток — необходимость хранить в памяти все элементы стрима,
     которых может быть очень много. Мы заранее не знаем, сколько их будет.

     Оптимальным решением является нахождение минимума и максимума за один проход по стриму без использования промежуточного хранилища элементов.

     Обратите внимание, что решение не использует приведение типа к (T). Благодаря этому отсутствуют предупреждения
     компилятора о небезопасном приведении типов. В других решениях, где Consumer реализован как лямбда-выражение или
     как анонимный класс, избежать предупреждений было бы гораздо сложнее.

     P.S. В лекциях были рассмотрены только последовательные стримы, однако в Java бывают еще и параллельные стримы,
     обрабатывающие свои элементы одновременно в нескольких потоках. Это решение для параллельных стримов не подходит.
     Но это уже совсем другая история...
     */
    public static <T> void findMinMax2(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {

        MinMaxFinder<T> minMaxFinder = new MinMaxFinder<>(order);
        stream.forEach(minMaxFinder);
        minMaxConsumer.accept(minMaxFinder.min, minMaxFinder.max);
    }


    private static class MinMaxFinder<T> implements Consumer<T> {

        private final Comparator<? super T> order;
        T min;
        T max;

        private MinMaxFinder(Comparator<? super T> order) {
            this.order = order;
        }

        @Override
        public void accept(T t) {
            if (min == null || order.compare(t, min) < 0) {
                min = t;
            }
            if (max == null || order.compare(max, t) < 0) {
                max = t;
            }
        }
    }

}
