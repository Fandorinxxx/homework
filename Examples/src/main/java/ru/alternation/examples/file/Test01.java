package ru.alternation.examples.file;

import java.io.File;

/**
 https://metanit.com/java/tutorial/6.11.php
 */
public class Test01 {


    public static void main(String[] args) {

        // определяем объект для каталога
        File dir = new File("C://SomeDir");
        // если объект представляет каталог
        if(dir.isDirectory())
        {
            // получаем все вложенные объекты в каталоге
            for(File item : dir.listFiles()){

                if(item.isDirectory()){
                    System.out.println(item.getName() + "  \tкаталог");
                }
                else{
                    System.out.println(item.getName() + "\tфайл");
                }
            }
        }
    }

}
