package ru.alternation.examples.Others.Trash.Test03;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static java.lang.Double.*;

/**
 * Пишите компараторы правильно
 * https://habrahabr.ru/post/247015
 */


class DoubleHolder implements Comparable<DoubleHolder> {
    double d;

    public DoubleHolder(double d) {
        this.d = d;
    }

//    @Override
//    public int compareTo(DoubleHolder o) {
//        return d > o.d ? 1 : d == o.d ? 0 : -1;
//    }
    public int compareTo(DoubleHolder o) {
        return Double.compare(d, o.d);
    }

    @Override
    public String toString() {
        return String.valueOf(d);
    }
}

public class Main {


    public static void main(String[] args) {

        List<DoubleHolder> data = new ArrayList<>();
        for(int i=1; i<=10; i++) {
            data.add(new DoubleHolder(i));
        }
        data.add(new DoubleHolder(Double.NaN));

        for(int i=0; i<10; i++) {
            Collections.shuffle(data);
            Collections.sort(data);
            System.out.println(data);
        }


        // https://habrahabr.ru/post/247015/#comment_8203417
        double[] doubles = {POSITIVE_INFINITY, NEGATIVE_INFINITY, -1, 0, 1, -0.0, +0.0, NaN};
        Arrays.sort(doubles);
        //System.out.println(doubles);// [D@677327b6
        System.out.println(Arrays.toString(doubles)); //[-Infinity, -1.0, -0.0, 0.0, 0.0, 1.0, Infinity, NaN]
        System.out.println();
    }
}
