package ru.alternation.Simple.section2.stage1.step15;

/**
 Реализуйте метод flipBit, изменяющий значение одного бита заданного целого числа на противоположное.
 Данная задача актуальна, например, при работе с битовыми полями.
 https://ru.wikipedia.org/wiki/Битовое_поле

 Договоримся, что биты нумеруются от младшего (индекс 1) к старшему (индекс 32).

 Воспользуйтесь предоставленным шаблоном.
 Декларацию класса, метод main и обработку ввода-вывода добавит проверяющая система.

 Sample Input:
 0 1
 Sample Output:
 1

 */

// Про побитовые сдвиги
// https://pr0java.blogspot.ru/2015/04/java-byte-short-int-long.html

// http://ru.stackoverflow.com/questions/281650/Побитовые-операции-о-каких-из-них-полезно-знать-программистам-более-высоких
// http://www.quizful.net/interview/java/Cz1jySBYuxgy
// http://ru.stackoverflow.com/questions/491216/Замена-1-бита-в-числе-Задача

// https://ru.wikipedia.org/wiki/Дополнительный_код_(представление_числа)


public class Main {

    public static void main(String[] args) {

    }

    public static int flipFirstBit(int value) {
        return value ^ 1;
    }


    /**
     * Flips one bit of the given <code>value</code>.
     *
     * @param value     any number
     * @param bitIndex  index of the bit to flip, 1 <= bitIndex <= 32
     * @return new value with one bit flipped
     */
    public static int flipBit(int value, int bitIndex) {
        return value ^ (1 << --bitIndex);
    }

}
