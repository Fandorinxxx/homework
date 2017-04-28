package ru.alternation.Other.stepik_contest_java.functionals;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 2.22 Bad words detecting

 Create a stream that will detect bad words in a text according to a bad words list. All words in the text are divided
 by whitespaces (always only one whitespace between two words).

 After calling collect(Collectors.toList()) the stream must return the list of bad words which were found in the text.
 The result list should be dictionary ordered (in lexicographical order) and bad words shouldn't repeat.

 IMPORTANT: You need return a prepared stream from the template method, not a list of bad words. Pay attention to
 the method template. Do not change it!
 */
public class Main22 {

    public static Stream<String> createBadWordsDetectingStream(String text, List<String> badWords) {
        return Arrays.stream(text.split(" "))
                .filter(badWords::contains)
                //.filter(s -> badWords.stream().anyMatch(bads -> bads.equals(s)))
                .sorted()
                .distinct();
    }

    public static void main(String[] args) {
        String s = "негр ни__ер черный афроамериканец шоколадный ни_а черный ни__ер";
        createBadWordsDetectingStream(s, Arrays.asList("ни__ер", "ни_а")).forEach(System.out::println);
    }
}
