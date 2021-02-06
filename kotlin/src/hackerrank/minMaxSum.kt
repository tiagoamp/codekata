package hackerrank

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

// https://www.hackerrank.com/challenges/mini-max-sum/problem

fun minMaxSum(arr: IntArray): LongArray? {
    arr.sort()
    var min: Long = 0
    var max: Long = 0
    val len = 5
    for (i in arr.indices) {
        if (i < len - 1) min += arr[i]
        if (i > 0) max += arr[i]
    }
    return longArrayOf(min, max)
}


internal class MinMaxSumTest {

    @Test
    fun `test minMaxSum`() {
        val arr = intArrayOf(1, 2, 3, 4, 5)
        val result = minMaxSum(arr)
        assertEquals(10L, result!![0])
        assertEquals(14L, result[1])
    }

}