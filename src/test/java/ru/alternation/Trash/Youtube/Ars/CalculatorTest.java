package ru.alternation.Trash.Youtube.Ars;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * https://youtu.be/rTvOSS99-y8?list=PLW8mAQ8rFUhKFkuXDTb3PT1GKz0T-lCv6
 */

public class CalculatorTest {
    @Test
    public void testAdd() throws Exception {
        Calculator calculator = new Calculator();
        calculator.add(1, 1);
        assertEquals(2, calculator.getResult());
    }

    @Test(expected = UserException.class)
    public void divException() throws Exception {
        Calculator calculator = new Calculator();
        calculator.div();
    }
    @Test()
    public void divOneArg() throws Exception {
        Calculator calculator = new Calculator();
        calculator.div(2);
        assertEquals(2, calculator.getResult());
    }

    @Test(expected = IllegalArgumentException.class)
    public void divRuntimeException() throws Exception {
        Calculator calculator = new Calculator();
        calculator.div(5,0);
    }
}




































