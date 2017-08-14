package ru.alternation.stepik.basic.section6.stage2.step15;


import java.io.BufferedReader;
import java.io.CharArrayReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 Напишите программу, которая прочитает из System.in последовательность целых чисел, разделенных пробелами,
 затем удалит из них все числа, стоящие на четных позициях, и затем выведет получившуюся последовательность в
 обратном порядке в System.out.

 Все числа влезают в int. Позиции чисел в последовательности нумеруются с нуля.

 В этом задании надо написать программу целиком, включая import'ы, декларацию класса Main и метода main.

 ______________________
 Sample Input:
 1 2 3 4 5 6 7

 Sample Output:
 6 4 2

 http://info.javarush.ru/translation/2014/04/22/В-Java-8-можно-объединять-строки-.html
 @see StringJoiner

 TAGS: ПРЕРЫВАНИЕ ВВОДА КОМБИНАЦИЯ КЛАВИШ
 Lля прекращения ввода нажать CTRL + D
 */
public class Main {
    public static void main(String[] args)  {


        //scannerRealication();
        inputStreamRealization(); // реализация без сканнера // 4 штуки

    }
    static void scannerRealication(){
        CharArrayReader charArrayReader = new CharArrayReader("1 2 3 4 5 6 7".toCharArray());
        Scanner scanner = new Scanner(System.in);

        List<Integer> list = new ArrayList<>();

        int i = 0;
        while (scanner.hasNextInt()){
            int value = scanner.nextInt();
            if (++i % 2 == 0){
                list.add(value);
                System.err.println(value);
            }
        }
        Collections.reverse(list);
        list.forEach(v -> System.out.print(v + " "));

    }

    //+_________________________________________________________________________________________
    static void inputStreamRealization(){
        CharArrayReader charArrayReader = new CharArrayReader("1 2 3 4 5 6 7".toCharArray());

        try (InputStreamReader reader = new InputStreamReader(System.in);
             BufferedReader bufferedReader = new BufferedReader(reader)) { // charArrayReader

            String s = bufferedReader.readLine();
            if (s != null) {
                String[] strings = s.split("\\s");

                System.err.println(Arrays.toString(strings));
                //System.out.println(dequeFor(strings));        // 1
                //System.out.println(dequeIterator(strings));   // 2
                //System.out.println(listRealization(strings)); // 3
                System.out.println(stringRealization(strings)); // 4

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
// 4
    static String stringRealization(String[] strings){

        int even = 1; // чётное число
        Deque<Integer> integers = new ArrayDeque<>();

        for (String s : strings){
            if (even%2 == 0){
                integers.push(Integer.parseInt(s));
            }
            even++;
        }
        Iterator<Integer>  iterator = integers.iterator();
        StringJoiner sb = new StringJoiner(" "); // СтрингДжойнер заюзал
        while (iterator.hasNext()){
            sb.add(iterator.next().toString());
        }
        return sb.toString();
    }

// 1
    static String listRealization(String[] strings){

        List<Integer> list = new ArrayList<>();
        Arrays.stream(strings).forEach(str -> list.add(Integer.parseInt(str)));

        StringBuilder builder = new StringBuilder();
        for (int i = list.size()-1; i != 0; i--) {
            if (i%2 != 0){
                builder.append(list.get(i)).append(" ");
            }
        }
        return builder.toString();
    }

// 2
    static String dequeIterator(String[] strings){

            Deque<Integer> integers = new ArrayDeque<>();
            Arrays.stream(strings).forEach(str -> integers.addLast(Integer.parseInt(str)));


            StringBuilder builder = new StringBuilder();
            Iterator<Integer> iterator = integers.descendingIterator();
            while (iterator.hasNext()) {
                if (integers.size() % 2 == 0) {
                    builder.append(iterator.next()).append(" ");
                    iterator.remove();
                } else {
                    iterator.next();
                    iterator.remove();
                }
            }
            return builder.toString();
    }

// 3
    static String dequeFor(String[] strings){

        Deque<Integer> integers = new ArrayDeque<>();
        Arrays.stream(strings).forEach(str -> integers.addLast(Integer.parseInt(str)));


        StringBuilder builder = new StringBuilder();
        for (int i = integers.size()-1; i != 0; i--) {
            if (i%2 != 0){
                builder.append(integers.pollLast()).append(" ");
            } else {
                integers.pollLast();
            }
        }
        return builder.toString();
    }

}
