package ru.alternation.Simple.section6.stage4.step13;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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

 https://ru.wikipedia.org/wiki/Свёртка_списка
 https://habrahabr.ru/post/255659/
 http://info.javarush.ru/translation/2014/10/09/Особенности-Java-8-максимальное-руководство-часть-2-.html
 https://habrahabr.ru/post/262139/
 https://habrahabr.ru/company/luxoft/blog/270383/

 http://www.oracle.com/technetwork/articles/java/architect-streams-pt2-2227132.html
 https://www.mkyong.com/java8/java-8-collectors-groupingby-and-mapping-example/

 TAGS: РЕГУЛЯРНЫЕ ВЫРАЖЕНИЯ \p{Punct}

 https://stackoverflow.com/questions/4304928/unicode-equivalents-for-w-and-b-in-java-regular-expressions/4307261#4307261
 http://www.darkraha.com/rus/dic/regexp.php

 */
public class Main {

    public static void main(String[] args) {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(("Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                "Sed sodales consectetur purus at faucibus. Donec mi quam, tempor vel ipsum non, faucibus suscipit massa. Morbi lacinia velit " +
                "blandit tincidunt efficitur. Vestibulum eget metus imperdiet sapien laoreet faucibus. Nunc eget vehicula mauris, ac auctor lorem. " +
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer vel odio nec mi tempor dignissim.\n")
                .getBytes(StandardCharsets.UTF_8));
        ByteArrayInputStream inputStream2 = new ByteArrayInputStream("Мама мыла-мыла-мыла раму!".getBytes(StandardCharsets.UTF_8));


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
                    Collections.sort(sorted2, (o1, o2) -> o2.getValue().compareTo(o1.getValue())); // Comparator.comparing(Map.Entry::getValue)); и //Collections.reverse(sorted2);
                    sorted2.stream().limit(10)
                            .forEach(entry -> System.out.println(entry.getKey())); // + " " + entry.getValue()));

                }
        );
    }
}
