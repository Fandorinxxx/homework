package ru.alternation.Trash.Others;


public class Test {


    public static void main(String[] args) {






        int i;

        i=101;
        System.out.println(Integer.toBinaryString( i));
        i=127;
        System.out.println(Integer.toBinaryString( i));


        i<<=32;
        System.out.println(Integer.toBinaryString( i));
        System.out.println(i);

        i>>=32;
        System.out.println(Integer.toBinaryString( i));
        System.out.println(i);

        i>>>=5;
        System.out.println(Integer.toBinaryString( i));
        System.out.println(i);







//        byte b = -128;
//        System.out.println(Integer.toBinaryString( b));
//        System.out.println((byte)(--b));
//        System.out.println(Integer.toBinaryString(b));







    }


}
