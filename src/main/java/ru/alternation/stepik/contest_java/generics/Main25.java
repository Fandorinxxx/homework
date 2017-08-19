package ru.alternation.stepik.contest_java.generics;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 # 3.25 Reflection

 https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Type.html
 You need to impement method getComparatorType(Class) in ComparatorInspector class. The method should examine
 provided class and return Type object that corresponds to the type parameter that parameterizes Comparable interface
 the class implements. Consider the example:

 ...

 The method should:
 - Return type parameter for Comparable interface class implements
 - Return null if Comparable interface does not have type parameter
 - Should not produce compile-time warnings

 Additional requirements:﻿
 - Compile-time error should arise if class not implementing Comparable is provided as input value
 - No 'rawtype' warnings should remain or be supressed
 - Method getComparatorType should be generic

 You are free to correct method's type signature if needed.

 */

public class Main25 {

    class MyInt implements Comparable<Integer> {
        // Implementation omitted
        @Override public int compareTo(Integer o) {return 0;}
    }
    class MyAnotherInt implements Serializable, Iterable<Boolean>, Comparable<Integer> {
        @Override public void forEach(Consumer<? super Boolean> action) {}
        @Override public Spliterator<Boolean> spliterator() {return null;}
        @Override public Iterator<Boolean> iterator() {return null;}
        @Override public int compareTo(Integer o) {return 0;}
    }

    class MyNoComparableInt  {}

    /**
     * Class to work with
     */
    static class ComparatorInspector { // Добавил static

        /**
         * Return Type variable that corresponds to the type parameterizing Comparator.
         *
         * @param clazz {@link Class} object, should be non null
         * @return {@link Type} object or null if Comparable does not have type parameter
         */

        public static <T extends Comparable<?>> Type getComparatorType(Class<T> clazz) {
            for (Type type : clazz.getGenericInterfaces()) {
                if (type instanceof ParameterizedType) {
                    ParameterizedType parameterizedType = (ParameterizedType) type;
                    if (parameterizedType.getRawType().getTypeName().equals(Comparable.class.getCanonicalName())) {
                        return parameterizedType.getActualTypeArguments()[0];
                    }
                }
            }
            return null;
        }

        public static <T extends Comparable<?>> Type getComparatorType2(Class<T> clazz) {

            // лол, импорты не надо писать, если указывать имя класса полностью
            return java.util.stream.Stream.of(clazz.getGenericInterfaces())
                    .filter(ParameterizedType.class::isInstance)
                    .map(type -> (ParameterizedType) type)
                    .filter(type -> type.getRawType().getTypeName().equals(
                            Comparable.class.getCanonicalName()))
                    .flatMap(type -> Arrays.asList(type.getActualTypeArguments()).stream())
                    .findFirst()
                    .orElse(null);
        }

    }


    public static void main(String[] args) {
        // Method to implement
        Type type = ComparatorInspector.getComparatorType(MyInt.class);
        type = ComparatorInspector.getComparatorType(MyAnotherInt.class);
        //Type type2 = ComparatorInspector.getComparatorType(MyNoComparableInt.class);

        System.out.println(type.getTypeName());
        // prints: java.lang.Integer since MyInt implements Comparable with Integer parameter type
    }
}
