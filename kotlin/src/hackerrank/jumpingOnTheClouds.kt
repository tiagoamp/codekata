package hackerrank

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

// https://www.hackerrank.com/challenges/jumping-on-the-clouds/problem

fun jumpingOnClouds(c: Array<Int>): Int {
    var jumps = 0
    var index = 0
    while ( index < (c.size-1) ) {
        index += if (index+2 < c.size && c[index+2] == 0) 2 else 1
        jumps++
    }
    return jumps
}


internal class JumpingOnCloudTest {

    @Test
    @DisplayName("Test sample input 0")
    fun test0() {
        val c: Array<Int> = arrayOf(0, 0, 1, 0, 0, 1, 0)
        val expected = 4
        val result = jumpingOnClouds(c)
        assertEquals(expected, result)
    }

    @Test
    @DisplayName("Test sample input 0")
    fun test1() {
        val c: Array<Int> = arrayOf(0, 0, 0, 0, 1, 0)
        val expected = 3
        val result = jumpingOnClouds(c)
        assertEquals(expected, result)
    }

}