package ru.alternation.examples.codility.task00;

import java.util.Arrays;
import java.util.Scanner;

/**

 https://app.codility.com/c/run/demoDZF4GD-X49

 This is a demo task.

 Write a function:
    class Solution { public int solution(int[] A); }

 that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.


 For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
 Given A = [1, 2, 3], the function should return 4.
 Given A = [−1, −3], the function should return 1.

 Write an efficient algorithm for the following assumptions:
 - N is an integer within the range [1..100,000];
 - each element of array A is an integer within the range [−1,000,000..1,000,000].


 Copyright 2009–2018 by Codility Limited.

 */

public class Solution {

    public static void main(String... args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println(solution(1, 2, 3, 6));
        System.out.println(solution(7, 4, 2, 6));
        System.out.println(solution(-5, 6));
        System.out.println(solution(0, 6));
        System.out.println(solution(1, 2, 3));

    }


    public static int solution(int... array) {

        int answer = 0;
        int maxElem = Arrays.stream(array).max().orElse(1);
        int minElem = Arrays.stream(array).min().orElse(1);

        if (maxElem < 0) {
            return 1;
        }

        if (minElem <= 0) {
            minElem = 1;
        }

        int[] buffer = new int[maxElem];

        for (int a : array) {
            if (a > 0) {
                buffer[a-1] = 1;
            }
        }

        for (int i = minElem-1; i < buffer.length; i++) {
            if (buffer[i] == 0) {
                break;
            }
            answer = i+1;
        }

        return answer+1;
    }
}
