package code

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class CodePracticesKtTest {

    // https://www.hackerrank.com/challenges/apple-and-orange/problem
    @Test
    fun testCountApplesAndOranges() {
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