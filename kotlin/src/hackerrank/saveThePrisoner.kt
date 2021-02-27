package hackerrank

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

// https://www.hackerrank.com/challenges/save-the-prisoner/problem

fun saveThePrisoner(n: Int, m: Int, s: Int): Int {
    val r = s + (m - 1)
    if (r <= n) return r
    return if (r % n == 0) n else r % n
}


internal class SaveThePriosinerTest {

    @Test
    fun `test saveThePrisoner`() {
        var n = 5; var m = 2; var s = 1
        var expected = 2
        var result = saveThePrisoner(n, m, s)
        assertEquals(expected, result)
        n = 5; m = 2; s = 2
        expected = 3
        result = saveThePrisoner(n, m, s)
        assertEquals(expected, result)
        n = 7; m = 19; s = 2
        expected = 6
        result = saveThePrisoner(n, m, s)
        assertEquals(expected, result)
        n = 3; m = 7; s = 3
        expected = 3
        result = saveThePrisoner(n, m, s)
        assertEquals(expected, result)
        n = 352926151; m = 380324688; s = 94730870
        expected = 122129406
        result = saveThePrisoner(n, m, s)
        assertEquals(expected, result)
    }

}