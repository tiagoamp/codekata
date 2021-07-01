package hackerrank

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

// https://www.hackerrank.com/challenges/lisa-workbook/problem

fun workbook(n: Int, k: Int, arr: Array<Int>): Int {
    var nrOfSpecialProblems = 0
    var currPage = 1
    for (nrOfProblems in arr) { // problems per chapter
        var problemCount = 0
        while (problemCount < nrOfProblems) {
            val pgFirstProblem = problemCount + 1
            val pgLastProblem = when {
                nrOfProblems <= k -> nrOfProblems  // one page chapter
                else -> if (problemCount + k <= nrOfProblems) problemCount + k else problemCount + (nrOfProblems % k)
            }
            if ((pgFirstProblem..pgLastProblem).contains(currPage))
                nrOfSpecialProblems++
            problemCount = pgLastProblem
            currPage++
        }
    }
    return nrOfSpecialProblems
}


internal class WorkbookTest {

    @Test
    @DisplayName("Test sample input 0")
    fun test0() {
        val n = 5
        val k = 3
        val arr = arrayOf(4, 2, 6, 1, 10)
        val expected = 4
        val result = workbook(n, k, arr)
        assertEquals(expected, result)
    }

}