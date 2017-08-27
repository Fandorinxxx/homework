package ru.alternation.csc.testing.demo1;

import org.junit.*;

public class SequenceTest {

    private String foo;

    public SequenceTest() {
        System.err.println("constructor");
    }

    @BeforeClass
    public static void init() throws Exception {
        System.err.println("init");
    }

    @Before
    public void setUp() throws Exception {
        System.err.println("setUp");
    }

    @Test
    public void test1() throws Exception {
        System.err.println("test1");
    }

    @Test
    public void test2() throws Exception {
        System.err.println("test2");
    }

    @After
    public void tearDown() throws Exception {
        System.err.println("tearDown");
    }

    @AfterClass
    public static void finish() throws Exception {
        System.err.println("finish");
    }
}
