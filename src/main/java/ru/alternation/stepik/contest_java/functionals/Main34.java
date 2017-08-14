package ru.alternation.stepik.contest_java.functionals;

import java.util.stream.LongStream;

/**
 2.34 Parallel filtering of prime numbers

 Create a parallel LongStream for filtering prime numbers in the given range (inclusively).

 The static method NumberUtils.isPrime(...some long number...) will be available for you during testing.
 It returns true if the passed value is prime and false otherwise.

 IMPORTANT: You need return a prepared parallel stream from the template. After calling count() it should return
 the count of prime numbers in the given range. Pay attention to the method template. Do not change it.

 PS: It's not a very efficient approach for generating prime numbers, it's just an example of parallel streams.

 */
public class Main34 {

    public static LongStream createPrimesFilteringStream(long rangeBegin, long rangeEnd) {
        return LongStream.rangeClosed(rangeBegin, rangeEnd)
                .parallel()
                .filter(NumberUtils::isPrime);
    }

    public static void main(String[] args) {

    }

    static class NumberUtils{
        static boolean isPrime(long value){
            return true;
        }

    }
}
