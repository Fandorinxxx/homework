package ru.alternation.stepik.contest_java.conrurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 5.21 Make the following code thread-safe (ex. 4)

 Make the following code below thread safe.

 Hint: explicit lock should always be explicitly unlocked.

 */
public class ThreadSafe4Quiz {
    public static class ThreadSafe4 {
        private List<String> recipe = new ArrayList<>();
        private final Lock lock = new ReentrantLock();
        public void add(final String ingredient) {
            lock.lock();
            try { //
                recipe.add(ingredient);
            }
            finally { //
                lock.unlock(); //
            }
        }
    }
}