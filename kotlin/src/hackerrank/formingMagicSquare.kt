package hackerrank

import org.junit.jupiter.api.Test
import kotlin.math.abs
import kotlin.test.assertEquals

// https://www.hackerrank.com/challenges/magic-square-forming/problem

fun formingMagicSquare(s: Array<IntArray>): Int {
    val costs = intArrayOf(0, 0, 0, 0, 0, 0, 0, 0)
    val magicSquares = arrayOf(intArrayOf(2, 7, 6, 9, 5, 1, 4, 3, 8), intArrayOf(6, 7, 2, 1, 5, 9, 8, 3, 4), intArrayOf(8, 3, 4, 1, 5, 9, 6, 7, 2), intArrayOf(4, 3, 8, 9, 5, 1, 2, 7, 6), intArrayOf(6, 1, 8, 7, 5, 3, 2, 9, 4), intArrayOf(2, 9, 4, 7, 5, 3, 6, 1, 8), intArrayOf(4, 9, 2, 3, 5, 7, 8, 1, 6), intArrayOf(8, 1, 6, 3, 5, 7, 4, 9, 2))
    for (i in magicSquares.indices) {
        costs[i] = abs(magicSquares[i][0] - s[0][0]) + abs(magicSquares[i][1] - s[0][1]) + abs(magicSquares[i][2] - s[0][2])
        costs[i] = costs[i] + abs(magicSquares[i][3] - s[1][0]) + abs(magicSquares[i][4] - s[1][1]) + abs(magicSquares[i][5] - s[1][2])
        costs[i] = costs[i] + abs(magicSquares[i][6] - s[2][0]) + abs(magicSquares[i][7] - s[2][1]) + abs(magicSquares[i][8] - s[2][2])
    }
    return costs.min()!!;
}

internal class FormingagicSquareTest {

    @Test
    fun `test formingMagicSquare`() {
        val sample0 = arrayOf(intArrayOf(4, 9, 2), intArrayOf(3, 5, 7), intArrayOf(8, 1, 5))
        val sample1 = arrayOf(intArrayOf(4, 8, 2), intArrayOf(4, 5, 7), intArrayOf(6, 1, 6))
        val expectedResult0 = 1; val expectedResult1 = 4
        var result = formingMagicSquare(sample0)
        assertEquals(expectedResult0, result)
        result = formingMagicSquare(sample1)
        assertEquals(expectedResult1, result)
    }

}