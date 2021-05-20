package hackerrank

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals


// https://www.hackerrank.com/challenges/chocolate-feast/problem

fun chocolateFeast(n: Int, c: Int, m: Int): Int {
    if (n < c) return 0
    var totalBars: Int = n / c
    var wrappersToExchange: Int = totalBars
    while (wrappersToExchange >= m) {
        val remainderWrapper: Int = wrappersToExchange % m
        wrappersToExchange /= m
        totalBars += wrappersToExchange
        wrappersToExchange += remainderWrapper
    }
    return totalBars
}


internal class ChocolateFeastTest {

    @Test
    @DisplayName("Test sample 0")
    fun chocolateFeast0() {
        val n: Array<Int> = arrayOf( 10, 12, 6 )
        val c: Array<Int> = arrayOf( 2, 4, 2 )
        val m: Array<Int> = arrayOf( 5, 4, 2 )
        val expected: Array<Int> = arrayOf( 6, 3, 5 )
        for (i in 0 until expected.size-1) {
            val result = chocolateFeast(n[i], c[i], m[i])
            assertEquals(expected[i], result)
        }
    }

}