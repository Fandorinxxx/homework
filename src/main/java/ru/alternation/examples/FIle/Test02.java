package ru.alternation.examples.FIle;

import java.io.File;

/**
 * https://metanit.com/java/tutorial/6.11.php
 */
public class Test02 {
    public static void main(String[] args) {

        // определяем объект для каталога
        File dir = new File("C://SomeDir//NewDir");
        boolean created = dir.mkdir();
        if (created)
            System.out.println("Каталог успешно создан");
        // переименуем каталог
        File newDir = new File("C://SomeDir//NewDirRenamed");
        dir.renameTo(newDir);
        // удалим каталог
        boolean deleted = newDir.delete();
        if (deleted)
            System.out.println("Каталог удален");
    }
}