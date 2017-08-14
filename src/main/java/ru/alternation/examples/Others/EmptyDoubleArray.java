package ru.alternation.examples.Others;


public class EmptyDoubleArray {
    static final int  BUFSIZE = 10;

    static byte [][] buf1 = new byte [BUFSIZE][2]; // 10 ссылок на массивы из 2 элементов
    static byte [][] buf2 = new byte [BUFSIZE][1]; // 10 ссылок на массивы из 1 элементы
    static byte [][] buf3 = new byte [BUFSIZE][0]; // 10 ссылок на массивы нулевой длины
    static byte [][] buf4 = new byte [BUFSIZE][];  // вместо ссылок на массив содержит null

    //static byte [] buf5 = new byte []; // низя
    static byte [] buf6 = {};
    static byte [] buf7 = new byte [0];




    public static void main(String[] args)  {


//        System.out.println(buf3[0][0]); // NullPointerException
//        System.out.println(buf3[0]);      // [B@677327b6
//        System.out.println(Arrays.toString(buf3));      // [[B@677327b6, [B@14ae5a5, [B@7f31245a, [B@6d6f6e28, [B@135fbaa4, [B@45ee12a7, [B@330bedb4, [B@2503dbd3, [B@4b67cf4d, [B@7ea987ac]
//        System.out.println(Arrays.deepToString(buf3));  // [[], [], [], [], [], [], [], [], [], []]



//        printDoubleArray(buf1);
//        printDoubleArray(buf2);
//        printDoubleArray(buf3);
        printDoubleArray(buf4);

//        System.out.println(Arrays.deepToString(buf1));
//        System.out.println(Arrays.deepToString(buf2));
//        System.out.println(Arrays.deepToString(buf3));
//        System.out.println(Arrays.deepToString(buf4));


//        System.out.println("buf6.length = " + buf6.length + "\n" + buf6);
//
//        System.out.println(Arrays.toString(buf6));
//        printArray(buf6);


//        System.out.println(Arrays.equals(buf6, buf7)); // true

    }

    static void printDoubleArray(byte [][] buf){
        for (int i = 0; i < buf.length; i++) {
            System.out.println(buf[i]);
//            for (int j = 0; j < buf[i].length; j++) { // с buf4 вызовет NullPointerException
//                System.out.println(buf[i][j]);
//            }
        }
        System.out.println("_________________");
    }

    static void printArray(byte [] buf){
        for (int i = 0; i < buf.length; i++) {
            System.out.println(buf[i]);
        }
        System.out.println("_________________");
    }



}
