package hackerrank

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

// https://www.hackerrank.com/challenges/electronics-shop/problem

fun getMoneySpent(keyboards: IntArray, drives: IntArray, b: Int): Int {
    val results: MutableList<Int> = ArrayList()
    for (i in keyboards.indices) {
        for (j in drives.indices) {
            val sum = keyboards[i] + drives[j]
            if (b >= sum) results.add(sum)
        }
    }
    return if (results.isEmpty()) -1 else results.max()!!
}


internal class GetMoneySpentTest {

    @Test
    fun `test getMoneySpent`() {
        val keyboards0 = intArrayOf(3, 1)
        val drives0 = intArrayOf(5, 2, 8)
        var b = 10; var expected = 9
        var result = getMoneySpent(keyboards0, drives0, b)
        assertEquals(expected, result)
        val keyboards1 = intArrayOf(4)
        val drives1 = intArrayOf(5)
        b = 5; expected = -1
        result = getMoneySpent(keyboards1, drives1, b)
        assertEquals(expected, result)
    }

}