package hackerrank

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test


// https://www.hackerrank.com/challenges/beautiful-triplets/problem

fun beautifulTriplets(d: Int, arr: Array<Int>): Int {
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
        val result = beautifulTriplets(d, arr)
        Assertions.assertEquals(expected, result)
    }

}