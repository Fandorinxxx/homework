package ru.alternation.examples.youtube.mailru.concurrency;

import ru.alternation.examples.youtube.mailru.concurrency.interference.*;
import ru.alternation.examples.youtube.mailru.concurrency.run.*;

/**
 * http://go.teachbase.ru/course_sessions/25965/
 * https://github.com/vitaly-chibrikov/tp_java_2015_02/tree/master/L4.1
 *
 * https://www.youtube.com/watch?v=dLDhB6SRXzw&list=PLrCZzMib1e9qkzxEuU_huxtSAxrW1t9NZ&index=9
 */

public class Main {
    public static void main(String[] args) throws InterruptedException {
        RandomRunExample.example();
        SeriesRunExample.example();
        (new InterferenceExample()).example();
    }
}
