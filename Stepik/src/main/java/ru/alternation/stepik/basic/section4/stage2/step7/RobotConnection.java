package ru.alternation.stepik.basic.section4.stage2.step7;


public interface RobotConnection extends AutoCloseable {
    void moveRobotTo(int x, int y);
    @Override
    void close();
}