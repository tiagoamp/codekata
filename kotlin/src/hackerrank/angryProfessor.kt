package hackerrank

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals


// https://www.hackerrank.com/challenges/angry-professor/problem

fun angryProfessor(k: Int, a: Array<Int>): String {
    val onTime = a.filter { n -> n <= 0 }.count()
    return if (onTime >= k) "NO" else "YES"
}


internal class AngryProfessorTest {

    @Test
    @DisplayName("Test sample A")
    fun angryProfessorA() {
        val k = 3
        val a = arrayOf(-1, -3, 4, 2)
        val expected = "YES"
        val result = angryProfessor(k, a)
        assertEquals(expected, result)
    }

    @Test
    @DisplayName("Test sample B")
    fun angryProfessorB() {
        val k = 2
        val a = arrayOf(0, -1, 2, 1)
        val expected = "NO"
        val result = angryProfessor(k, a)
        assertEquals(expected, result)
    }

    @Test
    @DisplayName("Test edge cases")
    fun angryProfessor() {
        val k = 2
        val a = arrayOf(0, -100, 100)
        val expected = "NO"
        val result = angryProfessor(k, a)
        assertEquals(expected, result)
    }
}