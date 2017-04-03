package ru.alternation.Simple.section3.stage5.step7;

import java.util.Objects;

/**
 *  Можно ли переписать через анонимный класс, чтобы работало?
 *
 *  Например, это:
 *  MyDoubleUnaryOperator compose(MyDoubleUnaryOperator before)
 *
 *
 *  @see java.util.function.DoubleUnaryOperator
 */

@FunctionalInterface
public interface MyDoubleUnaryOperator {

    double applyAsDouble(double operand);



    default MyDoubleUnaryOperator compose(MyDoubleUnaryOperator before) {
        Objects.requireNonNull(before);
        return (double v) -> applyAsDouble(before.applyAsDouble(v));
    }



    default MyDoubleUnaryOperator andThen(MyDoubleUnaryOperator after) {
        Objects.requireNonNull(after);
        return (double t) -> after.applyAsDouble(applyAsDouble(t));
    }

    static MyDoubleUnaryOperator identity() {
        return t -> t;
    }
}


class Runner{
    public static void main(String[] args) {

        MyDoubleUnaryOperator d1 = new Dobl();
        MyDoubleUnaryOperator d2 = new Trpl();
        MyDoubleUnaryOperator d3 = d1.compose(d2); // (x^3)^2
        System.out.println( d3.applyAsDouble(2));

        MyDoubleUnaryOperator d4 = x -> x + 100;
        System.out.println( d4.compose(d2).applyAsDouble(2)); // (2^3) + 100
    }
}


class Dobl implements MyDoubleUnaryOperator {
    @Override
    public double applyAsDouble(double operand) {
        return operand*operand;
    }


//    @Override
//    public MyDoubleUnaryOperator compose(MyDoubleUnaryOperator before) {
//        Objects.requireNonNull(before);
//        return new MyDoubleUnaryOperator() {
//            @Override
//            public double applyAsDouble(double d) {
//                return applyAsDouble(before.applyAsDouble(d)); // StackOverflowError  -- рекурсия
//                                                               // а через super. нельзя, ибо нет наследования от Dobl
//            }
//        };
//    }

}

class Trpl implements MyDoubleUnaryOperator {
    @Override
    public double applyAsDouble(double operand) {
        return operand*operand*operand;
    }
}

