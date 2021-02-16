package hackerrank

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

// https://www.hackerrank.com/challenges/the-birthday-bar/problem

fun birthdayChoc(s: List<Int>?, d: Int, mv: Int): Int {
    var m = mv; var result = 0; var index = 0
    if (s == null || s.isEmpty()) return result
    var isOver = m > s.size
    while (!isOver) {
        val inner = s.subList(index, m)
        val sum = inner.stream().reduce(0) { x: Int, y: Int -> x + y }
        if (sum.toInt() == d) result++
        index++
        m++
        isOver = m > s.size
    }
    return result
}


internal class BirthdayChocTest {

    @Test
    fun `test birthdayChoc`() {
        var s = listOf(1, 2, 1, 3, 2)
        var d = 3; var m = 2
        var result = birthdayChoc(s, d, m)
        assertEquals(2, result)
        s = listOf(1, 1, 1, 1, 1, 1)
        result = birthdayChoc(s, d, m)
        assertEquals(0, result)
        s = listOf(2, 5, 1, 3, 4, 4, 3, 5, 1, 1, 2, 1, 4, 1, 3, 3, 4, 2, 1)
        d = 18; m = 7
        result = birthdayChoc(s, d, m)
        assertEquals(3, result)
    }

}