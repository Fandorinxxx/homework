package ru.alternation.csc.testing.demo2;

import junit.framework.TestCase;

public class StringTestJUnit3 extends TestCase {

    public void testSubstringCountsCharsFrom0() {
        TestCase.assertEquals("lo", "Hello".substring(3));
    }


    public void testSubstringThrowsExceptionForInvalidIndex() {
        try {
            "".substring(1);
            TestCase.fail("Expected exception not thrown");
        } catch (StringIndexOutOfBoundsException e) {
            // pass
        }
    }

}
























