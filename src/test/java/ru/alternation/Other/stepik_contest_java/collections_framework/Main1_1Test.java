package ru.alternation.Other.stepik_contest_java.collections_framework;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

//import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.*;


public class Main1_1Test {
    private List<Integer> list1;
    private List<Integer> list2;

    @Before
    public void setUp() {
         list1 = Arrays.asList(362, 348, 270, 662, 236, 658, 202, 282, 337, 254);
         list2 = Arrays.asList(-67,0,-5645,-764);

    }

    void testFirstList(){
        Integer max = Main1_1.maxElem(list1);
        //assertEquals(662, (int)max);
        assertThat(max).isEqualTo(662);
    }
    void testSecondList(){
        assertThat(Main1_1.maxElem(list2)).isEqualTo(0);
    }


    @Test
    public void maxElem()  {
        testFirstList();
        testSecondList();
    }

    @Test
    public void maxElem2() throws Exception {
        testFirstList();
        testSecondList();
    }

    @Test
    public void maxElem3() throws Exception {
        testFirstList();
        testSecondList();
    }

    @Test
    public void maxElem4() throws Exception {
        testFirstList();
        testSecondList();
    }

    @Test
    public void maxElem5() throws Exception {
        testFirstList();
        testSecondList();
    }

    @Test
    public void maxElem6() throws Exception {
        testFirstList();
        testSecondList();
    }

    @Test
    public void maxElem7() throws Exception {
        testFirstList();
        testSecondList();
    }

    @Test
    public void maxElem8() throws Exception {
        testFirstList();
        testSecondList();
    }


}