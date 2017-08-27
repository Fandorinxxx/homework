package ru.alternation.stepik.basic.section3.stage4.step9;


/**
 Дан класс ComplexNumber. Переопределите в нем методы equals() и hashCode() так,
 чтобы equals() сравнивал экземпляры ComplexNumber по содержимому полей re и im,
 а hashCode() был бы согласованным с реализацией equals().

 Реализация hashCode(), возвращающая константу или не учитывающая дробную часть re и im, засчитана не будет


 Пример

 ComplexNumber a = new ComplexNumber(1, 1);
 ComplexNumber b = new ComplexNumber(1, 1);
 // a.equals(b) must return true
 // a.hashCode() must be equal to b.hashCode()


 Подсказка 1. Поищите в классе java.lang.Double статический метод, который поможет в решении задачи.
 Подсказка 2. Если задача никак не решается, можно позвать на помощь среду разработки,
 которая умеет сама генерировать equals() и hashCode().
 Если вы воспользовались помощью IDE, то разберитесь, что было сгенерировано и почему оно выглядит именно так.
 Когда вас на собеседовании попросят на бумажке реализовать equals() и hashCode() для какого-нибудь простого класса,
 то среда разработки помочь не сможет.
 */

// Вопросы и ответы на собеседовании по теме Java Collection Framework. Часть 2.
// http://www.parshinpn.pro/content/voprosy-i-otvety-na-sobesedovanii-po-teme-java-collection-framework-chast-2

//Пишите компараторы правильно
//https://habrahabr.ru/post/247015/


public final class ComplexNumber {

    private final double re;
    private final double im;

    public ComplexNumber(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public double getRe() {
        return re;
    }

    public double getIm() {
        return im;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
//        if (o instanceof ComplexNumber){  // лучше использовать  getClass() == o.getClass() + проверка на null
//            ComplexNumber other = (ComplexNumber)o;
//            return other.re == this.re && other.im == this.im; // Double.compare() // https://habrahabr.ru/post/247015/
//        }
//        return false;

        if (o == null || this.getClass() != o.getClass())
            return false;
        ComplexNumber obj = (ComplexNumber)o;

        return Double.compare(obj.im, this.im) == 0
                && Double.compare(obj.re, this.re) == 0;
    }


   @Override
   public int hashCode() {
        final int PRIME = 31;
        int result = 1;
        result = result*PRIME + Double.hashCode(re);
        result = result*PRIME + Double.hashCode(im);
        return result;
   }


 //==== IDEA Alt+Insert =====================================

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        ComplexNumber that = (ComplexNumber) o;
//
//        if (Double.compare(that.re, re) != 0) return false;
//        return Double.compare(that.im, im) == 0;
//    }
//
//    @Override
//    public int hashCode() {
//        int result;
//        long temp;
//        temp = Double.doubleToLongBits(re);
//        result = (int) (temp ^ (temp >>> 32));
//        temp = Double.doubleToLongBits(im);
//        result = 31 * result + (int) (temp ^ (temp >>> 32));
//        return result;
//    }

//=== IDEA Alt+Insert Java 7+ =============================

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        ComplexNumber that = (ComplexNumber) o;
//        return Double.compare(that.re, re) == 0 &&
//                Double.compare(that.im, im) == 0;
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(re, im); // Arrays.hashCode(re, im);
//    }

    public static  void main(String args[]) {

        ComplexNumber a = new ComplexNumber(1, 1);
        ComplexNumber b = new ComplexNumber(1, 1);
        System.out.println(a.equals(b));
        System.out.println(a.hashCode() == b.hashCode());
    }


}