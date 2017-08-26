package ru.alternation.examples.file;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * https://youtu.be/fiUS7cbfE_8
 */
public class Test04 {
    public static void main(String[] args) {
        File file = new File(".\\temp.txt");
        if (!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e){
                e.printStackTrace();
            }
            System.out.println("now exists");
        }
        if (file.isDirectory()){
            System.out.println("dir");
        }
        if (file.isFile()){
            System.out.println("file");
        }try {
            System.out.println(file.getCanonicalPath());
        } catch (IOException e){
            e.printStackTrace();
        }

        try (FileWriter fileWriter = new FileWriter(file);
             FileReader fileReader = new FileReader(file)){

            fileWriter.write("123\n");
            fileWriter.write("456\n");
            fileWriter.flush();
            //fileWriter.close();

            char[] chars = new char[20];
            fileReader.read(chars);
            System.out.println(chars);

        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
