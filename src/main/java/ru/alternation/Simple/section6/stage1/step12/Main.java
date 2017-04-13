package ru.alternation.Simple.section6.stage1.step12;



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

 Презентация
 https://stepik.org/media/attachments/lesson/12775/module6.pdf
 */


public class Main {
    public static void main(String[] args) {

        Pair<Integer, String> pair = Pair.of(1, "hello");
        Integer i = pair.getFirst(); // 1
        String s = pair.getSecond(); // "hello"

        Pair<Integer, String> pair2 = Pair.of(1, "hello");
        boolean mustBeTrue = pair.equals(pair2); // true!
        boolean mustAlsoBeTrue = pair.hashCode() == pair2.hashCode(); // true!



    }
}
