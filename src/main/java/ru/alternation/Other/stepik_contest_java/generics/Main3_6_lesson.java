package ru.alternation.Other.stepik_contest_java.generics;

import java.lang.reflect.ParameterizedType;
import java.util.Arrays;

public class Main3_6_lesson {
    // Generic interface
    interface GenericInterface<T> {
    }

    // Class that implements generic interface with some type argument
    class SomeClass implements GenericInterface<Boolean> {
    }

    // Let's get information on SomeClass type arguments
    public static void main(String[] args) {
        // Use getGenericInterfaces() method to retrieve list of SomeClass generic interfaces
        //    and provide them as Java 8 stream
        Arrays.stream(SomeClass.class.getGenericInterfaces())
                // Filter instances that are of ParameterizedType type and perform cast
                .filter(ParameterizedType.class::isInstance)
                .map(type -> (ParameterizedType) type)
                // Print type name
                .forEach(System.out::println);
    }
}

//        for (Type type : SomeClass.class.getGenericInterfaces()) {
//            if (type instanceof ParameterizedType) {
//                ParameterizedType parameterizedType = (ParameterizedType) type;
//                System.out.println(parameterizedType);
//            }
//        }
