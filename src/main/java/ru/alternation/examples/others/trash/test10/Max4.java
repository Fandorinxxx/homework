package ru.alternation.examples.others.trash.test10;

public class Max4 {
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
        Max4 max = new Max4();
        max.max(1.0f, 1.0); // один из типов double, а другой сам расширится до него ->  max(double x, double y)
        max.max(1.0f, 1.0f); // предпочтет сигнатуру с примитивным типом -> max(float x, float y)
        //max.max(1.0f, new Float(1.0)); // не понятно
        max.max(new Float(1.0), new Float(1)); //  -> max(Float x, Float y)
    }
}
