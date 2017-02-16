package ru.alternation.Simple.section2.stage2.step7;

/**
 Реализуйте метод, который возвращает букву, стоящую в таблице UNICODE после символа "\" (обратный слэш) на расстоянии a.

 Sample Input 1:
 32
 Sample Output 1:
 |

 Sample Input 2:
 29
 Sample Output 2:
 y
 */

public class Main {
    public static void main(String[] args) {
        System.out.println(charExpression(32) );
        System.out.println(charExpression(29) );
    }


    public static char charExpression(int a) {
        return (char) ('\\' + a);
    }
}
