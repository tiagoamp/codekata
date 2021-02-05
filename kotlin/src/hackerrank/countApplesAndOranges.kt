package hackerrank

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals


// https://www.hackerrank.com/challenges/apple-and-orange/problem

fun countApplesAndOranges(s: Int, t: Int, a: Int, b: Int, apples: IntArray, oranges: IntArray): IntArray {
    var appleCount = 0
    for (i in apples.indices) {
        val distance = apples[i] + a
        if (distance in s..t) appleCount++
    }
    var orangeCount = 0
    for (i in oranges.indices) {
        val distance = oranges[i] + b
        if (distance in s..t) orangeCount++
    }
    return intArrayOf(appleCount, orangeCount)
}


internal class CountApplesAndOrangesTest {

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

}
