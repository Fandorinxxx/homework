package ru.alternation.stepik.basic.section5.stage3.step11;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

/**
 Рассмотрим следующий код:

 Writer writer = new OutputStreamWriter(outputStream, StandardCharsets.US_ASCII);

 Что будет фактически записано в outputStream, если мы попытаемся вывести через writer символ,
 не представимый в указанной ему кодировке ASCII? Например, какой-нибудь иероглиф или символ кириллицы.

 - Байт 0
 - Байт 63 (ASCII-код символа '?')
 - Байт 32 (ASCII-код пробела)
 - Ни одного байта выведено не будет
 - Будет брошено исключение

 */


public class Quiz {
    public static void main(String[] args) {

        PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(System.out, StandardCharsets.US_ASCII));
        printWriter.write("Ы");
        printWriter.flush();
    }
}
