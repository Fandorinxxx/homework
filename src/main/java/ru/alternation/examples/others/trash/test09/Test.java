package ru.alternation.examples.others.trash.test09;

public class Test {

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MAX_VALUE+1);
        System.out.println(Integer.MAX_VALUE+Integer.MAX_VALUE);

        System.out.println((char)Character.MAX_VALUE);

        System.out.println((int) (char) Character.MAX_VALUE);
        System.out.println((int) (char)(Character.MAX_VALUE+1));
        System.out.println((int) (char)(Character.MAX_VALUE+Character.MAX_VALUE));
    }

}
