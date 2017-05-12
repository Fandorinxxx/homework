package ru.alternation.Trash.Youtube.CSC.multithreading.demo6;

public class Singleton {

    private static volatile Singleton instance;

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized(Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    private Singleton() {}
}

class Singleton2 {
    private static Singleton2 instance;

    public static synchronized Singleton2 getInstance() {
        if (instance == null) {
            instance = new Singleton2();
        }
        return instance;
    }
    private Singleton2() {}
}

/**
 * https://en.wikipedia.org/wiki/Initialization-on-demand_holder_idiom
 * https://habrahabr.ru/post/27108/
 *
 * Initialization on Demand Holder
 *
 * В данном случае мы полностью решили проблему ленивой инициализации – объект инициализируется при первом вызове
 * метода getInstance(). Но у нас осталась проблема с обработкой исключительных ситуаций в конструкторе. Так что,
 * если конструктор класса не вызывает опасений создания исключительных ситуаций, то смело можно использовать этот метод.
 */
class Something {
    private Something() {}

    private static class LazyHolder {
        private static final Something INSTANCE = new Something();
    }

    public static Something getInstance() {
        return LazyHolder.INSTANCE;
    }
}
