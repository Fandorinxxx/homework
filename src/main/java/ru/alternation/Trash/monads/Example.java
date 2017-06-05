package ru.alternation.Trash.monads;

import ru.alternation.Trash.monads.monads.Try;
import java.util.Random;

/**
 * http://mrbool.com/getting-started-with-java-monads/34302
 * http://www.baeldung.com/java-8-sort-lambda
 */
public class Example {

    public static Try<Integer> sum(int a, int b) {
        int result = a + b;
        if(new Random().nextInt(2) % 2 == 0) {
            return Try.failure(new RuntimeException("Error"));
        }
        return Try.successful(result);
    }

    public static void main(String[] args) {

        Try<Integer> result = sum(2, 3);
        if(result.isSuccess()) {
            result.onSuccess(r -> System.out.println("Sum = " + r));
        } else {
            result.onFailure(ex -> System.out.println(ex.getMessage()));
        }
    }
}