package ru.alternation.examples.others.trash.test17;

/**
 https://www.youtube.com/watch?v=AtzHvKYWRM8
 С какой вероятностью при разбитии на 3 частя прямой из получившиъся отрезков можно собрать треугольгик?

 Т.е. надо, чтобы одна точка была в левом диапазоне, а другая в правом. И при этом, чтобы расстояние между
 точками было не больше половины длины изначальной прямой.


 */
public class Main {
    public static void main(String[] args) {

        int first, second;
        int trueCounter  = 0,
            falseCounter = 0;

        final int RANGE = 10_000;
        final int HALF = RANGE/2;
        final int COUNT = 1_000_000;

        for (int i = 0; i < COUNT; i++) {
            first  = (int) (Math.random() * (RANGE + 1)); // + 1 – для строгого диапазона
            second = (int) (Math.random() * (RANGE + 1));

            if (first <= HALF && second <= HALF || first >= HALF && second >= HALF) {
                falseCounter++;
            } else if (Math.max(first, second) - Math.min(first, second) >= HALF) {
                falseCounter++;
            }
        }
        trueCounter = COUNT - falseCounter;


        System.out.println(trueCounter + " " + falseCounter);
        System.out.println(((double)trueCounter)/COUNT*100 + " %"); // Примерно 25 %
    }
}
