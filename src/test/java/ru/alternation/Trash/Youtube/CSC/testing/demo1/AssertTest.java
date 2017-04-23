package ru.alternation.Trash.Youtube.CSC.testing.demo1;

import org.junit.Ignore;
import org.junit.Test;


import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;

public class AssertTest {

    @Test
    @Ignore
    public void demo_test() throws Exception {
        assertEquals("Hello", "Hel" + "lo");
        assertEquals(1.0, 1d / 3 + 1d / 3 + 1d / 3, 1e-10);

        assertThat("FooBar", containsString("ooooB"));
    }

    @Test
    @Ignore
    public void test_exception() throws Exception {
        try {
            "foo".charAt(100);
            fail("Expected exception not thrown");
        } catch (IndexOutOfBoundsException e) {
            assertEquals(IndexOutOfBoundsException.class, e.getClass());
            assertEquals("String index out of range: 100", e.getMessage());
        }
    }
}
