package hackerrank

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals


// https://www.hackerrank.com/challenges/best-divisor/problem

fun bestDivisor(input: Int) : Int {
    val divisors = (1..input).filter { input % it == 0 }
    val sums = divisors.map {
        var num = it
        var sum  = 0
        while (num > 0) {
            sum += num % 10
            num /= 10
        }
        sum
    }
    val maxSummedNr = sums.max()
    val indexOfMaxSummedNr = sums.indexOf(maxSummedNr)
    return divisors[indexOfMaxSummedNr]
}


internal class BestDivisorKtTest {

    @Test
    fun `test bestDivsor`() {
        val sample = 12
        val expectedVal = 6;
        val result = bestDivisor(sample);
        assertEquals(expectedVal, result)
    }

}
