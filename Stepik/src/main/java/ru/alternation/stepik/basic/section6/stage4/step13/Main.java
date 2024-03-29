package ru.alternation.stepik.basic.section6.stage4.step13;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 Напишите программу, читающую из System.in текст в кодировке UTF-8, подсчитывающую в нем частоту появления слов,
 и в конце выводящую 10 наиболее часто встречающихся слов.

 Словом будем считать любую непрерывную последовательность символов, состоящую только из букв и цифр.
 Например, в строке "Мама мыла раму 33 раза!" ровно пять слов: "Мама", "мыла", "раму", "33" и "раза".

 Подсчет слов должен выполняться без учета регистра, т.е. "МАМА", "мама" и "Мама" — это одно и то же слово.
 Выводите слова в нижнем регистре.

 Если в тексте меньше 10 уникальных слов, то выводите сколько есть.

 Если в тексте некоторые слова имеют одинаковую частоту, т.е. их нельзя однозначно упорядочить только по частоте,
 то дополнительно упорядочите слова с одинаковой частотой в лексикографическом порядке.

 Задача имеет красивое решение через стримы без циклов и условных операторов. Попробуйте придумать его.

 _______________________________________________________________________________________________________________________
 Sample Input 1:
 Мама мыла-мыла-мыла раму!

 Sample Output 1:
 мыла
 мама
 раму

 Sample Input 2:
 Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed sodales consectetur purus at faucibus. Donec mi quam, tempor vel ipsum non, faucibus suscipit massa. Morbi lacinia velit blandit tincidunt efficitur. Vestibulum eget metus imperdiet sapien laoreet faucibus. Nunc eget vehicula mauris, ac auctor lorem. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer vel odio nec mi tempor dignissim.

 Sample Output 2:
 consectetur
 faucibus
 ipsum
 lorem
 adipiscing
 amet
 dolor
 eget
 elit
 mi
 _______________________________________________________________________________________________________________________

 https://habrahabr.ru/company/luxoft/blog/270383/
 http://info.javarush.ru/translation/2014/10/09/Особенности-Java-8-максимальное-руководство-часть-2-.html
 http://www.oracle.com/technetwork/articles/java/architect-streams-pt2-2227132.html
 https://www.mkyong.com/java8/java-8-collectors-groupingby-and-mapping-example/
 https://ru.wikipedia.org/wiki/Свёртка_списка
 https://habrahabr.ru/post/255659/
 https://habrahabr.ru/post/262139/


 TAGS: РЕГУЛЯРНЫЕ ВЫРАЖЕНИЯ \p{Punct}
 https://stackoverflow.com/questions/4304928/unicode-equivalents-for-w-and-b-in-java-regular-expressions/4307261#4307261
 http://www.darkraha.com/rus/dic/regexp.php

 */
public class Main {
    private static ByteArrayInputStream inputStream = new ByteArrayInputStream(("Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
            "Sed sodales consectetur purus at faucibus. Donec mi quam, tempor vel ipsum non, faucibus suscipit massa. Morbi lacinia velit " +
            "blandit tincidunt efficitur. Vestibulum eget metus imperdiet sapien laoreet faucibus. Nunc eget vehicula mauris, ac auctor lorem. " +
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer vel odio nec mi tempor dignissim.\n")
            .getBytes(StandardCharsets.UTF_8));
    private static ByteArrayInputStream inputStream2 = new ByteArrayInputStream("Мама мыла-мыла-мыла раму!".getBytes(StandardCharsets.UTF_8));


    public static void main(String[] args) {

        BufferedReader bf = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8)); // System.in

        bf.lines().forEach((String s) ->{
                    String[] strings = s.split("[\\p{Punct}\\s]+"); // "\\W+" -- не работает с руссичем
                    Map<String, Integer> map = new TreeMap<>();
                    for (String i : strings){
                        String str = i.toLowerCase();
                        if (map.containsKey(str)){
                            map.put(str, map.get(str)+1);
                        } else {
                            map.put(str, 1);
                        }
                    }
                    List<Map.Entry<String, Integer>> sorted2 = new ArrayList<>(map.entrySet());
                    sorted2.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue())); // Comparator.comparing(Map.Entry::getValue)); и //Collections.reverse(sorted2);
                    sorted2.stream().limit(10)
                            .forEach(entry -> System.out.println(entry.getKey())); // + " " + entry.getValue()));
                }
        );
    }

    //==================================================================================================================
    void referenceSolution(){
        // Для чтения входного потока используем Scanner.
        // Поскольку словами мы считаем последовательности символов,
        // состоящие из букв или цифр, то в качестве разделителя слов Scanner'у
        // указываем регулярное выражение, означающее
        // "один или более символ, не являющийся ни буквой, ни цифрой".
        Scanner scanner = new Scanner(System.in, "UTF-8")
                .useDelimiter("[^\\p{L}\\p{Digit}]+");

        // Пройдем по всем словам входного потока и составим Map<String, Integer>,
        // где ключом является слово, преобразованное в нижний регистр,
        // а значением - частота этого слова.
        Map<String, Integer> freqMap = new HashMap<>();
        scanner.forEachRemaining(s -> freqMap.merge(s.toLowerCase(), 1, (a, b) -> a + b));

        freqMap.entrySet().stream()                 // получим стрим пар (слово, частота)
                .sorted(descendingFrequencyOrder()) // отсортируем
                .limit(10)                          // возьмем первые 10
                .map(Map.Entry::getKey)             // из каждой пары возьмем слово
                .forEach(System.out::println);      // выведем в консоль
    }

    // Создание Comparator'а вынесено в отдельный метод, чтобы не загромождать метод main.
    private static Comparator<Map.Entry<String, Integer>> descendingFrequencyOrder() {
        // Нам нужен Comparator, который сначала упорядочивает пары частоте (по убыванию),
        // а затем по слову (в алфавитном порядке). Так и напишем:
        return Comparator.<Map.Entry<String, Integer>>comparingInt(Map.Entry::getValue)
                .reversed()
                .thenComparing(Map.Entry::getKey);
    }

    //==================================================================================================================

    void anotherSolution(){
        new BufferedReader(new InputStreamReader(System.in))
            .lines()
            .flatMap(s -> Stream.of(s.split("[^a-zA-Zа-яА-Я0-9]")))
            .filter(s -> !s.isEmpty())
            .map(String::toLowerCase)
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
            .entrySet()
            .stream()
            .sorted(Map.Entry.<String, Long>comparingByValue()
                    .reversed()
                    .thenComparing(Map.Entry.comparingByKey()))
            .limit(10)
            .map(Map.Entry::getKey)
            .forEachOrdered(System.out::println);
    }
}
