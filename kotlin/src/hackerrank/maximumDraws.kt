package hackerrank

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

// https://www.hackerrank.com/challenges/maximum-draws/problem

fun maximumDraws(n: Int) = ( (n * 2) / 2 ) + 1


internal class MaximumDrawsTest {

    @Test
    fun `test maximumDraws`() {
        var n = 1
        var result = maximumDraws(n)
        assertEquals(2, result)
        n = 2
        result = maximumDraws(n)
        assertEquals(3, result)
    }

}