package hackerrank

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.math.BigInteger
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

// https://www.hackerrank.com/challenges/extra-long-factorials/problem

fun extraLongFactorials(n: Int): Unit {
    factorial(n)  // at hackerrank site should be ==> println( factorial(n) )
}

var memo = mutableMapOf<Int, BigInteger>();

fun factorial(n: Int): BigInteger {
    if (n == 1) return BigInteger.ONE
    if (!memo.containsKey(n))
        memo[n] = n.toBigInteger().multiply(factorial(n - 1))  // n * factorial(n-1)
    return memo[n]!!
}

internal class ExtraLongFactorialsTest {

    @Test
    @DisplayName("Test input val 25")
    fun extraLongFactorials25() {
        val n = 25
        val expected = BigInteger("15511210043330985984000000")
        val result: BigInteger = factorial(n)
        assertEquals(expected, result)
    }

    @Test
    @DisplayName("Test input val 45")
    fun extraLongFactorials45() {
        val n = 45
        val expected = BigInteger("119622220865480194561963161495657715064383733760000000000")
        val result: BigInteger = factorial(n)
        assertEquals(expected, result)
    }

    @Test
    @DisplayName("Test edge case up")
    fun extraLongFactorials100() {
        val n = 100
        val result: BigInteger = factorial(n)
        assertNotNull(result)
    }

    @Test
    @DisplayName("Test bottom edge case")
    fun extraLongFactorials1() {
        val n = 1
        val result: BigInteger = factorial(n)
        assertEquals(BigInteger.ONE, result)
    }

}