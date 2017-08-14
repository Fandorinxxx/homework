package ru.alternation.examples.Youtube.CSC.testing.demo1;

import org.junit.Assume;
import org.junit.Test;

public class AssumeTest {

    @Test
    public void test() throws Exception {
        Assume.assumeTrue(System.getProperty("os.name").toLowerCase().contains("win"));
    }
}
