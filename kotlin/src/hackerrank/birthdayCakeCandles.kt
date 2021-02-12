package hackerrank

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

// https://www.hackerrank.com/challenges/birthday-cake-candles/problem

fun birthdayCakeCandles(arr: IntArray): Int {
    arr.sort()
    val lastIndex = arr.size - 1
    val tallest = arr[lastIndex]
    var count = 0
    for (i in lastIndex downTo 0) {
        if (arr[i] == tallest) count++ else break
    }
    return count
}

internal class BirthdayCakeCandlesTest {

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

}