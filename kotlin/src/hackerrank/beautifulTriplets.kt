package hackerrank

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test


// https://www.hackerrank.com/challenges/beautiful-triplets/problem

fun beautifulTriplets_Solution2(d: Int, arr: Array<Int>): Int {
    return arr.fold(0) { acc, n -> if (arr.contains(n + d) && arr.contains(n + 2 * d)) acc+1 else acc }
}

fun beautifulTriplets_Solution1(d: Int, arr: Array<Int>): Int {
    var result = 0
    for (n in arr) {
        if (arr.contains(n + d) && arr.contains(n + 2 * d))
            result++
    }
    return result
}


internal class BeautifulTripletsTest {

    @Test
    @DisplayName("Test sample 0")
    fun beautifulTriplets0() {
        val arr: Array<Int> = arrayOf(1, 2, 4, 5, 7, 8, 10)
        val d = 3; val expected = 3
        val result2 = beautifulTriplets_Solution2(d, arr)
        val result1 = beautifulTriplets_Solution1(d, arr)
        assertEquals(expected, result2)
        assertEquals(expected, result1)
    }

}