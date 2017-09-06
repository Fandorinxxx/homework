package ru.alternation.stepik.alt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 Input/output in code challenges - 2

 Another common way to read integer numbers is to use java.io.BufferedReader.

 Let's read two integer numbers, sum up them and writes the result in the standard output again.


 You can try to submit this code in the section below.

 Note, I/O operations will be studied in detail in the relevant topics. Now use one of two provided examples as a template for I/O.

 If you aren't sure what to use, use the previous way (java.util.Scanner). In this course it would be enough.
 */

public class Main002 {

    public static void main(String[] args) throws IOException {

        // the object for reading
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // it takes a string and splits it by whitespaces
        String[] values = reader.readLine().split("\\s+");

        int a = Integer.parseInt(values[0]); // It converts the first value to integer
        int b = Integer.parseInt(values[1]); // It converts the second value to integer

        System.out.println(a + b);
    }
}