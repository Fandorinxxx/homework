package ru.alternation.stepik.basic.section6.stage1;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Comparator;
import java.util.Map;
import java.util.Optional;

// Размышления касательно <? super T> и <? extends T>.

// Если вызывающий код будет параметризован дочерним, мы не сможем подставить туда объект родительныского класса.
// Т.е. если класс параметризован Number, а потребитель будет ожидать Integer,
// этот потребитель сможет затребовать методы/поля (в своей реализации), которых нет у более общего класса - Number или Object.
// Зато если вызывающий код будет параметризован таким же или более общим классом (чем передаваемый ему), таких проблем не будет
// (у передаваемого объекта будут как методы, так и поля более общего класса, от которого он наследован).
// Напомню, что в дочерних классах модификаторы доступа можно только расширить, уменьшить уровень видимости методов/полей нельзя.
//        public void ifPresent(Consumer<? super T> consumer) {
//            if (value != null)
//                consumer.accept(value); // у value тип T // accept - вызывающих код
                                          // т.е. передаю методу accept переменную типа T, и, значит, этот метод должен принимать либо T, либо его супертип.
//        }

// Работа с дочерними классами должна быть абсолютно незаметна для вызывающего кода - согласно принципу Лисков (Вроде, верно перефразировал.).
// Т.е. если вернем дочерний класс, вызывающих код, который ожидает получить какой-то класс, получит вместо него более специализированный/расширенный,
// будет спокойно с ним работать, ибо API этого же класса будет такой же (публичные методы и поля).
// (Конечно, при правильном проектировании классов.  (Соблюдая принцип Лисков - "Поведение наследуемых классов не должно противоречить поведению,
// заданному базовым классом, то есть поведение наследуемых классов должно быть ожидаемым для кода, использующего переменную базового типа."))
//        public T orElseGet(Supplier<? extends T> other) {
//            return value != null ? value : other.get();
//        }

/*
Optional без параметризации и Optional<Object> дает Optional, у которого методы принимают и возвращают Object.
Optional<?> дает Optional, из которого (например, методом get()) можно получить Object. А передать в него (например, в метод orElse()) ничего нельзя. Компилятор не разрешит.
 */


/**
 * Как сделать проверяемое исключение непроверяемым
 */

public class Hack {
    public static void main(String[] args) {
        throwAsUnchecked(new IOException());
        //genericThrow(new IOException()); // можно и просто, так – throws не требуется все равно
    }

    private static void throwAsUnchecked(Exception e) {
        Hack.<RuntimeException>genericThrow(e); // можно и без <>
    }

    private static <T extends Throwable> void genericThrow(Exception e) throws T {
        throw (T) e;
    }


    /**
     * Пример, где нужно приведение дженерика
     */
    void also() {
        Optional<CharSequence> optionalCharSequence = Optional.<CharSequence>ofNullable("baz"); // тут можно и без

        Comparator<Map.Entry<String, Integer>> c =
                Comparator.<Map.Entry<String, Integer>>comparingInt(Map.Entry::getValue)
                        .thenComparing(Map.Entry::getKey); // нужно
//         иначе
//        Error:(65, 41) java: incompatible types: cannot infer type-variable(s) T
//                (argument mismatch; invalid method reference
//        method getValue in interface java.util.Map.Entry<K,V> cannot be applied to given types
//        required: no arguments
//        found: java.lang.Object
//        reason: actual and formal argument lists differ in length)
//
//        Error:(65, 45) java: invalid method reference
//        non-static method getValue() cannot be referenced from a static context
//
//        Error:(66, 43) java: invalid method reference
//        non-static method getKey() cannot be referenced from a static context

    }
}