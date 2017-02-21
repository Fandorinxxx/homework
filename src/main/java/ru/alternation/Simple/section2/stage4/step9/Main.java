package ru.alternation.Simple.section2.stage4.step9;

import java.util.Arrays;

/**
 Реализуйте метод, сливающий два отсортированных по неубыванию массива чисел в один отсортированный в том же порядке массив.
 Массивы могут быть любой длины, в том числе нулевой.

 Предполагается, что вы реализуете алгоритм слияния, имеющий линейную сложность: он будет идти по двум
 исходным массивам и сразу формировать отсортированный результирующий массив.
 Так, чтобы сортировка полученного массива при помощи Arrays.sort() уже не требовалась.
 К сожалению, автоматически это не проверить, так что это остается на вашей совести :)

 Воспользуйтесь предоставленным шаблоном. Декларацию класса, метод main и обработку ввода-вывода добавит проверяющая система.

 Пример

 Если на вход подаются массивы {0, 2, 2} и {1, 3}, то на выходе должен получиться массив {0, 1, 2, 2, 3}

 */

    // http://developer.alexanderklimov.ru/android/java/array.php#concat

    // Тесты
    // https://github.com/meanmail/java_base/blob/master/src/meanmail/stepic/java/tests/MergeArrays.java

public class Main {


    /**
     * Merges two given sorted arrays into one
     *
     * @param a1 first sorted array
     * @param a2 second sorted array
     * @return new array containing all elements from a1 and a2, sorted
     */
    public static int[] mergeArrays(int[] a1, int[] a2) {

        if (a1.length == 0)
            return a2;
        if (a2.length == 0)
            return a1;

        int totalLength = a1.length + a2.length;
        int[] result = new int[totalLength];
        for (int i = 0, j = 0, k = 0; k < totalLength; k++) {

            if (i < a1.length && ( j == a2.length || a1[i] <= a2[j])) {
                result[k] = a1[i];
                i++;
            }
            else {
                result[k] = a2[j];
                j++;
            }
        }
        return result;
    }

    public static void main(String[] args) {

        System.out.println(Arrays.toString(mergeArrays(new int[]{0, 2, 2}, new int[] {1, 3})));
        System.out.println(Arrays.toString(mergeArrays(new int[]{0, 1, 5, 8, 8}, new int[] {1, 3, 3, 9, 11})));
        System.out.println(Arrays.toString(mergeArrays(new int[]{0, 1, 5}, new int[] {1, 3, 3, 9, 11})));
        System.out.println(Arrays.toString(mergeArrays(new int[]{0, 1, 5}, new int[] {11})));
        System.out.println(Arrays.toString(mergeArrays(new int[]{0, 1, 5}, new int[] {})));
        System.out.println(Arrays.toString(mergeArrays(new int[]{}, new int[] {})));
        System.out.println(Arrays.toString(mergeArrays(new int[]{1, 2}, new int[] {1})));

    }

    public static int[] concatArrays(int[] a1, int[] a2) {
        int[] result = new int[a1.length + a2.length];
        System.arraycopy(a1, 0, result , 0, a1.length);
        System.arraycopy(a2, 0, result , a1.length, a2.length);
        Arrays.sort(result);
        return  result;
    }
    public static int[] mergeArraysNew(int[] a1, int[] a2) {

        int[] result = new int[a1.length + a2.length];
        int i = 0, j = 0;

        while (i < a1.length && j < a2.length){
            result[i+j] = (a1[i] <= a2[j]) ? a1[i++] : a2[j++];
        }
        while (i < a1.length)
            result[i+j] = a1[i++];
        while (j < a2.length)
            result[i+j] = a2[j++];

        return result;
    }

    public static int[] mergeArraysAnother(int[] a1, int[] a2) {
        int n = a1.length, m = a2.length;
        int i = 0, j = 0;
        int[] array = new int[n + m];

        while (i < n || j < m)
            array[i + j] = (i < n && (j == m || a1[i] < a2[j])) ? a1[i++] : a2[j++];

        return array;
    }

}
