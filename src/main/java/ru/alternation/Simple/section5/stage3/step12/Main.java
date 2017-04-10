package ru.alternation.Simple.section5.stage3.step12;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;

/**
 https://stepik.org/media/attachments/lesson/12782/module5.pdf
 */
public class Main {

    public static void main(String[] args) {


        PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(System.out, StandardCharsets.US_ASCII));
        printWriter.write("Ы");
        printWriter.flush();


    }


}
