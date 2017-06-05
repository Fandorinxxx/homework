package ru.alternation.Trash.monads.monads;


public interface TryMapFunction<T, R> {
    R apply(T t) throws Throwable;
}
