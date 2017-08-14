package ru.alternation.stepik.basic.section2.stage4.step8;

import java.math.BigInteger;
import java.util.ArrayList;
// пакета java.util

/**
 * http://rabotaet.livejournal.com/5006.html
 *
 * В этой версии программы применяются целые числа произвольно большого
 * размера, поэтому вычисляемые значения не ограничены сверху.
 * Для кэширования вычисленных значений в ней применяется объект ArrayList
 * вместо массивов фиксированного размера. ArrayList похож на массив,
 * но может разрастаться до любого размера. Метод factorial() объявлен
 * как «synchronized», поэтому его можно смело использовать в
 * многопоточных программах. При изучении этого класса познакомьтесь
 * с java.math.BigInteger и java.util.ArrayList. Работая с версиями Java,
 * предшествующими Java 1.2, используйте Vector вместо ArrayList.
 **/
public class Test
{
    protected static ArrayList table = new ArrayList(); // создаем кэш
    static 	{ // первый элемент кэша инициализируется значением 0! = 1
        table.add(BigInteger.valueOf(1));
    }
    /** Метод factorial(), использующий объекты BigInteger,
     сохраняемые в ArrayList */
    public static synchronized BigInteger factorial(int x)
    {
        if (x<0) throw new IllegalArgumentException("x должен быть неотрицательным.");
        for(int size = table.size(); size <= x; size++)
        {
            BigInteger lastfact = (BigInteger)table.get(size-1);
            BigInteger nextfact = lastfact.multiply(BigInteger.valueOf(size));
            table.add(nextfact);
        }
        return (BigInteger) table.get(x);
    }
    /**
     * Простой метод main(), который можно использовать в качестве
     * самостоятельной тестирующей программы для нашего метода factorial().
     **/
    public static void main(String[] args)
    {
        for(int i = 0; i <= 50; i++)
            System.out.println(i + "! = " + factorial(i));
    }
}