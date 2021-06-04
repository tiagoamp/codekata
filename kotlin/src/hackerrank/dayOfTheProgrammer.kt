package hackerrank

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

// https://www.hackerrank.com/challenges/day-of-the-programmer/problem

fun dayOfProgrammer(year: Int): String {
    var day: Int = 13
    if (year == 1918)
        day += 13  // lost days from Feb 1st to Feb 14th
    if (year.isLeap())
        day -= 1;
    return "$day.09.$year"
}

fun Int.isLeap(): Boolean {
    if (this <= 1918)
        return this % 4 == 0
    return this % 400 == 0 || (this % 4 == 0 && this % 100 != 0)
}


internal class DayOFProgrammerTest {

    @Test
    @DisplayName("Test sample input 0")
    fun test0() {
        val year: Int = 2017
        val expected = "13.09.2017"
        val result: String = dayOfProgrammer(year)
        assertEquals(expected, result)
    }

    @Test
    @DisplayName("Test sample input 1")
    fun test1() {
        val year: Int = 2016
        val expected = "12.09.2016"
        val result: String = dayOfProgrammer(year)
        assertEquals(expected, result)
    }

    @Test
    @DisplayName("Test sample input 0")
    fun test2() {
        val year: Int = 1800
        val expected = "12.09.1800"
        val result: String = dayOfProgrammer(year)
        assertEquals(expected, result)
    }

    @Test
    @DisplayName("Test sample input 11")
    fun test11() {
        val year: Int = 1916
        val expected = "12.09.1916"
        val result: String = dayOfProgrammer(year)
        assertEquals(expected, result)
    }

}