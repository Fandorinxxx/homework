package ru.alternation.stepik.basic.section4.stage3.step8;

import java.util.logging.ConsoleHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.XMLFormatter;

/**
 В этой задаче вам нужно реализовать метод, настраивающий параметры логирования.
 Конфигурирование в коде позволяет выполнить более тонкую и хитрую настройку, чем при помощи properties-файла.

 Требуется выставить такие настройки, чтобы:

 1. Логгер с именем "org.stepic.java.logging.ClassA" принимал сообщения всех уровней.
 2. Логгер с именем "org.stepic.java.logging.ClassB" принимал только сообщения уровня WARNING и серьезнее.
 3. Все сообщения, пришедшие от нижестоящих логгеров на уровень "org.stepic.java", независимо от серьезности сообщения
 печатались в консоль в формате XML (*) и не передавались вышестоящим обработчикам на уровнях "org.stepic", "org" и "".

 Не упомянутые здесь настройки изменяться не должны.

 (*) В реальных программах мы бы конечно печатали XML не в консоль, а в файл.
 Но проверяющая система не разрешает создавать файлы на диске, поэтому придется так.

 Подсказки:

 1. Level есть не только у Logger, но и у Handler.
 2. Передача сообщения на обработку родительскому Handler'у регулируется свойством useParentHandlers.


________________________________________________________________________________________________________________________
 https://docs.oracle.com/javase/7/docs/api/java/util/logging/Level.html

 https://habrahabr.ru/post/113145/
 https://habrahabr.ru/post/247647/
 https://habrahabr.ru/post/130195/
 https://stackoverflow.com/questions/5950557/good-examples-using-java-util-logging
 https://stackoverflow.com/questions/11359187/why-not-use-java-util-logging


 http://www.dxgames.narod.ru/articles/java/logging.htm
 http://www.vogella.com/tutorials/Logging/article.html
 https://examples.javacodegeeks.com/core-java/util/logging/java-util-logging-example/

 */

public class Main {
    private static void configureLogging() {
        Logger loggerA = Logger.getLogger("org.stepic.java.logging.ClassA");
        loggerA.setLevel(Level.ALL);

        Logger loggerB = Logger.getLogger("org.stepic.java.logging.ClassB");
        loggerB.setLevel(Level.WARNING);

        Logger loggerOSJ = Logger.getLogger("org.stepic.java");
        loggerOSJ.setLevel(Level.ALL);


        Handler handler = new ConsoleHandler();
        handler.setLevel(Level.ALL);

        Formatter formatter = new XMLFormatter();
        handler.setFormatter(formatter);

        loggerOSJ.addHandler(handler);
        loggerOSJ.setUseParentHandlers(false);
    }


    //__________________________________________________________________________________________________________________

    public static void main(String[] args) {
        configureLogging();
    }
}
