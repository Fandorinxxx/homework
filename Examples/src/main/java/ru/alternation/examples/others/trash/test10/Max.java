package ru.alternation.examples.others.trash.test10;

public class Max {
    void max(Float x, Float y) {
        if (x > y) System.out.println("X - is Float");
        else System.out.println("Y - is Float");
    }

    void max(float x, float y) {
        if (x > y) System.out.println("X - is float");
        else System.out.println("Y - is float");
    }
    void max(double x, double y) {
        if (x > y) System.out.println("X - is double");
        else System.out.println("Y - is double");
    }

    public static void main(String[] args) {
        Max max = new Max();
        max.max(1.0f, 1.0f);
    }
}
