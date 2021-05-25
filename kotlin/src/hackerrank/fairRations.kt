package hackerrank

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

// https://www.hackerrank.com/challenges/fair-rations/problem

fun fairRations(B: Array<Int>): String {
    val totalOddNrs = B.count { it.isOdd() }
    if (totalOddNrs == 0)  // only even numbers
        return "0"
    if (totalOddNrs.isOdd() )
        return "NO"
    var count = 0
    for (i in B.indices) {
        if (B[i].isOdd()) {
            B[i] = B[i] + 1
            B[i+1] = B[i+1] +1
            count += 2
        }
    }
    return count.toString()
}

fun Int.isOdd() = this % 2 != 0


internal class FairRationsTest {

    @Test
    @DisplayName("Test sample input 0")
    fun test0() {
        val b: Array<Int> = arrayOf(2, 3, 4, 5, 6)
        val expected = "4"
        val result: String = fairRations(b)
        assertEquals(expected, result)
    }

    @Test
    @DisplayName("Test sample input 1")
    fun test1() {
        val b: Array<Int> = arrayOf(1, 2)
        val expected = "NO"
        val result: String = fairRations(b)
        assertEquals(expected, result)
    }

}