package ru.alternation.stepik.contest_java.collections_framework;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.NavigableMap;
import java.util.TreeMap;

import static org.assertj.core.api.Assertions.assertThat;

public class Main25Test {

    private NavigableMap<Integer, String> map = new TreeMap<>();
    private PrintStream console = System.out;
    private ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    private PrintStream printStream = new PrintStream(byteArrayOutputStream);

    @Before
    public void setUp() {
        map.put(1, "1");
        map.put(2, "2");
        map.put(3, "3");
        map.put(4, "4");
        map.put(5, "5");
        map.put(6, "6");
        map.put(7, "7");

        System.setOut(printStream);
    }

    @Test
    public void getSubMap() throws Exception {
        System.out.print(Main25.getSubMap(map));
        assertThat((byteArrayOutputStream.toString())).isEqualTo("{5=5, 4=4, 3=3, 2=2, 1=1}");
    }

    @Test // не учитывает порядок
    public void getSubMap2() throws Exception {

        TreeMap<Integer, String> origin = new TreeMap<>();
        origin.put(2, "2");
        origin.put(1, "1");
        origin.put(3, "3");
        origin.put(4, "4");
        origin.put(5, "5");

        NavigableMap<Integer, String> output = Main25.getSubMap(map);
        assertThat(output).isEqualTo(origin);
    }
    @Test
    public void getSubMap3() throws Exception {
        NavigableMap<Integer, String> output = Main25.getSubMap(map);
        assertThat(output.firstKey()).isEqualTo(5);
    }


    @After
    public void tearDown() throws Exception {
        //System.out.println("Check 1");
        System.setOut(console);
        //System.out.println("Check 2"); // печатается
    }
}