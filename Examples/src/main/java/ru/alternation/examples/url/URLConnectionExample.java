package ru.alternation.examples.url;


import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.Date;


// http://pro-java.ru/rabota-s-setyu-java/obzor-klassa-urlconnection-java-primer-programmy/

public class URLConnectionExample {

    public static void main(String[] args) throws Exception{
        int c;
        URL myUrl = new URL("http://habrahabr.ru/");
        long t1 = System.currentTimeMillis();
        URLConnection myUrlCon = myUrl.openConnection();
        long t2 = System.currentTimeMillis();
        //System.out.println((t2-t1)/1_000_000);
        System.out.println(t2-t1);

        // Получить дату
//        long d = myUrlCon.getDate();
//        if(d == 0)
//            System.out.println("Сведения о дате отсутствуют.");
//        else
//            System.out.println("Дата: " + new Date(d));
//
//        // Получить тип содержимого
//        System.out.println("Типа содержимого: "
//                + myUrlCon.getContentType());
//
//        // Получить дату срока действия ресурса
//        d = myUrlCon.getExpiration();
//        if(d == 0)
//            System.out.println("Сведения о сроке действия отсутствуют.");
//        else
//            System.out.println("Срок действия истекает: "
//                    + new Date(d));
//
//        // Получить дату последней модификации
//        d = myUrlCon.getLastModified();
//        if(d == 0)
//            System.out.println("Сведения о дате последней модификации отсутствуют.");
//        else
//            System.out.println("Дата последней модификации: "
//                    + new Date(d));
//
//        // Получить длину содержимого
//        long length = myUrlCon.getContentLengthLong();
//        if(length == -1)
//            System.out.println("Длина содержимого недоступна");
//        else
//            System.out.println("Длина содержимого: " + length);
//
//        if(length != 0) {
//            System.out.println("=== Содержимое ===");
//            InputStream input = myUrlCon.getInputStream();
//            Reader reader = new InputStreamReader(input, Charset.forName("utf-8"));
//            while(((c = reader.read()) != -1)) {
//                System.out.print((char) c);
//            }
//
//            input.close();
//        } else {
//            System.out.println("Содержимое недоступно.");
//        }
    }

}