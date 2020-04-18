package code

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

internal class CodePracticesKtTest {

    // https://www.hackerrank.com/challenges/sock-merchant/problem
    @Test
    fun testSockMerchant() {
        var n = 9
        var arr = intArrayOf(10, 20, 20, 10, 10, 30, 50, 10, 20)
        var result = sockMerchant(n, arr)
        assertEquals(3, result)
        n = 10
        arr = intArrayOf(1, 1, 3, 1, 2, 1, 3, 3, 3, 3)
        result = sockMerchant(n, arr)
        assertEquals(4, result)
    }

    // https://www.hackerrank.com/challenges/breaking-best-and-worst-records/problem
    @Test
    fun testBreakingRecords() {
        val sample0 = intArrayOf(10, 5, 20, 20, 4, 5, 2, 25, 1)
        var result = breakingRecords(sample0)
        assertEquals(2, result!![0])
        assertEquals(4, result[1])
        val sample1 = intArrayOf(3, 4, 21, 36, 10, 28, 35, 5, 24, 42)
        result = breakingRecords(sample1)
        assertEquals(4, result!![0])
        assertEquals(0, result[1])
    }

    // https://www.hackerrank.com/challenges/birthday-cake-candles/problem
    @Test
    fun `test birthdayCakeCandles`() {
        var arr = intArrayOf(3, 2, 1, 3)
        var result = birthdayCakeCandles(arr)
        assertEquals(2, result)
        val n = 100000  // threshold case
        arr = IntArray(n)
        for (i in 0 until n) arr[i] = 9999999
        result = birthdayCakeCandles(arr)
        assertEquals(100000, result)
    }

    @Test
    fun `test Fibonacci_positionEquals10`() {
        val result = fibonacci(10)
        assertEquals(55, result)
    }

    // https://www.hackerrank.com/challenges/mini-max-sum/problem
    @Test
    fun `test minMaxSum`() {
        val arr = intArrayOf(1, 2, 3, 4, 5)
        val result = minMaxSum(arr)
        assertEquals(10L, result!![0])
        assertEquals(14L, result[1])
    }

    // https://www.hackerrank.com/challenges/apple-and-orange/problem
    @Test
    fun `test countApplesAndOranges`() {
        // sample case
        var s = 7; var t = 11 // house
        var a = 5; var b = 15 // tree
        var apples = intArrayOf(-2, 2, 1)
        var oranges = intArrayOf(5, -6) // fruits array
        var result = countApplesAndOranges(s, t, a, b, apples, oranges)
        assertEquals(1, result[0])
        assertEquals(1, result[1])
        // test case 2
        s = 2; t = 3; a = 1; b = 5
        apples = intArrayOf(2)
        oranges = intArrayOf(-2)
        result = countApplesAndOranges(s, t, a, b, apples, oranges)
        assertEquals(1, result[0])
        assertEquals(1, result[1])
    }

    // https://www.hackerrank.com/challenges/super-digit/problem
    @Test
    fun `test superdit`() {
        var n = "148"; var k = 3; var expected = 3
        var result = superdigit(n,k)
        assertEquals(expected, result)
        n = "9875"; k = 4; expected = 8
        result = superdigit(n,k)
        assertEquals(expected, result)
        n = "123"; k = 3; expected = 9
        result = superdigit(n,k)
        assertEquals(expected, result)
        n = "100000"; k = 100000  // superior threshold
        result = superdigit(n,k)
        assertTrue(result > 0)
    }

    // https://www.hackerrank.com/challenges/best-divisor/problem
    @Test
    fun `test bestDivsor`() {
        val sample = 12
        val expectedVal = 6;
        val result = bestDivisor(sample);
        assertEquals(expectedVal, result)
    }

}