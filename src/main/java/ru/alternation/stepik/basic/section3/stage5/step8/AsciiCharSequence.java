package ru.alternation.stepik.basic.section3.stage5.step8;

import java.util.Arrays;

/**
 Напишите класс AsciiCharSequence, реализующий компактное хранение последовательности ASCII-символов
 (их коды влезают в один байт) в массиве байт.
 По сравнению с классом String, хранящим каждый символ как char, AsciiCharSequence будет занимать в два раза меньше памяти.

 Класс AsciiCharSequence должен:

 реализовывать интерфейс java.lang.CharSequence;
 иметь конструктор, принимающий массив байт;
 определять методы length(), charAt(), subSequence() и toString()
 Сигнатуры методов и ожидания по их поведению смотрите в описании интерфейса java.lang.CharSequence (JavaDoc или исходники).

 В данном задании методам charAt() и subSequence() всегда будут подаваться корректные входные параметры,
 поэтому их проверкой и обработкой ошибок заниматься не нужно. Тем более мы еще не проходили исключения.

 P.S. В Java 9 ожидается подобная оптимизация в самом классе String: http://openjdk.java.net/jeps/254

 */
public class AsciiCharSequence implements CharSequence {

    private final byte[] string;

    public AsciiCharSequence(byte[] string) {
        this.string = Arrays.copyOf(string, string.length);
    }

    @Override
    public int length() {
        return string.length;
    }

    @Override
    public char charAt(int index) {
        return (char) string[index];
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return new AsciiCharSequence(Arrays.copyOfRange(string, start, end));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (byte b : string) {
            sb.append((char)b);
        }
        return sb.toString();
    }
}
class Runner{
    public static void main(String[] args) {

        AsciiCharSequence a = new AsciiCharSequence("Hello qwerty".getBytes());

        CharSequence b = a.subSequence(6, 9);

        System.err.println(a.toString());
        System.err.println(b);
    }
}
