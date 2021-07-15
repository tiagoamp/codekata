package hackerrank

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

// https://www.hackerrank.com/challenges/cavity-map/problem

fun cavityMap(grid: Array<String>): Array<String> {
    return grid.mapIndexed { index, str ->
        if (index == 0 || index == grid.size - 1) str
        else transformRow(str, grid[index - 1], grid[index + 1])
    }.toTypedArray()
}

fun transformRow(row: String, rowAbove: String, rowBelow: String): String {
    var transformedRow = row
    for ((index, value) in row.withIndex()) {
        val isBorderCell = index == 0 || index == row.length-1
        if (isBorderCell) continue;
        val v = value.toString().toInt()
        val isCavity = v > rowAbove[index].toString().toInt() && v > rowBelow[index].toString().toInt()
                && v > row[index-1].toString().toInt() && v > row[index+1].toString().toInt()
        if (isCavity)
            transformedRow = setCharAtPosition(index, 'X', transformedRow)
    }
    return transformedRow
}

fun setCharAtPosition(index: Int, char: Char, string: String): String {
    var charArr = string.toCharArray()
    charArr[index] = 'X'
    return String(charArr)
}


internal class CavityMapTest {

    @Test
    @DisplayName("Test sample input 0")
    fun test0() {
        val grid: Array<String> = arrayOf("1112", "1912", "1892", "1234")
        val expected: Array<String> = arrayOf("1112", "1X12", "18X2", "1234")
        val result = cavityMap(grid)
        assertArrayEquals(expected, result)
    }

    @Test
    @DisplayName("Test sample input 1")
    fun test1() {
        val grid: Array<String> = arrayOf("9")
        val expected: Array<String> = arrayOf("9")
        val result = cavityMap(grid)
        assertArrayEquals(expected, result)
    }

}