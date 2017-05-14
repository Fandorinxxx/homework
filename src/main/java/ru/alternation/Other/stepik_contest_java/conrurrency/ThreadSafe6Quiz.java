package ru.alternation.Other.stepik_contest_java.conrurrency;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 5.23 Make the following code thread-safe (ex. 6)

 Make the following code below thread safe.

 Hint: there are various concurrent data structures available in java.util.concurrent package.
 */
public class ThreadSafe6Quiz {
    public static class ThreadSafe6 {
        private final Map<String, String> data = new ConcurrentHashMap<>(); //

        public void putIfAbsent(final String key, final String value) {
            data.putIfAbsent(key, value); // putIfAbsent() – добавляет значение в отображение, только если его там не было.
        }
    }
}