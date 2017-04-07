package ru.alternation.Trash.JUL;

import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Alternation on 07.04.2017. *
 */
public class Test01 {

    public static void main(String[] args) {

        //Logger logger = Logger.getLogger(Main.class.getName());
        Logger logger = Logger.getLogger("ru.alternation.Trash.JUL");
        logger.setLevel(Level.ALL);
        Handler handler = new ConsoleHandler();
        handler.setLevel(Level.ALL); // иначе Level.INFO по умолчанию.
        logger.addHandler(handler);

        for (Handler h : logger.getHandlers()){
            System.out.println(h.getLevel());
        }
        logger.fine("тестинг");
        //______________________________________________________________________________________________________________


        Logger logger2 = Logger.getLogger("ru.alternation.Trash");
        logger2.setLevel(Level.ALL);

        // пусто
        for (Handler h : logger2.getHandlers()){
            System.out.println(h.getLevel());
        }

        Handler handler2 = new ConsoleHandler();
        handler2.setLevel(Level.ALL); // иначе Level.INFO по умолчанию.
        logger2.addHandler(handler2);

        logger2.fine("тестинг2");
        logger.fine("тестинг3");  // выведут два логера

        logger.setUseParentHandlers(false);
        logger.fine("тестинг4");  // выведет только первый
    }
}
