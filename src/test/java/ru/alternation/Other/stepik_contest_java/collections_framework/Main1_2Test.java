package ru.alternation.Other.stepik_contest_java.collections_framework;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import static org.assertj.core.api.Assertions.assertThat;


public class Main1_2Test {
    @Test
    public void changeList() throws Exception {
        List<String> list = new ArrayList<>(Arrays.asList("hi", "hello", "goodmorning", "arr"));

        Main1_2.changeList(list);
        for (String s : list){
            assertThat(s).isEqualTo("goodmorning");
        }
    }


}