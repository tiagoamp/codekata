package hackerrank;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Map;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

//https://www.hackerrank.com/challenges/equality-in-a-array/problem
public class EqualityInAarray {

    static int equalizeArray_solution3(int[] arr) {
        Map<Integer, Long> map = Arrays.stream(arr).boxed().collect(groupingBy(n -> n, counting()));
        int mostFreqNr = map.keySet().stream().reduce(arr[0], (acc, k) -> map.get(k) < map.get(acc) ? acc : k);
        return arr.length - map.get(mostFreqNr).intValue();
    }

    static int equalizeArray_solution2(int[] arr) {
        Map<Integer, Long> map = Arrays.stream(arr).boxed().collect(groupingBy(n -> n, counting()));
        int mostFreqNr = map.keySet().stream().reduce(arr[0], (acc, k) -> map.get(k) < map.get(acc) ? acc : k);
        return Arrays.stream(arr).reduce(0, (acc, n) -> n != mostFreqNr ? acc + 1 : acc);
    }

    static int equalizeArray_solution1(int[] arr) {
        Map<Integer, Long> map = Arrays.stream(arr).boxed().collect(groupingBy(n -> n, counting()));
        int mostFreqNr = map.keySet().stream().reduce(arr[0], (acc, k) -> map.get(k) < map.get(acc) ? acc : k);
        return (int) Arrays.stream(arr).filter(n -> n != mostFreqNr).count();
    }


    @Test
    @DisplayName("Test sample input 0")
    void equalizeArray0() {
        int[] arr = {3, 3, 2, 1, 3};
        int expected = 2;
        int result3 = equalizeArray_solution3(arr);
        int result2 = equalizeArray_solution2(arr);
        int result1 = equalizeArray_solution1(arr);
        assertEquals(result1, result2);
        assertEquals(result2, result3);
        assertEquals(expected, result2);
    }

    @Test
    @DisplayName("Test sample input 1")
    void equalizeArray1() {
        int[] arr = {1, 2, 3, 1, 2, 3, 3, 3};
        int expected = 4;
        int result3 = equalizeArray_solution3(arr);
        int result2 = equalizeArray_solution2(arr);
        int result1 = equalizeArray_solution1(arr);
        assertEquals(result1, result2);
        assertEquals(result2, result3);
        assertEquals(expected, result2);
    }

    @Test@DisplayName("Test sample 6")
    void equalizeArray6() {
        int[] arr = {95,95,33,95,95,33,33,33,95,33,95,95,95,95,95,95,95,95,95,95,95,95,33,33,95,95,95,95,33,33,33,95,33,33,33,33,33,95,95,95,95,95,33};
        int expected = 16;
        int result3 = equalizeArray_solution3(arr);
        int result2 = equalizeArray_solution2(arr);
        int result1 = equalizeArray_solution1(arr);
        assertEquals(result1, result2);
        assertEquals(result2, result3);
        assertEquals(expected, result2);
    }

}
