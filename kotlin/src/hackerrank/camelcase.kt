package hackerrank

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

// https://www.hackerrank.com/challenges/camelcase/problem

fun camelcase(s: String): Int {
    if (s.isNullOrBlank()) return 0
    var count = s.toCharArray().filter { it.isUpperCase() }.count()
    return count + 1
}


internal class CamelcaseTest {

    @Test
    @DisplayName("Test sample input 0")
    fun test() {
        val s = "saveChangesInTheEditor"
        val expected: Int = 5
        val result = camelcase(s)
        assertEquals(expected, result)
    }

}
