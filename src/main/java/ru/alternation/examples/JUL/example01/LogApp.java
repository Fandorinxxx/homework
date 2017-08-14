package ru.alternation.examples.JUL.example01;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * http://www.dxgames.narod.ru/articles/java/logging.htm
 * <p>
 * Файл лога будет в ~ C:\Users\Alternation\AppData\Local\Temp
 */
public class LogApp {
    public static void main(String[] args) {
        // Получаем экземпляр класса, который будем использовать для записи логов.
        // Передаваемый параметр LogApp - имя логера.
        // В документации сказано, что имя логгера должно совпадать с именем
        // класса или пакета ().
        Logger logger = Logger.getLogger(LogApp.class.getName());


        // Создаём handler, который будет записывать лог
        // в файл "LogApp". Символ "%t" указывает на то, что файл
        // будет располагаться в папке с системными временными файлами.
        try {

            FileHandler fh = new FileHandler("%tLogApp");
            logger.addHandler(fh);

            // Добавляем ещё файл "LogApp.htm".
            HtmlFormatter htmlformatter = new HtmlFormatter();
            FileHandler htmlFile = new FileHandler("%tLogApp.htm");
            // Устанавливаем html форматирование с помощью класса HtmlFormatter.
            htmlFile.setFormatter(htmlformatter);
            logger.addHandler(htmlFile);

        } catch (SecurityException e) {
            logger.log(Level.SEVERE,
                    "Не удалось создать файл лога из-за политики безопасности.",
                    e);
        } catch (IOException e) {
            logger.log(Level.SEVERE,
                    "Не удалось создать файл лога из-за ошибки ввода-вывода.",
                    e);
        }

        logger.log(Level.INFO, "Запись лога с уровнем INFO (информационная)");
        logger.log(Level.WARNING, "Запись лога с уровнем WARNING (Предупреждение)");
        logger.log(Level.SEVERE, "Запись лога с уровнем SEVERE (серъёзная ошибка)");
    }
}
