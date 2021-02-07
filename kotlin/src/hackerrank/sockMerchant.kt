package hackerrank

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

// https://www.hackerrank.com/challenges/sock-merchant/problem

fun sockMerchant(n: Int, arr: IntArray): Int {
    val colors: MutableSet<Int> = HashSet()
    var pairs = 0
    for (i in 0 until n) {
        if (!colors.contains(arr[i])) {
            colors.add(arr[i])
        } else {
            pairs++
            colors.remove(arr[i])
        }
    }
    return pairs
}


internal class SockMerchantTest {

    @Test
    fun `test sockMerchant`() {
        var n = 9
        var arr = intArrayOf(10, 20, 20, 10, 10, 30, 50, 10, 20)
        var result = sockMerchant(n, arr)
        assertEquals(3, result)
        n = 10
        arr = intArrayOf(1, 1, 3, 1, 2, 1, 3, 3, 3, 3)
        result = sockMerchant(n, arr)
        assertEquals(4, result)
    }

}