package ru.alternation.Trash.Others;

/**
 * Created by Alternation on 24.03.2017.
 *
 */
public class Unboxing {


    public static void main(String[] args) {


        Integer i1 = new Integer("1");
        Integer i2 = new Integer("1");
        System.out.println(i1==i2);        // false
        System.out.println(i1.equals(i2)); // true

        Integer i3 = new Integer(1);
        Integer i4 = new Integer(1);
        System.out.println(i4==i3);        // false
        System.out.println(i4.equals(i3)); // true

        Integer i5 = Integer.valueOf(1);
        Integer i6 = Integer.valueOf(1);
        System.out.println(i5==i6);        // true
        System.out.println(i5.equals(i6)); // true

        Double d1 = new Double(2.0);


        //a(i1);      // Integer !-> Double
        //a(1);       // int     !-> Double
        a(1.0);  // double  -> Double
        a(d1);      // Double  -> Double



        a2(i1);      // Integer -> double
        a2(1);    // int    -> double
        a2(1.0);  // double -> double
        a2(d1);      // Double -> double


        char c1 = 0;
        //f1(c1);   // char !-> Integer


        System.out.println();
        f2(2, 2);     // true
        f2(new Integer(2), new Integer(2));   // false
        f2(200, 200); // false

    }

    static void a(Double d){
    }

    static void a2(double d){
    }

    static void f1(Integer integer){
    }

    static void f2(Integer integer1, Integer integer2){
        System.out.println(integer1==integer2);
    }




}
