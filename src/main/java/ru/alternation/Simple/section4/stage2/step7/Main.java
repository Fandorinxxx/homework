package ru.alternation.Simple.section4.stage2.step7;

/**

 Вспомним нашего старого знакомого робота из этой задачи.
 @see ru.alternation.Simple.section3.stage3.step12.Robot
 Теперь мы будем давать роботу команды удаленно, подключаясь к нему по беспроводному каналу связи.

 Подключение к роботу представляется в программе интерфейсом RobotConnection:
 public interface RobotConnection extends AutoCloseable {
    void moveRobotTo(int x, int y);
    @Override
    void close();
 }
________________________________________________________________________________________________________________________
 Да, робот с тех пор поумнел и стал понимать команду на перемещение в заданную точку (метод moveRobotTo).
 Ему больше не нужны пошаговые инструкции. RobotConnection — это временно устанавливаемое соединение,
 которое надо закрывать, когда оно больше не нужно. Для закрытия соединения в интерфейсе есть метод close().

 За установку соединения отвечает RobotConnectionManager:
 public interface RobotConnectionManager {
    RobotConnection getConnection();
 }
________________________________________________________________________________________________________________________
 Метод getConnection() делает попытку соединиться с роботом и возвращает установленное соединение, через которое
 можно отдавать роботу команды. Установка соединения может завершиться неуспешно, а также уже установленное
 соединение может внезапно разорваться. Всякое бывает. Поэтому любой метод RobotConnectionManager и RobotConnection
 может бросить непроверяемое исключение RobotConnectionException:

 public class RobotConnectionException extends RuntimeException {

    public RobotConnectionException(String message) {
        super(message);
    }

    public RobotConnectionException(String message, Throwable cause) {
        super(message, cause);
    }
 }
________________________________________________________________________________________________________________________
 Ваша задача — реализовать метод который устанавливает соединение с роботом, отдает ему команду на перемещение в
 заданную точку и затем закрывает соединение, выполняя при необходимости повтор этой последовательности до трех раз.

 При этом:

 1. Попытка отдать команду роботу считается успешной, если удалось установить соединение и выполнить
 метод RobotConnection.moveRobotTo() без исключений. Ошибка закрытия соединения не важна и должна игнорироваться.
 2. Если первая попытка подключиться и отдать команду оказалась неуспешной, то закрываем соединение и
 выполняем вторую попытку. Если вторая тоже не удалась, то выполняется третья. После третьей неудачи метод должен
 бросить исключение RobotConnectionException.
 3. Метод отвечает за открытие и закрытие соединения. Если соединение удалось установить, то оно обязательно должно
 быть закрыто несмотря на возможные исключения, случившиеся в дальнейшем во время работы метода.
 4. Если во время работы метода случилось исключение любого типа, отличного от RobotConnectionException, метод должен
 завершиться и выбросить это исключение, не выполняя повторных попыток пообщаться с роботом. Единственное, что метод
 должен сделать перед выбросом этого исключения — закрыть открытое соединение RobotConnection.



https://habrahabr.ru/company/golovachcourses/blog/223821/
https://habrahabr.ru/company/golovachcourses/blog/225585/
https://stackoverflow.com/questions/39777022/break-doesnt-work-in-try-with-resources-but-work-in-try-without-resources
https://habrahabr.ru/post/178405/

Использование break как формы goto
http://info.javarush.ru/javarush_articles/2015/12/03/Операторы-перехода.html

 */



public class Main {

    public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) {
        boolean done = false; // внутрь for не засунуть, жаль
        int repeatCount = 3;
        for (int i = 0; i < repeatCount && !done; i++) {
            try (RobotConnection connection = robotConnectionManager.getConnection()) {
                connection.moveRobotTo(toX, toY);
                done = true; //i = 3;       //break; – так не работает – вероятно из-за возможного эксепшена из close() finally блока
            } catch (RobotConnectionException e){
                if (i == repeatCount - 1) {
                    throw e;
                }
            }
        }
    }

    // вроде, полноценная замена try-with-resources
    // лучше чем moveRobot3() // https://habrahabr.ru/post/178405/
    public static void moveRobot4(RobotConnectionManager robotConnectionManager, int toX, int toY) {
        boolean done = false;
        int repeatCount = 3;
        RobotConnection connection = null;
        RuntimeException mainException = null;
        for (int i = 0; i < repeatCount && !done; i++) {
            try {
                connection = robotConnectionManager.getConnection();
                connection.moveRobotTo(toX, toY);
                done = true;
            } catch (RobotConnectionException e){
                if (i == repeatCount - 1) {
                    mainException = e;
                    throw e;
                }
            } finally {
                try {
                    if (connection != null) {
                        connection.close();
                    }
                } catch (RobotConnectionException e){
                    if (i == repeatCount - 1) {
                        if (mainException != null) {
                            mainException.addSuppressed(e);
                            throw mainException;
                        }
                    }
                }
            }
        }
    }

    // то же самое, но без try-with-resources
    public static void moveRobot3(RobotConnectionManager robotConnectionManager, int toX, int toY) {
        boolean done = false;
        int repeatCount = 3;
        RobotConnection connection = null;
        for (int i = 0; i < repeatCount && !done; i++) {
            try {
                connection = robotConnectionManager.getConnection();
                connection.moveRobotTo(toX, toY);
                done = true;
            } catch (RobotConnectionException e){ // ловим все, но при [третьей] итерации пуляем дальше
                if (i == repeatCount - 1) {
                    throw e;
                }
            } finally {
                try {
                    if (connection != null) {
                        connection.close();
                    }
                } catch (RobotConnectionException e){
                    // а можно просто игнорировать (ибо не генерируя в finally новое исключение, "старое" после блока finally полетит дальше)
////                    if (i == repeatCount - 1) {
////                        throw e; // но это исключение из close()
////                    }
                }
            }
        }
    }

    // это тоже рабочее, сделанное максимально по пунктам условия
    // "неидеальное" решение
    public static void moveRobot2(RobotConnectionManager robotConnectionManager, int toX, int toY) {

        boolean isConnected;
        final int count = 3;
        int i = 0;

        RobotConnection connection = null;

        while (i < count) {
            i++;
            isConnected = false;
            try {
                connection = robotConnectionManager.getConnection();
                isConnected = true;
                try {
                    connection.moveRobotTo(toX, toY);
                    break;
                } catch (RobotConnectionException e) {

                }
            } catch (RobotConnectionException e) {

            } finally {
                try {
                    if (isConnected) {
                        connection.close();
                    }
                    if (i == count) {
                        throw new RobotConnectionException(""); // все-таки надо ловить(пропускать) снизу, а не создавать
                    }
                } catch (RobotConnectionException e) {
                    if (i == count) {
                        throw e;
                    }
                }
            }
        }
    }

}
