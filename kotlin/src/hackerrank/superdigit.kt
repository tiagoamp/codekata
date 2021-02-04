package hackerrank

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

// https://www.hackerrank.com/challenges/super-digit/problem

fun superdigit(n: String, k: Int) : Int {
    if (n.length <= 1) return n.toInt()
    var sum = 0
    for (ch in n) {
        val digit: Int = Character.getNumericValue(ch)
        sum += digit
    }
    if (k > 1) sum *= k
    return superdigit(sum.toString(), 1)
}


internal class SuperdigitTest {

    @Test
    fun `test superdit`() {
        var n = "148"; var k = 3; var expected = 3
        var result = superdigit(n,k)
        assertEquals(expected, result)
        n = "9875"; k = 4; expected = 8
        result = superdigit(n,k)
        assertEquals(expected, result)
        n = "123"; k = 3; expected = 9
        result = superdigit(n,k)
        assertEquals(expected, result)
        n = "100000"; k = 100000  // superior threshold
        result = superdigit(n,k)
        assertTrue(result > 0)
    }

}