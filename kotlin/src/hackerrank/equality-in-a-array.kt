package hackerrank

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

// https://www.hackerrank.com/challenges/equality-in-a-array/problem

fun equalizeArray_solution3(arr: Array<Int>): Int {
    var mostFreqNr = arr[0]
    val map : MutableMap<Int, Int> = emptyMap<Int,Int>().toMutableMap()
    arr.forEach { n: Int ->
        map[n] =  map[n]?.plus(1) ?: 1
        if (map[mostFreqNr]!! < map[n]!!)
            mostFreqNr = n
    }
    return arr.size - map[mostFreqNr]!!
}

fun equalizeArray_solution2(arr: Array<Int>): Int {
    val map : MutableMap<Int, Int> = emptyMap<Int,Int>().toMutableMap()
    arr.forEach { it -> map[it] = map.getOrDefault(it, 0) + 1 }
    var mostFreqNr: Int = map.keys.fold(arr[0], { highest, n -> if (map[n]!! > map[highest]!!) n else highest } )
    return arr.fold(0,  { acc, n -> if (n != mostFreqNr) acc+1 else acc })
}

fun equalizeArray_solution1(arr: Array<Int>): Int {
    val map : MutableMap<Int, Int> = emptyMap<Int,Int>().toMutableMap()
    arr.forEach { it -> map[it] = map.getOrDefault(it, 0) + 1 }
    var mostFreqNr = arr[0]
    for (n in arr) {
        if (map[n]!! > map[mostFreqNr]!!)
            mostFreqNr = n
    }
    return arr.filter { it -> it != mostFreqNr }.size
}


internal class EqualizeArrayTest {

    @Test
    @DisplayName("Test sample input 0")
    fun equalizeArray0() {
        val arr = arrayOf(3, 3, 2, 1, 3)
        val expected = 2
        val result3 = equalizeArray_solution3(arr)
        val result2 = equalizeArray_solution2(arr)
        val result1 = equalizeArray_solution1(arr)
        assertEquals(result1, result2)
        assertEquals(result2, result3)
        assertEquals(expected, result2)
    }

    @Test
    @DisplayName("Test sample input 1")
    fun equalizeArray1() {
        val arr = arrayOf(1, 2, 3, 1, 2, 3, 3, 3)
        val expected = 4
        val result3 = equalizeArray_solution3(arr)
        val result2 = equalizeArray_solution2(arr)
        val result1 = equalizeArray_solution1(arr)
        assertEquals(result1, result2)
        assertEquals(result2, result3)
        assertEquals(expected, result2)
    }

}
