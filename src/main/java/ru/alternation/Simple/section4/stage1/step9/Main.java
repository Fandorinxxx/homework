package ru.alternation.Simple.section4.stage1.step9;

/**
 * Created by Alternation on 03.04.2017.
 *
 * Реализуйте метод sqrt(), вычисляющий квадратный корень числа.
 * В отличие от Math.sqrt(), это метод при передаче отрицательного параметра должен бросать
 * исключение java.lang.IllegalArgumentException с сообщением "Expected non-negative number, got ?",
 * где вместо вопросика будет подставлено фактически переданное в метод число.
 */
public class Main {

    public static double sqrt(double x) {
        if (x<0){
            throw new IllegalArgumentException("Expected non-negative number, got " + x);
        }
        return Math.sqrt(x);
    }


// https://stackoverflow.com/questions/1883321/java-system-out-println-and-system-err-println-out-of-order
    public static void main(String[] args)
    {
//        for (int i = 0; i < 5; i++) {
//            System.out.println("out");
//            System.err.println("err");
//            System.out.flush();
//            System.err.flush();
//        }
        System.out.println(sqrt(144));
//        System.out.flush();
//        System.err.flush();
        System.out.println(sqrt(-144));
    }
}
