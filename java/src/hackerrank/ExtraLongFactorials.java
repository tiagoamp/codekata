package hackerrank;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

// https://www.hackerrank.com/challenges/extra-long-factorials/problem
public class ExtraLongFactorials {

    public static void extraLongFactorials(int n) {
        factorial(n);  // at hackerrank site should be ==> System.out.println( factorial(n) )
    }

    private static Map<Integer,BigInteger> memo = new HashMap<>();

    private static BigInteger factorial(Integer n) {
        if (n == 1) return BigInteger.ONE;
        memo.put(n, new BigInteger(n.toString()).multiply(factorial(n - 1)));  // n * factorial(n-1)
        return memo.get(n);
    }


    @Test
    @DisplayName("Test input val 25")
    void extraLongFactorials25() {
        int n = 25;
        var expected = new BigInteger("15511210043330985984000000");
        var result = factorial(n);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test input val 45")
    void extraLongFactorials45() {
        int n = 45;
        var expected = new BigInteger("119622220865480194561963161495657715064383733760000000000");
        var result = factorial(n);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test edge case up")
    void extraLongFactorials100() {
        int n = 100;
        var result = factorial(n);
        assertNotNull(result);
    }

    @Test
    @DisplayName("Test bottom edge case")
    void extraLongFactorials1() {
        int n = 1;
        var result = factorial(n);
        assertEquals(BigInteger.ONE, result);
    }


}
