package hackerrank;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

// https://www.hackerrank.com/challenges/fair-rations/problem
public class FairRations {

    public static String fairRations(List<Integer> B) {
        var totalOddNrs = B.stream().reduce(0, (acc, b) -> acc = isOdd(b) ? acc+1 : acc);
        if (totalOddNrs == 0)  // only even numbers
            return "0";
        if (isOdd(totalOddNrs))
            return "NO";
        var count = 0;
        for (int i = 0; i < B.size()-1; i++) {
            if (isOdd(B.get(i))) {
                B.set(i+1, B.get(i+1) +1);
                count += 2;
            }
        }
        return String.valueOf(count);
    }

    private static boolean isOdd(int n) {
        return n % 2 != 0;
    }

    @Test
    @DisplayName("Test sample input 0")
    void test0() {
        List<Integer> b = Arrays.asList(2, 3, 4, 5, 6);
        var expected = "4";
        var result = fairRations(b);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test sample input 0")
    void test1() {
        List<Integer> b = Arrays.asList(1, 2);
        var expected = "NO";
        var result = fairRations(b);
        assertEquals(expected, result);
    }

}
