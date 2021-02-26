package hackerrank

import org.junit.jupiter.api.Test
import kotlin.math.abs
import kotlin.math.min
import kotlin.test.assertEquals

// https://www.hackerrank.com/challenges/queens-attack-2/problem

fun queensAttack(n: Int, k: Int, r_q: Int, c_q: Int, obstacles: Array<IntArray>): Int {
    // if board size just fit the queen spot, return 0
    if (n == 0 || n == 1) return 0

    // if there are no obstacles, return all queen's cells to be attacked
    if (k == 0) {
        val qRowsCount = n - 1 + (n - 1)
        val qDiagCount = min(n - r_q, c_q - 1) + min(r_q - 1, c_q - 1) +
                min(n - r_q, n - c_q) + min(r_q - 1, n - c_q)
        return qRowsCount + qDiagCount
    }

    // Identify the closest obstacle in each 8 directions
    var minDistanceObLeft = c_q - 1
    var minDistanceObRight = n - c_q
    var minDistanceObUp = n - r_q
    var minDistanceObDown = r_q - 1
    var minDistanceObLeftUp = min(n - r_q, c_q - 1)
    var minDistanceObLeftDown = min(r_q - 1, c_q - 1)
    var minDistanceObRightUp = min(n - r_q, n - c_q)
    var minDistanceObRightDown = min(r_q - 1, n - c_q)
    for (i in 0 until k) {
        val r_o = obstacles[i][0]
        val c_o = obstacles[i][1]

        // case same row
        if (r_o == r_q) {
            if (c_o < c_q && c_q - c_o - 1 < minDistanceObLeft) {
                minDistanceObLeft = c_q - c_o - 1
            } else if (c_o > c_q && c_o - c_q - 1 < minDistanceObRight) {
                minDistanceObRight = c_o - c_q - 1
            }
        }
        // case same column
        if (c_o == c_q) {
            if (r_o > r_q && r_o - r_q - 1 < minDistanceObUp) {
                minDistanceObUp = r_o - r_q - 1
            } else if (r_o < r_q && r_q - r_o - 1 < minDistanceObDown) {
                minDistanceObDown = r_q - r_o - 1
            }
        }
        // case same diagonals
        if (abs(r_q - r_o) == abs(c_q - c_o)) {
            val distance = abs(r_q - r_o) - 1
            if (r_o > r_q && c_o < c_q && distance < minDistanceObLeftUp)
                minDistanceObLeftUp = distance
            else if (r_o < r_q && c_o < c_q && distance < minDistanceObLeftDown)
                minDistanceObLeftDown = distance
            else if (r_o > r_q && c_o > c_q && distance < minDistanceObRightUp)
                minDistanceObRightUp = distance
            else if (r_o < r_q && c_o > c_q && distance < minDistanceObRightDown)
                minDistanceObRightDown = distance
        }
    }
    return minDistanceObLeft + minDistanceObRight + minDistanceObUp + minDistanceObDown +
            minDistanceObLeftUp + minDistanceObLeftDown + minDistanceObRightUp + minDistanceObRightDown
}


internal class QueensAtackTest {

    @Test
    fun `test queensAttack`() {
        var n = 4; var k = 0
        var r_q = 4; var c_q = 4
        var obstacles = Array(0) { IntArray(2) }
        val expected0 = 9
        val result0 = queensAttack(n, k, r_q, c_q, obstacles)
        assertEquals(expected0, result0)
        n = 8; k = 0; r_q = 4; c_q = 4
        obstacles = Array(0) { IntArray(2) }
        val expected = 27
        val result = queensAttack(n, k, r_q, c_q, obstacles)
        assertEquals(expected, result)
        n = 5; k = 3; r_q = 4; c_q = 3
        obstacles = Array(k) { IntArray(2) }
        obstacles[0][0] = 5; obstacles[0][1] = 5
        obstacles[1][0] = 4; obstacles[1][1] = 2
        obstacles[2][0] = 2; obstacles[2][1] = 3
        val expected1 = 10
        val result1 = queensAttack(n, k, r_q, c_q, obstacles)
        assertEquals(expected1, result1)
        n = 1; k = 0; r_q = 1; c_q = 1
        obstacles = Array(0) { IntArray(2) }
        val expected2 = 0
        val result2 = queensAttack(n, k, r_q, c_q, obstacles)
        assertEquals(expected2, result2)
    }

}