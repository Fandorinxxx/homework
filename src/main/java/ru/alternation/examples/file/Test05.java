package ru.alternation.examples.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * part 2
 * https://youtu.be/fiUS7cbfE_8
 */
public class Test05 {
    public static void main(String[] args) throws IOException {
        File file = new File("temp2.txt");
        if (!file.exists()) {
            file.createNewFile();
        }

        FileWriter fileWriter = new FileWriter(file);

        fileWriter.write("123\n");
        fileWriter.write("456\n");
        fileWriter.flush();
        //fileWriter.close();


        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write("str3");
        bufferedWriter.newLine();
        bufferedWriter.write("str4");
        bufferedWriter.flush();
        bufferedWriter.close();

        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        while (bufferedReader.ready()){
            System.out.println(bufferedReader.readLine());
        }



    }
}
