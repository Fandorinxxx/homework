package ru.alternation.examples.monads.monads;


public interface TryMapFunction<T, R> {
    R apply(T t) throws Throwable;
}
