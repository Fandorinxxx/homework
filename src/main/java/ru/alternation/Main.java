package ru.alternation;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;


public class Main {

    interface A{
        default void apply(){
            System.out.println("A");
        }
    }
    interface S{
        default void apply(){
            System.out.println("S");
        }
    }
    static class Z implements A, S {

        @Override
        public void apply() {
            System.out.println("Z");
        }
    }
    static void Q(){}

    public static void main(String[] args) throws IOException {

        new Z().apply();




        CompletableFuture f;




        //Thread.sleep(5);



//        Reader reader = new StringReader("This is a test string for JCG Stream Tokenizer Example");
//        StreamTokenizer tokenizer = new StreamTokenizer(reader);
//        while(tokenizer.nextToken()!= StreamTokenizer.TT_EOF){
//            System.out.println(tokenizer.sval);
//        }


//        int i = -1024;
//        for (int j = 0; j < 65; j++) {
//            System.out.println(Integer.toBinaryString(i=i<<1));
//        }
//        System.out.println();
//
//        i = -1024;
//        for (int j = 0; j < 65; j++) {
//            System.out.println(Integer.toBinaryString(i=i>>1));
//        }
//        System.out.println();
//        i = -1024;
//        for (int j = 0; j < 65; j++) {
//            System.out.println(Integer.toBinaryString(i=i>>>1));
//        }

    }
}

