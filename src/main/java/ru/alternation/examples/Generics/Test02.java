package ru.alternation.examples.Generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 https://youtu.be/pezRhckJbFE?list=PL6jg6AGdCNaX1yIJpX4sgALBTmTVc_uOJ
 */
public class Test02 {
    public static void main(String[] args) {

        test01();

    }

    static void test01(){
        List<String> lstr = new ArrayList<>();
        //List<Object> lobj = lstr; // compile error
    }


    static void test02(){
     List<String> stringList = new ArrayList<>();
     Set<String>  stringSet = new HashSet<>();
     List<Object> objectList = new ArrayList<>();

     print(stringList);
     print(stringSet);
     //print(objectList); // compile error

    }
    static void print(Collection<String> list) {
        list.forEach(System.out::println);
    }



    static class Product {
        private String name;
        private int price;
        boolean isSameProduct(Product p){ return true;}
    }
    static class Camera extends Product implements Comparable<Camera> { // ! <Camera>
        private int pixel;
        @Override
        public int compareTo(Camera o) {
            return 0;
        }
    }
    static class Phone extends Product{
        private int model;
    }
    static class Container<T extends Product & Comparable<T>>{
        private T item;
        public T getItem() {
            return item;
        }
        public void setItem(T item) {
            this.item = item;
        }
    }

    static void test03() {
//        Container<Product> c1 = new Container<Product>();
//        c1.setItem(new Phone());
//        c1.setItem(new Camera());

        Container<Camera> c2;
        //Container<Phone> c3; // err
        //Container<String> c2 = new Container<String>(); // из-за <T extends Product>

}
    static boolean find(List<Product> all, Product p) {
        for (Product sp : all){
            if(sp.isSameProduct(p)){
                return true;}
        }
        return false;
    }

    static boolean find2(List<? extends Product> all, Product p) {return false;}
    static <T extends Product> boolean find3(List<T> all, T p) {return false;}

    static void test04(){
        List<Camera> cameras = new ArrayList<Camera>(){{add(new Camera());}};
        //find(cameras, new Camera()); // compile err - List<Product> != List<Camera>
        find2(cameras, new Camera());
        find2(cameras, new Phone());
        find2(cameras, new Product());

        find3(cameras, new Camera());
//        find3(cameras, new Phone()); // NO
//        find3(cameras, new Product()); // NO


    }


    static void copy(List<? extends Product> src, List<? super Product> dest){
        for (Product p : src){
            dest.add(p);
        }
    }
//__________________________________________________________________________________________________________

    static void test05(){}
}
