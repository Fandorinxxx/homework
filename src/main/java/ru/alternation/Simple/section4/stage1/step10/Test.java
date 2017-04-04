package ru.alternation.Simple.section4.stage1.step10;

/**
 Реализуйте метод, позволяющий другим методам узнать, откуда их вызвали.

 Метод getCallerClassAndMethodName() должен возвращать имя класса и метода, откуда вызван метод,
 вызвавший данный утилитный метод. Или null (нулевую ссылку, а не строку "null"), если метод,
 вызвавший getCallerClassAndMethodName() является точкой входа в программу, т.е. его никто не вызывал.

 Это актуально, например, в библиотеках логирования, где для каждого сообщения в логе надо выводить класс и метод,
 откуда сообщение было залогировано.


 Пример:
 ______________________________________________________
 package org.stepic.java.example;

 public class Test {
 public static void main(String[] args) {
 System.out.println(getCallerClassAndMethodName());
 anotherMethod();
 }

 private static void anotherMethod() {
 System.out.println(getCallerClassAndMethodName());
 }

 public static String getCallerClassAndMethodName() {
 // ...
 }
 }
 ______________________________________________________


 При запуске эта программа должна вывести:
 ______________________________________________________
 null
 org.stepic.java.example.Test#main
 ______________________________________________________

 P.S. При тестировании этой программы в среде разработки вы можете получить другой результат:
 вместо null в первой строчке будет напечатан какой-то посторонний класс и метод. Это связано с тем,
 что среда разработки обычно запускает не ваш класс, а свой собственный, который затем уже вызывает ваш.
 Чтобы этого избежать, запускайте программу командой "java" в командной строке.

 $ pwd
 /c/Users/Alternation/IdeaProjects/StepikJava/target/classes
 $ java ru.alternation.Simple.section4.stage1.step10.Test


 P.P.S. Эта задача в уроке про исключения не случайно :)
 */

// https://javaswing.wordpress.com/2010/01/02/stacktrace_using/
// https://ru.stackoverflow.com/questions/435173/Почему-stacktraceelement0-всегда-равен-getstacktrace

public class Test {

    public static String getCallerClassAndMethodName() {

        StackTraceElement[] ste =  Thread.currentThread().getStackTrace(); // new Throwable().getStackTrace()

//        for (StackTraceElement s : ste) {
//            System.out.println(s);
//        }

        if (ste.length < 4) {
            return null;
        }
        return ste[3].getClassName() + "#" + ste[3].getMethodName();

        // или так
//        try {
//            return ste[3].getClassName() + "#" + ste[3].getMethodName();
//        }
//        catch (ArrayIndexOutOfBoundsException e){
//            return null;
//        }

    }

    public static void main(String[] args) {
        System.out.println(getCallerClassAndMethodName());
        anotherMethod();
    }

    private static void anotherMethod() {
        System.out.println(getCallerClassAndMethodName());
        anotherMethod2();
    }
    private static void anotherMethod2() {
        System.out.println(getCallerClassAndMethodName());
    }
}
/*

Из консоли:

java.lang.Thread.getStackTrace(Unknown Source)
ru.alternation.Simple.section4.stage1.step10.Test.getCallerClassAndMethodName(Test.java:58)
ru.alternation.Simple.section4.stage1.step10.Test.main(Test.java:79)
null

java.lang.Thread.getStackTrace(Unknown Source)
ru.alternation.Simple.section4.stage1.step10.Test.getCallerClassAndMethodName(Test.java:58)
ru.alternation.Simple.section4.stage1.step10.Test.anotherMethod(Test.java:84)
ru.alternation.Simple.section4.stage1.step10.Test.main(Test.java:80)
ru.alternation.Simple.section4.stage1.step10.Test#main

java.lang.Thread.getStackTrace(Unknown Source)
ru.alternation.Simple.section4.stage1.step10.Test.getCallerClassAndMethodName(Test.java:58)
ru.alternation.Simple.section4.stage1.step10.Test.anotherMethod2(Test.java:88)
ru.alternation.Simple.section4.stage1.step10.Test.anotherMethod(Test.java:85)
ru.alternation.Simple.section4.stage1.step10.Test.main(Test.java:80)
ru.alternation.Simple.section4.stage1.step10.Test#anotherMethod



Из IDE:

java.lang.Thread.getStackTrace(Thread.java:1556)
ru.alternation.Simple.section4.stage1.step10.Test.getCallerClassAndMethodName(Test.java:58)
ru.alternation.Simple.section4.stage1.step10.Test.main(Test.java:79)
sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
java.lang.reflect.Method.invoke(Method.java:498)
com.intellij.rt.execution.application.AppMain.main(AppMain.java:147)
sun.reflect.NativeMethodAccessorImpl#invoke0

java.lang.Thread.getStackTrace(Thread.java:1556)
ru.alternation.Simple.section4.stage1.step10.Test.getCallerClassAndMethodName(Test.java:58)
ru.alternation.Simple.section4.stage1.step10.Test.anotherMethod(Test.java:84)
ru.alternation.Simple.section4.stage1.step10.Test.main(Test.java:80)
sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
java.lang.reflect.Method.invoke(Method.java:498)
com.intellij.rt.execution.application.AppMain.main(AppMain.java:147)
ru.alternation.Simple.section4.stage1.step10.Test#main

java.lang.Thread.getStackTrace(Thread.java:1556)
ru.alternation.Simple.section4.stage1.step10.Test.getCallerClassAndMethodName(Test.java:58)
ru.alternation.Simple.section4.stage1.step10.Test.anotherMethod2(Test.java:88)
ru.alternation.Simple.section4.stage1.step10.Test.anotherMethod(Test.java:85)
ru.alternation.Simple.section4.stage1.step10.Test.main(Test.java:80)
sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
java.lang.reflect.Method.invoke(Method.java:498)
com.intellij.rt.execution.application.AppMain.main(AppMain.java:147)
ru.alternation.Simple.section4.stage1.step10.Test#anotherMethod



 */
