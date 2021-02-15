package code

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue


internal class CodePracticesKtTest {

    // https://www.hackerrank.com/challenges/lowest-triangle/problem
    @Test
    fun `lowestTriangle`() {
        var b = 2; var a = 2
        var result = lowestTriangle(b, a)
        assertEquals(2, result)
        b = 17; a = 100
        result = lowestTriangle(b, a)
        assertEquals(12, result)
    }

    // https://www.hackerrank.com/challenges/maximum-draws/problem
    @Test
    fun `test maximumDraws`() {
        var n = 1
        var result = maximumDraws(n)
        assertEquals(2, result)
        n = 2
        result = maximumDraws(n)
        assertEquals(3, result)
    }

    // https://www.hackerrank.com/challenges/bon-appetit/problem
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

    // https://www.hackerrank.com/challenges/electronics-shop/problem
    @Test
    fun `test getMoneySpent`() {
        val keyboards0 = intArrayOf(3, 1)
        val drives0 = intArrayOf(5, 2, 8)
        var b = 10; var expected = 9
        var result = getMoneySpent(keyboards0, drives0, b)
        assertEquals(expected, result)
        val keyboards1 = intArrayOf(4)
        val drives1 = intArrayOf(5)
        b = 5; expected = -1
        result = getMoneySpent(keyboards1, drives1, b)
        assertEquals(expected, result)
    }

    // https://www.hackerrank.com/challenges/queens-attack-2/problem
    @Test
    fun `test queensAttack`() {
        var n = 4; var k = 0
        var r_q = 4; var c_q = 4
        var obstacles = Array(0) { IntArray(2) }
        val expected0 = 9
        val result0 = queensAttack(n, k, r_q, c_q, obstacles)
        assertEquals(expected0, result0)
        n = 8; k = 0; r_q = 4; c_q = 4
        obstacles = Array(0) { IntArray(2) }
        val expected = 27
        val result = queensAttack(n, k, r_q, c_q, obstacles)
        assertEquals(expected, result)
        n = 5; k = 3; r_q = 4; c_q = 3
        obstacles = Array(k) { IntArray(2) }
        obstacles[0][0] = 5; obstacles[0][1] = 5
        obstacles[1][0] = 4; obstacles[1][1] = 2
        obstacles[2][0] = 2; obstacles[2][1] = 3
        val expected1 = 10
        val result1 = queensAttack(n, k, r_q, c_q, obstacles)
        assertEquals(expected1, result1)
        n = 1; k = 0; r_q = 1; c_q = 1
        obstacles = Array(0) { IntArray(2) }
        val expected2 = 0
        val result2 = queensAttack(n, k, r_q, c_q, obstacles)
        assertEquals(expected2, result2)
    }

    // https://www.hackerrank.com/challenges/save-the-prisoner/problem
    @Test
    fun `test saveThePrisoner`() {
        var n = 5; var m = 2; var s = 1
        var expected = 2
        var result = saveThePrisoner(n, m, s)
        assertEquals(expected, result)
        n = 5; m = 2; s = 2
        expected = 3
        result = saveThePrisoner(n, m, s)
        assertEquals(expected, result)
        n = 7; m = 19; s = 2
        expected = 6
        result = saveThePrisoner(n, m, s)
        assertEquals(expected, result)
        n = 3; m = 7; s = 3
        expected = 3
        result = saveThePrisoner(n, m, s)
        assertEquals(expected, result)
        n = 352926151; m = 380324688; s = 94730870
        expected = 122129406
        result = saveThePrisoner(n, m, s)
        assertEquals(expected, result)
    }

    // https://www.hackerrank.com/challenges/magic-square-forming/problem
    @Test
    fun `test formingMagicSquare`() {
        val sample0 = arrayOf(intArrayOf(4, 9, 2), intArrayOf(3, 5, 7), intArrayOf(8, 1, 5))
        val sample1 = arrayOf(intArrayOf(4, 8, 2), intArrayOf(4, 5, 7), intArrayOf(6, 1, 6))
        val expectedResult0 = 1; val expectedResult1 = 4
        var result = formingMagicSquare(sample0)
        assertEquals(expectedResult0, result)
        result = formingMagicSquare(sample1)
        assertEquals(expectedResult1, result)
    }

    // https://www.hackerrank.com/challenges/utopian-tree/problem
    @Test
    fun `test utopianTree`() {
        val inputs = arrayOf(0, 1, 4)
        val expected = arrayOf(1, 2, 7)
        for (i in inputs.indices) assertEquals(expected[i], utopianTree(inputs[i]))
    }

    // https://www.hackerrank.com/challenges/the-birthday-bar/problem
    @Test
    fun `test birthdayChoc`() {
        var s = listOf(1, 2, 1, 3, 2)
        var d = 3; var m = 2
        var result = birthdayChoc(s, d, m)
        assertEquals(2, result)
        s = listOf(1, 1, 1, 1, 1, 1)
        result = birthdayChoc(s, d, m)
        assertEquals(0, result)
        s = listOf(2, 5, 1, 3, 4, 4, 3, 5, 1, 1, 2, 1, 4, 1, 3, 3, 4, 2, 1)
        d = 18; m = 7
        result = birthdayChoc(s, d, m)
        assertEquals(3, result)
    }

}