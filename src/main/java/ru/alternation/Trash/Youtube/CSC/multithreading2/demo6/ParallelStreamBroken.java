package ru.alternation.Trash.Youtube.CSC.multithreading2.demo6;

import java.util.Arrays;
import java.util.concurrent.atomic.DoubleAdder;

public class ParallelStreamBroken {

    public static void main(String[] args) {
        int[] array = Commons.prepareArray();


        long startTime = System.currentTimeMillis();

        //double[] sum = new double[1]; // bad
        DoubleAdder sum = new DoubleAdder();
        Arrays.stream(array)
                .parallel()
                .mapToDouble(Commons::function)
                //.forEach(x -> sum[0] += x);
                .forEach(sum::add);

        long endTime = System.currentTimeMillis();

        System.out.println("sum = " + sum.doubleValue());
        System.out.println("time = " + (endTime - startTime) + "ms");
    }
}
