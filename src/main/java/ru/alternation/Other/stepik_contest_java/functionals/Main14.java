package ru.alternation.Other.stepik_contest_java.functionals;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Comparator;
import java.util.Iterator;

/**
 In which cases can we replace an anonymous class with a lambda expression?
 All interfaces from the standard java class library.
 */
public class Main14 {
    public static void main(String[] args) {

        //a)
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello!");
            }
        });

        //b)
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareTo(s2);
            }
        };

        //c)
        Iterator<Integer> iterator = new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public Integer next() {
                return 0;
            }
        };
        //d)
// see Swing
        JButton button = new JButton("Click me");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button clicked");
            }
        });

    }
}
