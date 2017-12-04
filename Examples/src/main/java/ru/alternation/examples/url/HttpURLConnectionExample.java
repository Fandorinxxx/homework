package ru.alternation.examples.url;

import java.net.*;
import java.io.*;
import java.util.*;


// https://stackoverflow.com/a/26046079/6472224
// http://pro-java.ru/rabota-s-setyu-java/obzor-klassa-httpurlconnection-java-primery-rabotayushhix-programm/


public class HttpURLConnectionExample {

    public static void main(String[] args) throws Exception {
        URL myUrl = new URL("https://habrahabr.ru");
        long t1 = System.currentTimeMillis();
        HttpURLConnection myUrlCon =(HttpURLConnection) myUrl.openConnection();
        long t2 = System.currentTimeMillis();
        System.out.println(t2-t1);

        // Вывести метод запроса
        System.out.println("Метод запроса: " + myUrlCon.getRequestMethod());

        // Вывести код ответа
        System.out.println("Ответное сообщение: " + myUrlCon.getResponseMessage());

        // Получить список полей и множество ключей из заголовка
        Map<String, List<String>> myMap = myUrlCon.getHeaderFields();
        Set<String> myField = myMap.keySet();
        System.out.println("\nДалее следует заголовок:");

        // Вывести все ключи и значения из заголовка
        for(String k : myField) {
            System.out.println("Ключ: " + k + " Значение: " + myMap.get(k));
        }
    }

}