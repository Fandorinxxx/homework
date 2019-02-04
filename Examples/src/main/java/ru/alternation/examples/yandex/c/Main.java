package ru.alternation.examples.yandex.c;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Predicate;

/**
 *

 Задачка отсюда: https://contest.yandex.ru/contest/8458/problems/C/

 C. Удаление дубликатов

 Ограничение памяти: 20Mb
 Ввод: стандартный ввод или input.txt
 Вывод: стандартный вывод или output.txt

 Дан упорядоченный по неубыванию массив целых 32-разрядных чисел. Требуется удалить из него все повторения.

 Желательно получить решение, которое не считывает входной файл целиком в память,
 т.е., использует лишь константный объем памяти в процессе работы.


 Формат ввода
 Первая строка входного файла содержит единственное число n, n ≤ 1000000.
 На следующих n строк расположены числа — элементы массива, по одному на строку. Числа отсортированы по неубыванию.


 Формат вывода
 Выходной файл должен содержать следующие в порядке возрастания уникальные элементы входного массива.


 Пример 1
 Ввод	Вывод
 5      2
 2      4
 4      5
 8
 8
 8

 Пример 2
 Ввод	Вывод
 5      2
 2      8
 2
 2
 8
 8


 *
 */



public class Main {
    public static void main(String... args) throws IOException {

        Predicate<String> isNew = new Predicate<String>() {
            private String previous = "";
            private int count = 0;

            @Override
            public boolean test(String current) {
                count++;

                if (count == 10000) {
                    System.gc();
                    count = 0;
                }

                if (current.equals(previous)) {
                    return false;
                } else {
                    previous = current;
                    return true;
                }
            }
        };

        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("./input.txt")));


        String line = reader.readLine(); // первоя строка – количество записий, оно не нужно

        while ((line = reader.readLine()) != null) {
            if (isNew.test(line)) {
                System.out.println(line);
            }
        }
    }
}
