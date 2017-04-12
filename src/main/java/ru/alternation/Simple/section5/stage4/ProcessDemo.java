package ru.alternation.Simple.section5.stage4;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.ProcessBuilder.Redirect;

/**
 * /todo
 * https://examples.javacodegeeks.com/core-java/lang/processbuilder/java-lang-processbuilder-example/
 * https://ru.stackoverflow.com/questions/468199/Можно-ли-средствами-java-убить-дочерние-процессы-процесса-созданного-с-помощью
 */
public class ProcessDemo {
    public static void main(String[] args) throws IOException, InterruptedException {
        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command("ls", "-l")
                .directory(new File("/home/stepik/username"))
                .redirectInput(Redirect.from(new File("dev/null")))
                .redirectOutput(Redirect.PIPE)
                .redirectError(Redirect.INHERIT);

        Process process = processBuilder.start(); // throws IOException
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(process.getInputStream()))){
            reader.lines().forEach(System.out::println);
        }

        int exitValue = process.waitFor(); // throws InterruptedException
        if (exitValue != 0){
            System.err.print("Subprocess terminated abnormally");
        }
    }
}
