package ru.alternation.Simple.section5.stage3.step10;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;

/**
 Какими байтами представляется символ 'Ы' в кодировке UTF-8?
 Введите десятичные беззнаковые значения байт через пробел, например, 10 34 254.

 */
public class Quiz {

    public static void main(String[] args)  {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Writer writer = new OutputStreamWriter(outputStream, StandardCharsets.UTF_8);
        PrintWriter printWriter = new PrintWriter(writer);
        printWriter.write("Ы");
        printWriter.flush();
        //System.out.println(Arrays.toString(outputStream.toByteArray())); // [-48, -85]
        for (byte b : outputStream.toByteArray()) {
            System.out.println(Byte.toUnsignedInt(b));
        }


        System.out.println();

        // или так
        byte[] bytes = "Ы".getBytes(StandardCharsets.UTF_8);
        for (byte oneByte : bytes) {
            System.out.println(Byte.toUnsignedInt(oneByte));
        }

        System.out.println();


//        // без PrintWriter, но с throws IOException
//        ByteArrayOutputStream outputStream2 = new ByteArrayOutputStream();
//        Writer writer2 = new OutputStreamWriter(outputStream2, StandardCharsets.UTF_8);
//        writer2.write("Ы".toCharArray());
//        writer2.flush();
//        for (byte b : outputStream2.toByteArray())
//            System.out.println(Byte.toUnsignedInt(b));
    }
}
