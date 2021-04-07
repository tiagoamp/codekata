package hackerrank

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

// https://www.hackerrank.com/challenges/minimum-distances/problem

fun minimumDistances_solution2(a: Array<Int>): Int {
    var minDist = a.size+1
    val map : MutableMap<Int, Int> = emptyMap<Int,Int>().toMutableMap()
    for ((i,curr) in a.withIndex()) {
        if (map[curr] == null) {
            map[curr] = i
            continue
        }
        val dist = i - map[curr]!!
        if ( dist < minDist )
            minDist = dist
        map[curr] = i
    }
    return if (minDist == a.size+1) -1 else minDist
}

fun minimumDistances_solution1(a: Array<Int>): Int {
    var minDist = a.size+1
    for ((i,curr) in a.withIndex()) {
        val rangeToEnd = a.copyOfRange(i + 1, a.size)
        for ((j,next) in a.withIndex()) {
            if (j <= i) continue // meaning j = i+1
            if (a[i] == a[j] && (j-i) < minDist)
                minDist = j-i
        }
    }
    return if(minDist == a.size+1) -1 else minDist
}


internal class MinimimDistancesTest {

    @Test
    @DisplayName("Test sample input 0")
    fun minimumDistance0() {
        val arr = arrayOf(7, 1, 3, 4, 1, 7)
        val expected = 3
        val result2 = minimumDistances_solution2(arr)
        val result1 = minimumDistances_solution1(arr)
        assertEquals(expected, result2)
        assertEquals(result1, result2)
    }

    @Test
    @DisplayName("Test sample input 8")
    fun minimumDistance8() {
        val arr = arrayOf(1, 1)
        val expected = 1
        val result2 = minimumDistances_solution2(arr)
        val result1 = minimumDistances_solution1(arr)
        assertEquals(expected, result2)
        assertEquals(result1, result2)
    }

}