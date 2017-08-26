package ru.alternation.examples.others.trash.test07;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;


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


        List<Number> numbers = Collections.<Number>unmodifiableList(new ArrayList<Integer>());


        //Integer[] zz = new Integer[]{};




        new Z().apply();
        S s = new Z();
        s.apply();
        A a = new Z();
        a.apply();




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

