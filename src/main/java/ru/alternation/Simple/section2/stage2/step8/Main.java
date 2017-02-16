package ru.alternation.Simple.section2.stage2.step8;

/**
 Реализуйте метод, проверяющий, является ли заданное число по абсолютной величине степенью двойки.

 Решать можно разными способами:

 воспользовавшись одним удобным статическим методом из класса java.lang.Integer;
 применив пару трюков из двоичной арифметики;
 написав решение "в лоб" с циклом и условными операторами (можете вернуться к этой задаче после просмотра соответствующих уроков).

 Sample Input 1:
 0
 Sample Output 1:
 false

 Sample Input 2:
 1
 Sample Output 2:
 true

 Sample Input 3:
 -2
 Sample Output 3:
 true

 */
public class Main {

    /**
     * Checks if given <code>value</code> is a power of two.
     *
     * @param value any number
     * @return <code>true</code> when <code>value</code> is power of two, <code>false</code> otherwise
     */
    public static boolean isPowerOfTwo(int value) {

        return Integer.bitCount(Math.abs(value)) == 1;
        // return (value != 0) && (((value & value-1) == 0) || ((-1*value & -1*value-1) == 0));
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(0));
        System.out.println(isPowerOfTwo(1));
        System.out.println(isPowerOfTwo(-2));
    }


}
