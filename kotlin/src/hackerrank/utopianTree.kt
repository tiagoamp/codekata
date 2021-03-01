package hackerrank

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

// https://www.hackerrank.com/challenges/utopian-tree/problem

fun utopianTree(n: Int): Int {
    var result = 1
    if (n == 0) return result
    for (i in 1..n) {
        val shouldDoubleSize = i % 2 != 0 // odd numbers double size
        result = if (shouldDoubleSize) result * 2 else result + 1
    }
    return result
}


internal class UtopianTreeTest {

    @Test
    fun `test utopianTree`() {
        val inputs = arrayOf(0, 1, 4)
        val expected = arrayOf(1, 2, 7)
        for (i in inputs.indices) assertEquals(expected[i], utopianTree(inputs[i]))
    }

}