package hackerrank

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

// https://www.hackerrank.com/challenges/breaking-best-and-worst-records/problem

fun breakingRecords(scores: IntArray): IntArray? {
    var countMin = 0; var countMax = 0
    var min = scores[0]; var max = scores[0]
    for (i in scores.indices) {
        if (scores[i] < min) {
            min = scores[i]
            countMin++
        } else if (scores[i] > max) {
            max = scores[i]
            countMax++
        }
    }
    return intArrayOf(countMax, countMin)
}


internal class BreakingRecordsTest {

    @Test
    fun `test breakingRecords`() {
        val sample0 = intArrayOf(10, 5, 20, 20, 4, 5, 2, 25, 1)
        var result = breakingRecords(sample0)
        assertEquals(2, result!![0])
        assertEquals(4, result[1])
        val sample1 = intArrayOf(3, 4, 21, 36, 10, 28, 35, 5, 24, 42)
        result = breakingRecords(sample1)
        assertEquals(4, result!![0])
        assertEquals(0, result[1])
    }

}