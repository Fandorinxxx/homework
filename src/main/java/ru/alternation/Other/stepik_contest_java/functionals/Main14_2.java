package ru.alternation.Other.stepik_contest_java.functionals;

import java.io.Serializable;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 In which cases can we replace an anonymous class with a lambda expression? All interfaces from the standard java class library.

 */
public class Main14_2 {
    public static void main(String[] args) {
        //a)
        final double variable = 10;

        Serializable serializable = new Serializable() {
            double applyFun(double x) {
                return x + variable;
            }
        };

        //b)
        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(100);
                return "hello";
            }
        };

        //c)
        Future<Double> future = new Future<Double>() {
            @Override
            public boolean cancel(boolean mayInterruptIfRunning) {
                return false;
            }

            @Override
            public boolean isCancelled() {
                return false;
            }

            @Override
            public boolean isDone() {
                return false;
            }

            @Override
            public Double get() throws InterruptedException, ExecutionException {
                return null;
            }

            @Override
            public Double get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
                return null;
            }
        };

        //d)
// see NIO.2
        PathMatcher matcher = new PathMatcher() {
            @Override
            public boolean matches(Path path) {
                return false;
            }
        };
    }
}
