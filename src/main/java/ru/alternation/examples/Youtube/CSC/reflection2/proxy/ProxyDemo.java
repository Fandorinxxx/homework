package ru.alternation.examples.Youtube.CSC.reflection2.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class ProxyDemo {

    public static void main(String[] args) {
        Runnable runnable = (Runnable) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{Runnable.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.printf("%s(%s)%n", method.getName(), Arrays.toString(args));
                return null;
            }
        });

        runnable.run();
    }
}
