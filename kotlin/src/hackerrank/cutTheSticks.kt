package hackerrank

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

// https://www.hackerrank.com/challenges/cut-the-sticks/problem

fun cutTheSticks_IterativeSolution(arr: Array<Int>): Array<Int> {
    val result = mutableListOf<Int>()
    var inputArr : Array<Int> = arr.clone()
    while (inputArr.isNotEmpty()) {
        val min = inputArr.min()
        if (min != null) {
            result.add(inputArr.size)
            inputArr = inputArr.filter { it: Int -> it != min }
                            .map { it: Int -> it - min }
                            .toTypedArray()
        }
    }
    return result.toTypedArray()
}

fun cutTheSticks_RecursiveSolution(arr: Array<Int>): Array<Int> {
    var result = mutableListOf<Int>()
    result = cutArray(arr, result)
    return result.toTypedArray()
}

private fun cutArray(input: Array<Int>, output: MutableList<Int>): MutableList<Int> {
    if (input.isEmpty()) return output
    var inputArr = input.clone()
    val min = inputArr.min()
    if (min != null) {
        output.add(inputArr.size)
        inputArr = inputArr.filter { it: Int -> it != min }
                    .map { it: Int -> it - min }
                    .toTypedArray()
    }
    return cutArray(inputArr, output)
}


internal class CutTheSticksTest {

    @Test
    @DisplayName("Test sample input 0")
    fun cutTheSticks0() {
        val arr = arrayOf<Int>(5, 4, 4, 2, 2, 8)
        val expected = arrayOf<Int>(6, 4, 2, 1)
        val result2 = cutTheSticks_RecursiveSolution(arr)
        val result1 = cutTheSticks_IterativeSolution(arr)
        assertArrayEquals(expected, result2)
        assertArrayEquals(expected, result1)
    }

    @Test
    @DisplayName("Test sample input 1")
    fun cutTheSticks1() {
        val arr = arrayOf(1, 2, 3, 4, 3, 3, 2, 1)
        val expected = arrayOf(8, 6, 4, 1)
        val result2 = cutTheSticks_RecursiveSolution(arr)
        val result1 = cutTheSticks_IterativeSolution(arr)
        assertArrayEquals(expected, result2)
        assertArrayEquals(expected, result1)
    }

}