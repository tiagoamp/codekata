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

    // https://www.hackerrank.com/challenges/sock-merchant/problem
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

    // https://www.hackerrank.com/challenges/breaking-best-and-worst-records/problem
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

    // https://www.hackerrank.com/challenges/birthday-cake-candles/problem
    @Test
    fun `test birthdayCakeCandles`() {
        var arr = intArrayOf(3, 2, 1, 3)
        var result = birthdayCakeCandles(arr)
        assertEquals(2, result)
        val n = 100000  // threshold case
        arr = IntArray(n)
        for (i in 0 until n) arr[i] = 9999999
        result = birthdayCakeCandles(arr)
        assertEquals(100000, result)
    }

    @Test
    fun `test Fibonacci_positionEquals10`() {
        val result = fibonacci(10)
        assertEquals(55, result)
    }

    // https://www.hackerrank.com/challenges/mini-max-sum/problem
    @Test
    fun `test minMaxSum`() {
        val arr = intArrayOf(1, 2, 3, 4, 5)
        val result = minMaxSum(arr)
        assertEquals(10L, result!![0])
        assertEquals(14L, result[1])
    }

    // https://www.hackerrank.com/challenges/apple-and-orange/problem
    @Test
    fun `test countApplesAndOranges`() {
        // sample case
        var s = 7; var t = 11 // house
        var a = 5; var b = 15 // tree
        var apples = intArrayOf(-2, 2, 1)
        var oranges = intArrayOf(5, -6) // fruits array
        var result = countApplesAndOranges(s, t, a, b, apples, oranges)
        assertEquals(1, result[0])
        assertEquals(1, result[1])
        // test case 2
        s = 2; t = 3; a = 1; b = 5
        apples = intArrayOf(2)
        oranges = intArrayOf(-2)
        result = countApplesAndOranges(s, t, a, b, apples, oranges)
        assertEquals(1, result[0])
        assertEquals(1, result[1])
    }

    // https://www.hackerrank.com/challenges/super-digit/problem
    @Test
    fun `test superdit`() {
        var n = "148"; var k = 3; var expected = 3
        var result = superdigit(n,k)
        assertEquals(expected, result)
        n = "9875"; k = 4; expected = 8
        result = superdigit(n,k)
        assertEquals(expected, result)
        n = "123"; k = 3; expected = 9
        result = superdigit(n,k)
        assertEquals(expected, result)
        n = "100000"; k = 100000  // superior threshold
        result = superdigit(n,k)
        assertTrue(result > 0)
    }

}