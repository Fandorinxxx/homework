package ru.alternation.stepik.basic.section6.stage2;

import ru.alternation.stepik.basic.section6.stage1.Hack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
@see ru.alternation.examples.Others.Trash.Test06.Main
@see ru.alternation.stepik.basic.section6.stage1.Hack
@see ru.alternation.stepik.basic.section6.stage1.Example
@see ru.alternation.stepik.basic.section6.stage1.step12.Pair
 */
public class Example {
    public static void main(String[] args) {

        // TAGS: Дженерики Generics

        Collection<?> collection = new ArrayList<>(); // <? extends Object> // т.е. тут может быть любой подтип Object, и не известно какой. поэтому низя присваивать
        Object object = new Object();
        collection.iterator();
        collection.toArray();
        collection.size();
        //collection.addAll(Arrays.asList(object));
        collection.remove(object);
        //collection.add(object);
        collection.add(null); // можно
        collection.clear();
        collection.contains(object);
        /*
        Вопросительный знак говорит компилятору: коллекция чем-то параметризована, но в данном месте кода мы не знаем, чем именно.
        Чтобы не дать нам случайно нарушить параметризацию коллекции, т.е. добавить в нее объект неправильного класса, компилятор не разрешает ничего добавлять.

        разрешает добавить null.
         */

        Collection<? super Object> collection2 = new ArrayList<>(); // тут в коллекции либо Object, либо супертип (такого нет) и можем присвоить любой подтип Object'а.
        collection2.addAll(Arrays.asList(object));
        collection2.add(object);
        collection2.add("gh");

        Collection<? super CharSequence> collection3 = new ArrayList<>(); // тут в коллекции либо CharSequence, либо его супертип (не факт), поэтому можем присвоить любой подтип CharSequence'а.
        //collection3.addAll(Arrays.asList(object));
        //collection3.add(object);
        collection3.add("gh"); // String -- подтип CharSequence

        Collection<? extends Integer> collection4 = new ArrayList<>();
        //collection4.addAll(Arrays.asList(object));
        //collection4.add(object);
        //collection4.add(4.3);
        //collection4.add(new Integer(3));
        for (Integer i : collection4) { // зато можно работать через базовый класс/интерфейс с его наследниками
            System.out.println(i.doubleValue());
        }
        // Поскольку может быть подтип (не известно какой) Integer, а подтипу нельзя пристваить ссылку на более общий класс

    }
}
