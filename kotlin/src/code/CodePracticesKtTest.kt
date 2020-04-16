package code

import org.junit.jupiter.api.Assertions.*
import code.*;
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class CodePracticesKtTest {

    // https://www.hackerrank.com/challenges/best-divisor/problem
    @Test
    fun `test bestDivsor`() {
        val sample = 12
        val expectedVal = 6;
        val result = bestDivisor(sample);
        assertEquals(expectedVal, result)
    }

}