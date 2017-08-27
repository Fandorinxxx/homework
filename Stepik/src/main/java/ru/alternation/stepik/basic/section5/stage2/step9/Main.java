package ru.alternation.stepik.basic.section5.stage2.step9;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;


/**
 По историческим причинам на разных платформах принят разный способ обозначения конца строки в текстовом файле.
 На Unix-системах конец строки обозначается символом с кодом 10 ('\n'),
 на Windows — двумя последовательными символами с кодами 13 и 10 ('\r' '\n').

 Напишите программу, которая будет преобразовывать переводы строк из формата Windows в формат Unix.
 Данные в формате Windows подаются программе в System.in, преобразованные данные должны выводиться в System.out.
 На этот раз вам надо написать программу полностью, т.е. объявить класс (с именем Main — таково ограничение
 проверяющей системы), метод main, прописать все import'ы.

 Требуется заменить все вхождения пары символов '\r' и '\n' на один символ '\n'.
 Если на входе встречается одиночный символ '\r', за которым не следует '\n', то символ '\r' выводится без изменения.

 Кодировка входных данных такова, что символ '\n' представляется байтом 10, а символ '\r' — байтом 13.
 Поэтому программа может осуществлять фильтрацию на уровне двоичных данных, не преобразуя байты в символы.

 Из-за буферизации данных в System.out в конце вашей программы надо явно вызвать System.out.flush().
 Иначе часть выведенных вами данных не будет видна проверяющей системе.


 Пример:

 Из System.in зачитаны следующие байты: 65 13 10 10 13.
 Внимание! Это не строка "65 13 10 10 13", а последовательность чисел, возвращаемая методом System.in.read().

 В System.out должны быть выведены байты: 65 10 10 13
 */
public class Main {
    public static void main(String[] args) throws IOException {

//        ByteArrayOutputStream out = new ByteArrayOutputStream();
//        inputConverter(new ByteArrayInputStream(new byte[]{65, 13, 10, 10, 13}), out);
//        System.out.println(Arrays.toString(out.toByteArray()));   // 65 10 10 13

//        test(); // фулл тесты

        inputConverter(System.in, System.out);
    }

    static void inputConverter(InputStream in, OutputStream out) throws IOException {
        final byte R = '\r'; // 13
        final byte N = '\n'; // 10

        int read;
        boolean isPreviousByteR = false;

        while ((read = in.read()) != -1){
            if (read != N ){
                if (read != R){
                    if (isPreviousByteR){
                        out.write(R);
                        isPreviousByteR = false;
                    }
                    out.write(read);
                } else { // если '\r'
                    if (isPreviousByteR){
                        out.write(R);
                    } else {
                        isPreviousByteR = true;
                    }
                }
            } else { // если '\n'
                if (isPreviousByteR){
                    out.write(N);
                    isPreviousByteR = false;
                } else {
                    out.write(N);
                }
            }
        }
        if (isPreviousByteR)
            out.write(R);

        out.flush();
    }


// https://github.com/meanmail/java_base/blob/884e2286c9d5326902d7f1d6747a6aa442adf22b/src/meanmail/stepic/java/tests/module5/lesson2/step9/Main.java
    static void test() throws IOException {

        byte[][][] testSet = new byte[][][]{
                {{65, 13, 10, 10, 13}, {65, 10, 10, 13}},
                {{}, {}},
                {{13, 10}, {10}},
                {{10, 13}, {10, 13}},
                {{13, 13, 13, 13, 13},  {13, 13, 13, 13, 13}},
                {{10, 10}, {10, 10}},
                {{13, 13, 10}, {13, 10}},
                {{13, 65}, {13, 65}}
        };

        System.out.println("Input: -\nOutput: -\nExpected output: -\n");

        for (int i = 0; i < testSet.length; i++) {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            System.out.println(Arrays.toString(testSet[i][0]));
            inputConverter(new ByteArrayInputStream(testSet[i][0]), out);
            System.out.println(Arrays.toString(out.toByteArray()));
            System.out.println(Arrays.toString(testSet[i][1]));
            System.out.println("");
        }
    }
}
