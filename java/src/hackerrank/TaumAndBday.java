package hackerrank;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaumAndBday {

    public static long taumBday(int b, int w, int bc, int wc, int z) {
        if (bc > (wc + z))
            return wc * ((long) b + (long) w) + ((long) b * (long) z);
        else if (wc > (bc + z))
            return bc * ((long) b + (long) w) + ((long) w * (long) z);
        return ((long) b * (long) bc) + ((long) w * (long) wc);
    }


    @Test
    @DisplayName("Test sample input 0")
    void test0() {
        Integer[] b = {10, 5, 3, 7, 3};
        Integer[] w = {10, 9, 6, 7, 3};
        Integer[] bc = {1, 2, 9, 4, 1};
        Integer[] wc = {1, 3, 1, 2, 9};
        Integer[] z = {1, 4, 1, 1, 2};
        Long[] expected = {20L, 37L, 12L, 35L, 12L};
        for (int i = 0; i < expected.length; i++) {
            Long result = taumBday(b[i], w[i], bc[i], wc[i], z[i]);
            assertEquals(expected[i], result);
        }
    }

}
