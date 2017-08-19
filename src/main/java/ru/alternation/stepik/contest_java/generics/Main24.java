package ru.alternation.stepik.contest_java.generics;

import java.lang.reflect.InvocationTargetException;

/**
 # 3.24 Reflexive Baker

 Pie company is looking for talanted baker and you are invited to implement one. The baker's duty is to get orders
 for bakery and it's varieties and produce it. Class definition and method's backbone follows:

 ...

 The task is to redesign method signature types if needed and to add implementation. The bake method should conform to the following:
 - Create objects of class Bakery or any subclass of it according to class argument
 - Flag compile-time error if order argument is not Bakery or any subclass of it (e.g. if it is Paper or Object)

 ﻿It's guaranteed that all subclasses of Bakery will have public parameterless constructor.

 */

public class Main24 {

    static class Paper {}

    static class Bakery {}

    static class Cake extends Bakery {}


    /**
     * Class to implement
     */
    static class ReflexiveBaker {

        /**
         * Create bakery of the provided class.
         *
         * @param order class of bakery to create
         * @return bakery object
         */
        public <T extends Bakery > T bake(Class<T> order) {
            // Add implementation here
            try {
                return  order.newInstance();
            } catch (Exception e) {
                return null; // required return
            }
        }

    }

    public static void main(String[] args) {
        ReflexiveBaker baker = new ReflexiveBaker();
        Cake cake = baker.bake(Cake.class);
        //baker.bake(Paper.class); // should not work
    }
}
