package hackerrank

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

// https://www.hackerrank.com/challenges/kaprekar-numbers/problem

fun kaprekarNumbers(p: Int, q: Int): Array<Long> {
    val filtered = LongRange(p.toLong(), q.toLong()).filter { it ->
        val sq: Long = it * it
        val sqAsStr = sq.toString()
        val d = it.toString().length
        val r = sqAsStr.takeLast(d)
        val l = if (r.length < sqAsStr.length) sqAsStr.take(sqAsStr.length - r.length) else "0"
        l.toLong() + r.toLong() == it
    }
//    if (filtered.isEmpty())
//        print("INVALID RANGE")
//    filtered.forEach { print("$it ") }
    return filtered.toTypedArray()
}


internal class KaprekarNumbersTest {

    @Test
    @DisplayName("Test sample input 0")
    fun test0() {
        val p = 1; val q = 100
        val expected: Array<Long> = arrayOf(1,9,45,55,99)
        val result = kaprekarNumbers(p, q)
        assertArrayEquals(expected, result)
    }

    @Test
    @DisplayName("Test sample input 2")
    fun test2() {
        val p = 400; val q = 700
        val result = kaprekarNumbers(p, q)
        assertTrue(result.isEmpty())
    }

    @Test
    @DisplayName("Test sample input 6")
    fun test6() {
        val p = 1; val q = 99999
        val expected: Array<Long> = arrayOf(1, 9, 45, 55, 99, 297, 703, 999, 2223, 2728, 4950, 5050, 7272, 7777, 9999, 17344, 22222, 77778, 82656, 95121, 99999)
        val result = kaprekarNumbers(p, q)
        assertArrayEquals(expected, result)
    }

}