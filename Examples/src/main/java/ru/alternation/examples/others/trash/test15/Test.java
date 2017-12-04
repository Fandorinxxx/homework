package ru.alternation.examples.others.trash.test15;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Test {
    public static void main(String[] args) {

    }

    // https://stackoverflow.com/questions/5763750/why-we-cant-do-listparent-mylist-arraylistchild

    public static <T extends Number> void test() {
        List<Integer> list = new ArrayList<>();
        list.add(2);

        //Collection<T> collection = list; // нельзя
        Collection<T> collection2 = new ArrayList<>();
        Collection<T> collection3 = (Collection<T>) list; // unchecked cast
        //collection2.add(0);  // нельзя
        collection2.size();

    }
    public static <T extends Number> void test2(Collection<T> collection) {
        //collection.add(0);   // нельзя
        //collection.add(2.0); // нельзя
    }

    static List<Integer> slist = new ArrayList<>();

    public static <T extends Number> void  test3() {
        //Collection<T> list1 = slist;  // нельзя
        Collection<? extends Number> list2 = slist;
    }

}