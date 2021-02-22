package hackerrank

import org.junit.jupiter.api.Test
import kotlin.math.ceil
import kotlin.test.assertEquals

// https://www.hackerrank.com/challenges/lowest-triangle/problem

fun lowestTriangle(base: Int, area: Int) = ceil(area * 2.0 / base.toFloat()).toInt()


internal class LowestTriangleTest {

    @Test
    fun `lowestTriangle`() {
        var b = 2; var a = 2
        var result = lowestTriangle(b, a)
        assertEquals(2, result)
        b = 17; a = 100
        result = lowestTriangle(b, a)
        assertEquals(12, result)
    }

}