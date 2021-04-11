package hackerrank;

// https://www.hackerrank.com/challenges/cut-the-sticks/problem

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class CutTheSticks {

    static int[] cutTheSticks_IterativeSolution(int[] arr) {
        List<Integer> result = new ArrayList<>();
        while (arr.length > 0) {
            OptionalInt minOpt = IntStream.of(arr).min();
            if (minOpt.isPresent()) {
                result.add(arr.length);
                int min = minOpt.getAsInt();
                arr = IntStream.of(arr)
                        .filter(n -> n != min)
                        .map(n -> n - min)
                        .toArray();
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    static int[] cutTheSticks_RecursiveSolution(int[] arr) {
        List<Integer> result = new ArrayList<>();
        result = cutArray(arr, result);
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    private static List<Integer> cutArray(int[] input, List<Integer> output) {
        if (input.length == 0) return output;
        OptionalInt minOpt = IntStream.of(input).min();
        if (minOpt.isPresent()) {
            output.add(input.length);
            int min = minOpt.getAsInt();
            input = IntStream.of(input)
                    .filter(n -> n != min)
                    .map(n -> n - min)
                    .toArray();
        }
        return cutArray(input, output);
    }


    @Test
    @DisplayName("Test sample input 0")
    void cutTheSticks0() {
        int[] arr = {5, 4, 4, 2, 2, 8};
        int[] expected = {6, 4, 2, 1};
        int[] result2 = cutTheSticks_RecursiveSolution(arr);
        int[] result1 = cutTheSticks_IterativeSolution(arr);
        assertArrayEquals(expected, result2);
        assertArrayEquals(expected, result1);
    }

    @Test
    @DisplayName("Test sample input 1")
    void cutTheSticks1() {
        int[] arr = {1, 2, 3, 4, 3, 3, 2, 1};
        int[] expected = {8, 6, 4, 1};
        int[] result2 = cutTheSticks_RecursiveSolution(arr);
        int[] result1 = cutTheSticks_IterativeSolution(arr);
        assertArrayEquals(expected, result2);
        assertArrayEquals(expected, result1);
    }

}
