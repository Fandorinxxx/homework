package ru.alternation.Trash.Others;

import java.math.BigInteger;
import java.util.stream.Stream;

public class FibStream {
        public static void main(String[] args) {

            Stream<BigInteger> s = Stream.iterate(new BigInteger[]{BigInteger.ZERO, BigInteger.ONE},
                    fib -> new BigInteger[]{fib[1], fib[0].add(fib[1]) })
                    .map(bigIntegers -> bigIntegers[0]);

            System.out.println(s.skip(100).findFirst()
                    .orElse(new BigInteger("-1")));

        }
}
