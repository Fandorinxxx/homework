package ru.alternation.stepik.contest_java.functionals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntUnaryOperator;
import java.util.function.UnaryOperator;

/**
 2.36 Multifunctional mapper

 Write three functions:

 1. Multifunctional mapper (transformer) that accepts a list of operators (mappers) and returns a new operator. The
 returned operator accepts a list of integer numbers and sequentially applies each mapper to each number in the list
 (performs multiple transformations).
 2. In terms of the multifunctional mapper define an operator that multiplies by two each integer number and then add one
 to its. The operator is applied to each number in the input list.
 3. In terms of the multifunctional mapper define an operator that squares each integer number and then calculates the
 next even number following it. The operator is also applied to each number in the input list.
 Try not to use Stream API. Write the mapper yourself.

 To simplify the problem all function (represented by objects) are declared, you need to finish their realization.
 Look carefully at definition of each function.

 Also there is an example: identity operator that is defined in terms of the multifunctional mapper.
 It doesn't changes values in the input list.

 During testing all operators will be tested (including identity).


 Example 1. An input list with integer numbers [1, 1, 1, 1].
    identityTransformation returns the result list [1, 1, 1, 1].
    multTwoAndThenAddOneTransformation returns the result list [3, 3, 3, 3].
    squareAndThenGetNextEvenNumberTransformation returns the result list [2, 2, 2, 2].

 Example 2. An input list with integer numbers [1, 2, 3].
    identityTransformation returns the result list [1, 2, 3].
    multTwoAndThenAddOneTransformation returns the result list [3, 5, 7].
    squareAndThenGetNextEvenNumberTransformation returns the result list [2, 6, 10].

 */
public class Main36 {


    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3);
        List<Integer> appled = identityTransformation.apply(list);
        List<Integer> appled2 = multTwoAndThenAddOneTransformation.apply(list);
        List<Integer> appled3 = squareAndThenGetNextEvenNumberTransformation.apply(list);
        System.out.println(appled);
        System.out.println(appled2);
        System.out.println(appled3);
    }


    /**
     * The function accepts a list of mappers and returns an operator that accepts a list of integers
     * and sequentially applies each mapper to each value (perform a transformation)
     */
    public static final Function<
            List<IntUnaryOperator>,      // input
            UnaryOperator<List<Integer>> // output
            > multifunctionalMapper =

            (List<IntUnaryOperator> operators) -> {
                return (List<Integer> integers) -> {
                    List<Integer> buffer = new ArrayList<>(integers.size());

                    for (Integer integer : integers) {
                        int temp = integer;
                        for (IntUnaryOperator operator : operators) {
                            temp = operator.applyAsInt(temp);
                        }
                        buffer.add(temp);
                    }
                    return buffer;
                };
    };


    /**
     * EXAMPLE: the operator transforms each number to the same number (perform the identity transformation)
     * <p>
     * It returns a list of the same numbers.
     */
    public static final UnaryOperator<List<Integer>> identityTransformation =
            multifunctionalMapper.apply(Arrays.asList(x -> x, x -> x, x -> x));

    /**
     * The operator accepts an integer list.
     * It multiplies by two each integer number and then add one to its.
     * <p>
     * The operator returns transformed integer list.
     */
    public static final UnaryOperator<List<Integer>> multTwoAndThenAddOneTransformation =
            (List<Integer> integers) -> {
                List<Integer> buffer = new ArrayList<>(integers.size());
                for (Integer integer : integers) {
                    integer *= 2;
                    integer += 1;
                    buffer.add(integer);
                }
                return buffer;
            };
    // multifunctionalMapper.apply(Arrays.asList(x -> x * 2, x -> x + 1)); // или просто так

    /**
     * The operator accepts an integer list.
     * It squares each integer number and then get the next even number following it.
     * <p>
     * The operator returns transformed integer list.
     */
    public static final UnaryOperator<List<Integer>> squareAndThenGetNextEvenNumberTransformation =
            (List<Integer> integers) -> {
                List<Integer> buffer = new ArrayList<>(integers.size());
                for (Integer integer : integers) {
                    integer *= integer;
                    integer = (integer + 1) % 2 == 0 ? integer + 1 : integer + 2;
                    buffer.add(integer);
                }
                return buffer;
            };
    // multifunctionalMapper.apply(Arrays.asList(x -> x * x, x -> x % 2 == 0 ? x + 2 : x + 1));
}