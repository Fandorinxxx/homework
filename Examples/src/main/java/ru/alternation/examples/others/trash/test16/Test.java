package ru.alternation.examples.others.trash.test16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

/**
 * https://javatalks.ru/topics/10697
 */

public class Test {
    public static void main(String... args) throws IOException, InterruptedException {

        Process process;
        Runtime runtime = Runtime.getRuntime();

        process = runtime.exec("help");
//         process = runtime.exec(new String[]{"java", "-version"});

//        ProcessBuilder pb = new ProcessBuilder("java", "-version");
//        ProcessBuilder pb = new ProcessBuilder("echo", "Hello JCG\nThis is ProcessBuilder Example"); // не работает
//        process = pb.start();


        Stream errorGobbler = new Stream(process.getErrorStream(), "ERROR");
        Stream outputGobbler = new Stream(process.getInputStream(), "OUTPUT");
        errorGobbler.start();
        outputGobbler.start();

        //process.waitFor(2, TimeUnit.SECONDS);
        process.waitFor();
        process.destroy();
    }
}
class Stream extends Thread {
    private InputStream is;
    private String type;

    Stream(InputStream is, String type) {
        this.is = is;
        this.type = type;
    }

    public void run() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(is, Charset.forName("CP866"))); // utf-8, CP866, CP1251
            String line = null;
            while ( (line = br.readLine()) != null) {
                System.out.println(type + " > " + line);
            }
        } catch (IOException ex){
            ex.printStackTrace();
        }
    }
}