package ru.alternation.stepik.contest_java.generics;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 # 3.22 Instance Testing

 You are asked to create quality control system in a company that produces and packs Bakery,
 the snippet of main classes follows:

 ...

 Implement check method in a way it would:

 - Return true if
        all objects in all boxes belong to class Bakery or its subclasses
        or list contains no boxes
 - Return false otherwise, including cases when
        Box is empty
        or List contains something that is not Box at all
 The method shouldn't throw any exceptions.

 */



public class Main22 {

    // These and its sublasses should pass quality check
    static class Bakery {}

    static class Cake extends Bakery {}

    // And this and other stuff should not
    static class Paper {}

    // These boxes are used to pack stuff
    interface Box<T> {
        void put(T item);
        T get();
    }

    static class concreteBox<T> implements Box<T> {

        private T item;

        public concreteBox(T item) {
            this.item = item;
        }

        @Override
        public void put(T item) {
            this.item = item;
        }

        @Override
        public T get() {
            return this.item;
        }
    }

    // Class you need to work on
    static class QualityControl {


        public static boolean check(List<Box<? extends Bakery>> boxes) {
            // Add implementation here

            boolean result = true;

            try {
                for (Box<? extends Bakery> box : boxes) {
                    Bakery item = box.get();
                }
            } catch (ClassCastException | NullPointerException e) {
                result = false;
            }

            return result;
        }

        // тоже норм
        public static boolean check3(List<Box<? extends Bakery>> boxes) {
            //if (boxes.isEmpty()) {
            //    return true;
            //}
            for (Object box : boxes) {
                if (!(box instanceof Box)) {
                    return false;
                } else if (!(((Box) box).get() instanceof Bakery)) {
                    return false;
                }
            }
            return true;
        }


//        public static boolean check2(List<Box<? extends Bakery>> boxes) {
//
//            for (Box box : boxes) {
//                Object item = box.get();
//                //item = box;
//
//
//                System.out.println(item);
//                //System.out.printf("%x\n", item.hashCode()); // == Integer.toHexString(item.hashCode())
//                System.out.println(item.getClass());
//                System.out.println(item.getClass().getGenericSuperclass());
//                System.out.println(item.getClass().getSuperclass());
//
//
//                System.out.println();
//            }
//            return true;
//        }

        //public static void test() {}

    }

    public static void main(String[] args) {
        Box<? extends Bakery> box1 = new concreteBox<>(new Bakery());
        Box<? extends Bakery> box2 = new concreteBox<>(new Cake());
        Box box3 = new concreteBox<>(new Paper());

        //List<Box<? extends Bakery>> list = Arrays.asList(
        List list = Arrays.asList(
                box1,
                box2,
                box3,
                new concreteBox(new Paper()),
                new String("str"),
                null
        );
        //Collections.shuffle(list);

        System.out.println(QualityControl.check(list));
        System.out.println(QualityControl.check3(list));

    }
}
