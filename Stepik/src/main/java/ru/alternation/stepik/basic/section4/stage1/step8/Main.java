package ru.alternation.stepik.basic.section4.stage1.step8;

/**
 Допустим, в программе используется следующее приведение типа:

 A a = (A) b;
 где A — имя какого-то класса, a и b — переменные.
 Если компилятор сможет сразу определить, что такое приведение невозможно, то компиляция завершится ошибкой.
 Однако не всегда компилятор может это сделать, т.к. фактический объект, находящийся по ссылке b,
 на момент компиляции не известен.
 Поэтому иногда такой код может успешно скомпилироваться, но упасть с ошибкой во время исполнения.

 Какое исключение выбросит JVM, если во время выполнения программы окажется, что ссылка b не может быть приведена к типу A?

 Введите полное имя класса исключения, включая пакет, например, com.example.FooBarException

 P.S. Эта задача предполагает проведение небольшого эксперимента. В лекциях нет ответа на этот вопрос. */

public class Main {
    public static void main(String[] args) {

        method1(new B());

//        или
//        Object o = 5; //new Integer(5);
//        String s = (String)o;
    }

    static void method1(Object b){
        A a = (A) b;
    }

    static class A{}
    static class B{}
}
/*
Exception in thread "main" java.lang.ClassCastException: Main$B cannot be cast to Main$A
	at Main.method1(Main.java:30)
	at Main.main(Main.java:22)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:498)
	at com.intellij.rt.execution.application.AppMain.main(AppMain.java:147)
 */
