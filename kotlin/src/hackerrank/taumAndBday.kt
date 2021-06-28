package hackerrank

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

// https://www.hackerrank.com/challenges/taum-and-bday/problem

fun taumBday(b: Int, w: Int, bc: Int, wc: Int, z: Int): Long {
    return when {
        bc > (wc + z) -> wc * (b.toLong() + w.toLong()) + (b.toLong() * z.toLong())
        wc > (bc + z) -> bc * (b.toLong() + w.toLong()) + (w.toLong() * z.toLong())
        else -> (b.toLong() * bc.toLong()) + (w.toLong() * wc.toLong())
    }
}


internal class TaumBdayTest {

    @Test
    @DisplayName("Test sample input 0")
    fun test0() {
        val b =  arrayOf(10, 5, 3, 7, 3)
        val w =  arrayOf(10, 9, 6, 7, 3)
        val bc = arrayOf(1, 2, 9, 4, 1)
        val wc = arrayOf(1, 3, 1, 2, 9)
        val z =  arrayOf(1, 4, 1, 1, 2)
        val expected = arrayOf(20L, 37L, 12L, 35L, 12L)
        for ((i, e) in expected.withIndex()) {
            val result = taumBday(b[i], w[i], bc[i], wc[i], z[i])
            assertEquals(e, result)
        }
    }

}