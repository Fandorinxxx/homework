package ru.alternation.examples.others.trash.test12;

import java.util.IdentityHashMap;
import java.util.Map;


/**
 * Состояние в интерфейсе
 * https://habrahabr.ru/company/jugru/blog/336864/
 */

interface StateInterface
{
    Map<StateInterface, Integer> states = new IdentityHashMap<>();

    default int getState()
    {
        return states.getOrDefault(this, 0);
    }

    default void setState(int state)
    {
        states.put(this, state);
    }
}

public class Test {
    public static void main(String[] args) {
        StateInterface stateInterface1 = new StateInterface() {};
        StateInterface stateInterface2 = new StateInterface() {};
        stateInterface1.setState(777);
        System.out.println(stateInterface1.getState());
        System.out.println(stateInterface2.getState());
    }
}