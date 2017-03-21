package ru.alternation.Simple.section3.stage3.step12;


/**
 * Пакеты
 * https://ru.wikipedia.org/wiki/Package_(Java)
 * https://pr0java.blogspot.ru/2015/06/java.html
 *
 * Массивы
 * http://info.javarush.ru/javarush_articles/2015/12/10/Java-массивы.html
 *
 ** Как хранится заголовок объекта в памяти + свойство lenght у массива
 * http://info.javarush.ru/javarush_articles/2015/12/10/Java-массивы.html#comment66098
 *
 ** Перечисления с наследованием и методами.
 * http://www.quizful.net/post/java_enums
 *
 * Вложенные и внутренние классы
 * http://developer.alexanderklimov.ru/android/java/innerclass.php
 * http://www.quizful.net/post/inner-classes-java
 * http://easy-code.ru/lesson/java-nested-classes
 * https://ru.stackoverflow.com/questions/44069/Вложенные-классы



 На игровом поле находится робот. Позиция робота на поле описывается двумя целочисленным координатами: X и Y.
 Ось X смотрит слева направо, ось Y — снизу вверх. (Помните, как рисовали графики функций в школе?)

 В начальный момент робот находится в некоторой позиции на поле.
 Также известно, куда робот смотрит: вверх, вниз, направо или налево.
 Ваша задача — привести робота в заданную точку игрового поля.

 Робот описывается классом Robot. Вы можете пользоваться следующими его методами (реализация вам неизвестна):



 ____Пример_______________________________________________________________________________________________

 В метод передано:
    toX == 3,
    toY == 0;
 начальное состояние робота такое:
    robot.getX() == 0,
    robot.getY() == 0,
    robot.getDirection() == Direction.UP

 Чтобы привести робота в указанную точку (3, 0), метод должен вызвать у робота следующие методы:
    robot.turnRight();
    robot.stepForward();
    robot.stepForward();
    robot.stepForward();

 _________________________________________________________________________________________________________
 P.S. Если вам понравилось это задание, то вам может прийтись по душе игра Robocode,
 http://robocode.sourceforge.net/
 в которой надо написать алгоритм управления танком.
 Алгоритмы, написанные разными людьми, соревнуются между собой.
 */


public class Robot {

    // Direction, направление взгляда робота,  — это перечисление:
    // Как это выглядит: https://ucarecdn.com/54490c3b-9a32-4f7b-85c2-efd12455b5c0/

    // Must read
    // http://www.quizful.net/post/java_enums
    public enum Direction {
        UP{
            Direction turnLeft(){
                return LEFT;
            }
            Direction turnRight(){
                return RIGHT;
            }
        },
        DOWN{
            Direction turnLeft(){
                return RIGHT;
            }
            Direction turnRight(){
                return LEFT;
            }
        },
        LEFT{
            Direction turnLeft(){
                return DOWN;
            }
            Direction turnRight(){
                return UP;
            }
        },
        RIGHT{
            Direction turnLeft(){
                return UP;
            }
            Direction turnRight(){
                return DOWN;
            }
        };

        abstract  Direction turnLeft();
        abstract  Direction turnRight();
    }

    private int x = 0;
    private int y = 0;
    private Direction direction = Direction.UP;

    public Direction getDirection() {
        return direction;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void turnLeft() {
        direction = direction.turnLeft();
    }

    public void turnRight() {
        direction = direction.turnRight();
    }

    public void stepForward() {
        // шаг в направлении взгляда
        // за один шаг робот изменяет одну свою координату на единицу

        switch (direction){
            case UP:
                y++; break;
            case DOWN:
                y--; break;
            case RIGHT:
                x++; break;
            case LEFT:
                x--; break;
            default:
                System.out.println("Error");
        }
    }


//========= the answer =============================v

    private static void smartTurn(Robot robot, Direction desireDirection){

        while (robot.getDirection() != desireDirection) {

            if (desireDirection == Direction.RIGHT) {
                if (robot.getDirection() == Direction.DOWN) {
                    robot.turnLeft();
                } else {
                    robot.turnRight();
                }
            }
            else if (desireDirection == Direction.LEFT) {
                if (robot.getDirection() == Direction.UP) {
                    robot.turnLeft();
                } else {
                    robot.turnRight();
                }
            }
            else if (desireDirection == Direction.DOWN) {
                if (robot.getDirection() == Direction.LEFT) {
                    robot.turnLeft();
                } else {
                    robot.turnRight();
                }
            }
            else if (desireDirection == Direction.UP) {
                if (robot.getDirection() == Direction.RIGHT) {
                    robot.turnLeft();
                } else {
                    robot.turnRight();
                }
            }
        }
    }

    private static void simpleTurn(Robot robot, Direction desireDirection){
        while (robot.getDirection() != desireDirection) {
              robot.turnRight();
        }
    }

    // it uses smart turn
    private static void moveRobotToX(Robot robot, int toX){
        if (robot.getX() < toX){
            smartTurn(robot, Direction.RIGHT);
        }
        else if (robot.getX() > toX){
            smartTurn(robot, Direction.LEFT);
        }
        while (robot.getX() != toX){
            robot.stepForward();
        }
    }

    // it does not use smart turn
    private static void moveRobotToY(Robot robot, int toY){
        if (robot.getY() < toY){
            simpleTurn(robot, Direction.UP);
        }
        else if (robot.getY() > toY){
            simpleTurn(robot, Direction.DOWN);
        }
        while (robot.getY() != toY){
            robot.stepForward();
        }
    }

    public static void moveRobot(Robot robot, int toX, int toY) {

        moveRobotToX(robot, toX);
        moveRobotToY(robot, toY);

        System.out.println("My position is X : " + robot.getX() + ", Y : " + robot.getY());
    }

//========= the answer =============================^


    public static void main(String[] args) {
        moveRobot(new Robot(), 3, 0);
        moveRobot(new Robot(), -3, 0);
        moveRobot(new Robot(), -3, -8);
        moveRobot(new Robot(), 6, 3);
        moveRobot(new Robot(), 11, 8);
    }
}
