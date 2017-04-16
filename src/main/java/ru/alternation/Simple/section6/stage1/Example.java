package ru.alternation.Simple.section6.stage1;

import java.util.Optional;

/**
 * https://docs.oracle.com/javase/tutorial/java/generics/restrictions.html
 * @param <X>
 */

public class Example<X> {
    public void someMethod(Object obj) {

        // Проверка (obj instanceof Optional<x>)
//        if (obj instanceof Optional<X>) {}

        // Приведение obj к типу X
        X x = (X) obj;

        // Создание экземпляра X
//        new X();

        // Получение экземпляра Optional<x> через Optional.empty()
        Optional<X> xOptional = Optional.empty();

        // Проверка (obj instanceof X)
//        if (obj instanceof X) {}

        // Создание массива X
//        new X[];

    }
}