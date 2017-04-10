package ru.alternation.Simple.section5.stage2.step8;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 Напишите метод, читающий входной поток и вычисляющий контрольную сумму прочитанных данных.

 Контрольная сумма данных вычисляется по следующему алгоритму:

 1. Контрольная сумма представляет собой число типа int. Контрольная сумма пустого набора данных равна нулю.
 2. Контрольная сумма непустого набора данных вычисляется по следующей рекуррентной формуле:

 C(n+1)=rotateLeft(C(n)) xor b(n+1), где
 - Cn — контрольная сумма первых n байт данных,
 - rotateLeft — циклический сдвиг бит числа на один бит влево (чтобы не изобретать велосипед,
                                                                                    используйте Integer.rotateLeft),
 - bn — n-ный байт данных.

 Поскольку метод не открывал данный InputStream, то и закрывать его он не должен.
 Выброшенное из методов InputStream исключение должно выбрасываться из метода.

 Пример:
 На вход подан InputStream, последовательно возвращающий три байта: 0x33 0x45 0x01.
 В качестве контрольной суммы должно быть возвращено число 71.
 */


public class Main {

    public static int checkSumOfStream(InputStream inputStream) throws IOException {

        int data = 0;
        int read = inputStream.read();
        while ( read != -1){
            data = Integer.rotateLeft(data, 1)^read;
            read = inputStream.read();
        }
        return data;
    }


    public static void main(String[] args) throws IOException {

//        int [] m = {0x33, 0x45, 0x01};
//        int c1 = m[0]; //Integer.rotateLeft(0, 1)^m[0];
//        int c2 = Integer.rotateLeft(c1, 1)^m[1];
//        int c3 = Integer.rotateLeft(c2, 1)^m[2];
//        System.out.println(c3);

        System.out.println(checkSumOfStream(new ByteArrayInputStream(new byte[] {0x33, 0x45, 0x01})));
    }
}
