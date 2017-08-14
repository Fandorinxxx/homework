package ru.alternation.examples.Generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 https://youtu.be/MniNZsyjH9E?list=PL6jg6AGdCNaX1yIJpX4sgALBTmTVc_uOJ
 */
public class Test01 {
    public static void main(String[] args) {

        test01();
    }

    static void test00() {
        List list = new ArrayList<String>();
        list.add("hello");
        String s = (String) list.get(0);
        //Integer i = (Integer) list.get(0); // java.lang.ClassCastException

//        list.add(0);
//        String s2 = (String) list.get(1);

        class Container {
            private Object item;

            void checkItem(){
                if(item instanceof String){
                    //...
                }
            }
        }
    }

    static void test01(){

        List rawList = new ArrayList();
        List<String> list = new ArrayList<>();

        rawList = list; // ok
        list = rawList; // warning

    }
    static void test02(){

        List rawList = new ArrayList();
        List<String> list = new ArrayList<>();

        rawList = list;
        rawList.add(8); // Warning
        //list.add(8); // NO

        String s = list.get(0); // CCEx
//        Integer i = list.get(0);    // NO. нужен String
//        Integer i = rawList.get(0); // NO. нужен Object, либо кастинг
//        String s2 = rawList.get(0); // NO. нужен Object, либо кастинг


        //_______________________________
        List rawList2 = new ArrayList();
        rawList2.add(8);
        String s2 = list.get(0); // CCEx
    }

    static void test03() {
        class SomeType<T> {
            public <E> void test(Collection<E> collection) {
                for (E e : collection)
                    System.out.println(e +" <>");
            }

            public void test(List<Integer> collection) {
                collection.forEach(System.out::println);
            }
        }
        SomeType someType = new SomeType();
        //SomeType<Object> someType = new SomeType<>(); // OK // Иначе даже <E> сотрется компилятором (вся инфа о дженериках)
        //SomeType<?> someType = new SomeType<>(); // OK // или так. и дженерики заработают
        List<String> list = Arrays.asList("value");
        someType.test(list); // CCEx

        // Потому, что SomeType создан без generic типа. И компилятор думат, что:
        // public void test(Collection collection)
        // public void test(List IntegerList)

    }
}
