package hackerrank;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// https://www.hackerrank.com/challenges/chocolate-feast/problem
public class ChocolateFeast {

    public static int chocolateFeast(int n, int c, int m) {
        if (n < c) return 0;
        int totalBars = n / c;
        int wrappersToExchange = totalBars;
        while (wrappersToExchange >= m) {
            int remainderWrapper = wrappersToExchange % m;
            wrappersToExchange /= m;
            totalBars += wrappersToExchange;
            wrappersToExchange += remainderWrapper;
        }
        return totalBars;
    }


    @Test
    @DisplayName("Test sample 0")
    void chocolateFeast0() {
        int[] n = { 10, 12, 6 };
        int[] c = { 2, 4, 2 };
        int[] m = { 5, 4, 2 };
        int[] expected = { 6, 3, 5 };
        for (int i =0; i < expected.length; i++) {
            int result = chocolateFeast(n[i], c[i], m[i]);
            assertEquals(expected[i], result);
        }
    }

}
