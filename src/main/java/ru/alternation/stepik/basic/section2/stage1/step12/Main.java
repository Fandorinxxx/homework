package ru.alternation.stepik.basic.section2.stage1.step12;

/**
 Реализуйте метод, возвращающий ответ на вопрос: правда ли, что a + b = c?
 Допустимая погрешность – 0.0001 (1E-4)

 Можно использовать класс Math и его методы. Класс Math доступен всегда, импортировать его не надо.

 В качестве примера написано заведомо неправильное выражение. Исправьте его.

 Sample Input:
 0.1 0.2 0.3

 Sample Output:
 true

 */


public class Main {
    public static void main(String[] args) {
        //System.out.println( 0.1 +0.2 +0.3); // 0.6000000000000001
    }

    public static boolean doubleExpression(double a, double b, double c) {
        return (Math.abs((a + b) - c) <= 0.0001);
    }

}


//Классы BigInteger и BigDecimal
// https://pr0java.blogspot.ru/2015/05/biginteger-bigdecimal_70.html

//Примитивные вещественные типы - знакомство с граблями
// https://pr0java.blogspot.ru/2015/04/blog-post_15.html