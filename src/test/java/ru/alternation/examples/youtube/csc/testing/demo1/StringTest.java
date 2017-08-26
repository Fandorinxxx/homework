package ru.alternation.examples.youtube.csc.testing.demo1;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class StringTest {

    @Test
    public void substring_should_count_chars_from_0() {
        assertEquals('H', "Hello".charAt(0));
    }


    @Test(expected = StringIndexOutOfBoundsException.class)
    public void substring_should_throw_exception_for_invalid_index() {
        "".substring(1);
    }

    @Test
    public void substring_should_throw_exception_for_invalid_index_2() {
        try{
            "".substring(1);
            fail("Expected exception not thrown");
        } catch (Exception e){
            // pass
        }
    }


    @Test(timeout = 1000L)
    @Ignore // Для пропуска теста
    public void should_finish_in_1_second() throws Exception {
        Thread.sleep(2000L);
    }
}

























