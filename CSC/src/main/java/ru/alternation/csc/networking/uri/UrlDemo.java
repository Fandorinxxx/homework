package ru.alternation.csc.networking.uri;

import java.io.InputStream;
import java.net.URL;

public class UrlDemo {

    public static void main(String[] args) throws Exception {
        URL url = UrlDemo.class.getResource("UrlDemo.class");
        //URL url = new URL("https://ya.ru"); // скачать html страницу

        System.out.println(url); // file:/C:/Users/Alternation/IdeaProjects/StepikJava/target/classes/ru/alternation/examples/youtube/csc/networking/uri/UrlDemo.class
        try (InputStream inputStream = url.openStream()) {
            byte buffer[] = new byte[128];
            int bytesRead = inputStream.read(buffer);
            for (int i = 0; i < bytesRead; ++i) {
                if (i % 32 == 0) {
                    System.out.println();
                }
                System.out.printf("%02X ", buffer[i]); // CA FE BA BE 00 00 00 34 00 ...
            }
        }
    }
}
