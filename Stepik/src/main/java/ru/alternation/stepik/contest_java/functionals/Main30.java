package ru.alternation.stepik.contest_java.functionals;

import java.util.stream.Collectors;

/**
 2.30 Collectors in practice: partitioning words into groups

 Write a collector that partitions all words in a stream into two groups: palindromes (true) and usual words (false).
 The collector must return Map<Boolean, List<String>>. All input words will be in the same case (lower).

 Let's remind, a palindrome is a word or phrase which reads the same backward or forward, such as noon or level.
 In our case, a palindrome is always a word. For details, see https://en.wikipedia.org/wiki/Palindrome

 Hint: the method reverse() of StringBuilder may help you.

 You should write only the collector in any valid formats but without ; on the end.
 It will be passed as the argument to the collect() method of the stream.

 Examples of the valid solution formats: Collectors.reducing(...) or reducing(...)﻿

 Sample Input 1:
 aaaa aaa a aa
 Sample Output 1:
 {false=[], true=[aaaa, aaa, a, aa]}

 Sample Input 2:
 level bbaa ac
 Sample Output 2:
 {false=[bbaa, ac], true=[level]}

 */
public class Main30 {

    public static void main(String[] args) {

        Collectors.partitioningBy((String s) -> s.equals(new StringBuilder(s).reverse().toString()))
        ;
    }
}
