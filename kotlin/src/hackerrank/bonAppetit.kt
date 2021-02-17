package hackerrank

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

// https://www.hackerrank.com/challenges/bon-appetit/problem

fun bonAppetit(bill: Array<Int>, k: Int, b: Int): String {
    val total = bill.sum()
    val actualCharge = (total - bill[k]) / 2
    return if (b == actualCharge) "Bon Appetit" else (b - actualCharge).toString()
}


internal class BonAppetitTest {

    @Test
    fun `test bonAppetit`() {
        var bill = arrayOf(3, 10, 2, 9)
        var k = 1; var b = 12
        var result = bonAppetit(bill, k, b)
        assertEquals("5", result)
        b = 7
        result = bonAppetit(bill, k, b)
        assertEquals("Bon Appetit", result)
        bill = arrayOf(72, 53, 60, 66, 90, 62, 12, 31, 36, 94)
        k = 6; b = 288
        result = bonAppetit(bill, k, b)
        assertEquals("6", result)
    }

}