package hackerrank

import org.junit.jupiter.api.Test
import kotlin.math.abs
import kotlin.test.assertEquals


//https://www.hackerrank.com/challenges/beautiful-days-at-the-movies/problem

fun beautifulDays(i: Int, j: Int, k: Int): Int {
    return (i..j).toList().filter { n -> ( abs(n - reverse(n)) % k == 0 ) }.count()
}

fun reverse(n: Int): Int {
    var n = n
    var reversed = 0
    while (n != 0) {
        val digit = n % 10
        reversed = reversed * 10 + digit
        n /= 10
    }
    return reversed
}


internal class BeautifulDayTest {

    @Test
    fun testSample() {
        val i = 20; val j = 23; val k = 6; val expected = 2;
        val result = beautifulDays(i, j, k)
        assertEquals(expected, result)
    }

    @Test
    fun testBeautifulDays3() {
        val i = 1; val j = 2000000; val k = 23047885; val expected = 2998;
        val result = beautifulDays(i, j, k)
        assertEquals(expected, result)
    }

    @Test
    fun testBeautifulDays5() {
        val i = 1; val j = 2000000; val k = 1000000000; val expected = 2998;
        val result = beautifulDays(i, j, k)
        assertEquals(expected, result)
    }

}