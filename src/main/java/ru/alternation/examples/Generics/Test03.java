package ru.alternation.examples.Generics;

/**
 https://youtu.be/ns8T7-nI_Ec?list=PL6jg6AGdCNaX1yIJpX4sgALBTmTVc_uOJ
 */
public class Test03 {

    public static void main(String[] args) {

        test01();

    }


    static abstract class Product<T extends Product<T>> implements Comparable<T> {
        protected String name;
        protected int price;

        boolean isSameProduct(Product p) {
            return true;
        }
        @Override
        public int compareTo(T o) {
            if (this.price == o.price)
                return 0;
            else
                return this.price > o.price ? 1 : -1;
        }

//        abstract boolean subCompare(Product p);
        abstract boolean subCompare(T p);
    }

    static class Camera extends Product<Camera> { // ! <Camera>
        private int pixel;

//        @Override
//        boolean subCompare(Product p) {
//            if (p instanceof Camera) {
//                return this.pixel > ((Camera) p).pixel;
//            }
//            throw new IllegalArgumentException("");
//        }
        @Override
        boolean subCompare(Camera p) {
            return this.pixel > p.pixel;
        }


    }

//    static class Phone extends Product {
//        private int model;
//
//        @Override
//        boolean subCompare(Product p) {
//            if (p instanceof Phone) {
//                return this.model > ((Phone) p).model;
//            }
//            throw new IllegalArgumentException("");
//        }
//    }

//    static class Container<T extends Product & Comparable<Product>> {
//        private T item;
//
//        public T getItem() {
//            return item;
//        }
//
//        public void setItem(T item) {
//            this.item = item;
//        }
//    }




    static void test01() {
    }

    static void test02() {
    }
}
