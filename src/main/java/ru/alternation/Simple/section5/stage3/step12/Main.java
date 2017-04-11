package ru.alternation.Simple.section5.stage3.step12;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;


/**
 Реализуйте метод, который зачитает данные из InputStream и преобразует их в строку, используя заданную кодировку.

 Пример:
 InputStream последовательно возвращает четыре байта: 48 49 50 51.

 Метод, вызванный для такого InputStream и кодировки ASCII, должен вернуть строку "0123".


 https://stepik.org/media/attachments/lesson/12782/module5.pdf
 */
public class Main {

    public static String readAsString(InputStream inputStream, Charset charset) throws IOException {

        InputStreamReader reader = new InputStreamReader(inputStream, charset);
        StringBuilder stringBuilder = new StringBuilder();

        int ch;
        while ((ch = reader.read()) != -1){
            stringBuilder.append((char)ch);
        }
        return stringBuilder.toString();
    }


    public static void main(String[] args) throws IOException {
        String s = readAsString(new ByteArrayInputStream(new byte[]{48, 49, 50, 51}), StandardCharsets.US_ASCII);
        System.out.println(s);
    }










// ДРУГИЕ РЕШЕНИЯ =======================================================================================

    public static String readAsString2(InputStream inputStream, Charset charset) throws IOException {

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        final int MAX_BUF = 1024;
        byte[] buffer = new byte[MAX_BUF];

        int bytesWasRead;
        while ((bytesWasRead = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesWasRead);
        }
        return outputStream.toString(charset.toString());
    }
}
