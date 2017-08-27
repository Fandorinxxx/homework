package ru.alternation.stepik.basic.section6.stage1.step12;

import java.util.Objects;

/**
 Реализуйте generic-класс Pair, похожий на Optional, но содержащий пару элементов разных типов и не запрещающий
 элементам принимать значение null.

 Реализуйте методы getFirst(), getSecond(), equals() и hashCode(), а также статический фабричный метод of().
 Конструктор должен быть закрытым (private).

 С корректно реализованным классом Pair должен компилироваться и успешно работать следующий код: см. код в main().

 Пожалуйста, не меняйте модификатор доступа класса Pair. Для корректной проверки класс должен иметь пакетную видимость.


 _______________________________________________________________________________________________________________________
 _______________________________________________________________________________________________________________________

 /todo read
 http://www.quizful.net/post/java-generics-tutorial
 https://docs.oracle.com/javase/tutorial/java/generics/restrictions.html

 Return Type of Java Generic Methods
 https://stackoverflow.com/questions/11377248/return-type-of-java-generic-methods?rq=1

 Интерфейсы и Сортировка
 @see java.lang.Comparable
 @see java.util.Comparator
 https://metanit.com/java/tutorial/5.6.php

 Новый класс Optional в Java 8
 @see java.util.Optional
 @see java.util.Objects
 https://habrahabr.ru/post/225641/

 https://examples.javacodegeeks.com/core-java/util/optional/java-8-optional-example/

 Any reason to prefer getClass() over instanceof when generating .equals()?
 https://stackoverflow.com/questions/596462/any-reason-to-prefer-getclass-over-instanceof-when-generating-equals


 Пример использования функционального интерфейса
 https://data-structure-learning.blogspot.ru/2015/07/java-lambda-biconsumer-functional.html


 Презентация
 https://stepik.org/media/attachments/lesson/12775/module6.pdf
 */

public class Main{
    public static void main(String[] args) {
        Pair<Integer, String> pair = Pair.of(1, "hello");
        Integer i = pair.getFirst(); // 1
        String s = pair.getSecond(); // "hello"

        Pair<Integer, String> pair2 = Pair.of(1, "hello");
        System.out.println(pair.equals(pair2));// true!
        System.out.println(pair.hashCode() == pair2.hashCode());  // true!
        //System.out.println(null == null); // true
    }
}

class Pair <T, S> {

    private T first;
    private S second;

    private Pair(T first, S second) {
        this.first = first;
        this.second = second;
    }
    public T getFirst(){
        return first;
    }
    public S getSecond(){
        return second;
    }
    public static <T,S> Pair<T,S> of(T first, S second){
        return new Pair<>(first, second);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || o.getClass() != getClass()) // if (!(obj instanceof MyClass))
            return false;

        Pair<?,?> pair = (Pair<?,?>) o;

        return Objects.equals(first, pair.first) && Objects.equals(second, pair.second);

//        if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
//        return second != null ? second.equals(pair.second) : pair.second == null;
    }


    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = first != null ? first.hashCode() : 0;
        result = result*PRIME + (second != null ? second.hashCode() : 0);
        return result;
    }
}
