package ru.alternation.examples.others.trash.test10;

public class Max2 {
    void max(Float x, Float y) {
        if (x > y) System.out.println("X - is float");
        else System.out.println("Y - is float");
    }
    void max(Double x, Double y) {
        if (x > y) System.out.println("X - is double");
        else System.out.println("Y - is double");
    }

    public static void main(String[] args) {
        Max2 max = new Max2();
        //max.max(null, null); // ! неоднозначно
    }
}
