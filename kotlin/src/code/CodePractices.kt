package code

import kotlin.math.abs
import kotlin.math.ceil
import kotlin.math.min

fun lowestTriangle(base: Int, area: Int) = ceil(area * 2.0 / base.toFloat()).toInt()

fun maximumDraws(n: Int) = ( (n * 2) / 2 ) + 1

fun bonAppetit(bill: Array<Int>, k: Int, b: Int): String {
    val total = bill.sum()
    val actualCharge = (total - bill[k]) / 2
    return if (b == actualCharge) "Bon Appetit" else (b - actualCharge).toString()
}

fun getMoneySpent(keyboards: IntArray, drives: IntArray, b: Int): Int {
    val results: MutableList<Int> = ArrayList()
    for (i in keyboards.indices) {
        for (j in drives.indices) {
            val sum = keyboards[i] + drives[j]
            if (b >= sum) results.add(sum)
        }
    }
    return if (results.isEmpty()) -1 else results.max()!!
}

fun queensAttack(n: Int, k: Int, r_q: Int, c_q: Int, obstacles: Array<IntArray>): Int {
    // if board size just fit the queen spot, return 0
    if (n == 0 || n == 1) return 0

    // if there are no obstacles, return all queen's cells to be attacked
    if (k == 0) {
        val qRowsCount = n - 1 + (n - 1)
        val qDiagCount = min(n - r_q, c_q - 1) + min(r_q - 1, c_q - 1) +
                min(n - r_q, n - c_q) + min(r_q - 1, n - c_q)
        return qRowsCount + qDiagCount
    }

    // Identify the closest obstacle in each 8 directions
    var minDistanceObLeft = c_q - 1
    var minDistanceObRight = n - c_q
    var minDistanceObUp = n - r_q
    var minDistanceObDown = r_q - 1
    var minDistanceObLeftUp = min(n - r_q, c_q - 1)
    var minDistanceObLeftDown = min(r_q - 1, c_q - 1)
    var minDistanceObRightUp = min(n - r_q, n - c_q)
    var minDistanceObRightDown = min(r_q - 1, n - c_q)
    for (i in 0 until k) {
        val r_o = obstacles[i][0]
        val c_o = obstacles[i][1]

        // case same row
        if (r_o == r_q) {
            if (c_o < c_q && c_q - c_o - 1 < minDistanceObLeft) {
                minDistanceObLeft = c_q - c_o - 1
            } else if (c_o > c_q && c_o - c_q - 1 < minDistanceObRight) {
                minDistanceObRight = c_o - c_q - 1
            }
        }
        // case same column
        if (c_o == c_q) {
            if (r_o > r_q && r_o - r_q - 1 < minDistanceObUp) {
                minDistanceObUp = r_o - r_q - 1
            } else if (r_o < r_q && r_q - r_o - 1 < minDistanceObDown) {
                minDistanceObDown = r_q - r_o - 1
            }
        }
        // case same diagonals
        if (abs(r_q - r_o) == abs(c_q - c_o)) {
            val distance = abs(r_q - r_o) - 1
            if (r_o > r_q && c_o < c_q && distance < minDistanceObLeftUp)
                minDistanceObLeftUp = distance
            else if (r_o < r_q && c_o < c_q && distance < minDistanceObLeftDown)
                minDistanceObLeftDown = distance
            else if (r_o > r_q && c_o > c_q && distance < minDistanceObRightUp)
                minDistanceObRightUp = distance
            else if (r_o < r_q && c_o > c_q && distance < minDistanceObRightDown)
                minDistanceObRightDown = distance
        }
    }
    return minDistanceObLeft + minDistanceObRight + minDistanceObUp + minDistanceObDown +
            minDistanceObLeftUp + minDistanceObLeftDown + minDistanceObRightUp + minDistanceObRightDown
}

fun saveThePrisoner(n: Int, m: Int, s: Int): Int {
    val r = s + (m - 1)
    if (r <= n) return r
    return if (r % n == 0) n else r % n
}

fun formingMagicSquare(s: Array<IntArray>): Int {
    val costs = intArrayOf(0, 0, 0, 0, 0, 0, 0, 0)
    val magicSquares = arrayOf(intArrayOf(2, 7, 6, 9, 5, 1, 4, 3, 8), intArrayOf(6, 7, 2, 1, 5, 9, 8, 3, 4), intArrayOf(8, 3, 4, 1, 5, 9, 6, 7, 2), intArrayOf(4, 3, 8, 9, 5, 1, 2, 7, 6), intArrayOf(6, 1, 8, 7, 5, 3, 2, 9, 4), intArrayOf(2, 9, 4, 7, 5, 3, 6, 1, 8), intArrayOf(4, 9, 2, 3, 5, 7, 8, 1, 6), intArrayOf(8, 1, 6, 3, 5, 7, 4, 9, 2))
    for (i in magicSquares.indices) {
        costs[i] = abs(magicSquares[i][0] - s[0][0]) + abs(magicSquares[i][1] - s[0][1]) + abs(magicSquares[i][2] - s[0][2])
        costs[i] = costs[i] + abs(magicSquares[i][3] - s[1][0]) + abs(magicSquares[i][4] - s[1][1]) + abs(magicSquares[i][5] - s[1][2])
        costs[i] = costs[i] + abs(magicSquares[i][6] - s[2][0]) + abs(magicSquares[i][7] - s[2][1]) + abs(magicSquares[i][8] - s[2][2])
    }
    return costs.min()!!;
}

fun utopianTree(n: Int): Int {
    var result = 1
    if (n == 0) return result
    for (i in 1..n) {
        val shouldDoubleSize = i % 2 != 0 // odd numbers double size
        result = if (shouldDoubleSize) result * 2 else result + 1
    }
    return result
}

fun birthdayChoc(s: List<Int>?, d: Int, mv: Int): Int {
    var m = mv; var result = 0; var index = 0
    if (s == null || s.isEmpty()) return result
    var isOver = m > s.size
    while (!isOver) {
        val inner = s.subList(index, m)
        val sum = inner.stream().reduce(0) { x: Int, y: Int -> x + y }
        if (sum.toInt() == d) result++
        index++
        m++
        isOver = m > s.size
    }
    return result
}

fun sockMerchant(n: Int, arr: IntArray): Int {
    val colors: MutableSet<Int> = HashSet()
    var pairs = 0
    for (i in 0 until n) {
        if (!colors.contains(arr[i])) {
            colors.add(arr[i])
        } else {
            pairs++
            colors.remove(arr[i])
        }
    }
    return pairs
}

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

fun birthdayCakeCandles(arr: IntArray): Int {
    arr.sort()
    val lastIndex = arr.size - 1
    val tallest = arr[lastIndex]
    var count = 0
    for (i in lastIndex downTo 0) {
        if (arr[i] == tallest) count++ else break
    }
    return count
}

/* Fibonacci starting at 0. Fibonacci series should be as follows: 0, 1, 1, 2, 3, 5, 8, 13, etc... */
fun fibonacci(n: Int): Int {
    return when(n) {
        0 -> 0
        1, 2 -> 1
        else -> fibonacci(n - 2) + fibonacci(n - 1)
    }
}

fun minMaxSum(arr: IntArray): LongArray? {
    arr.sort()
    var min: Long = 0
    var max: Long = 0
    val len = 5
    for (i in arr.indices) {
        if (i < len - 1) min += arr[i]
        if (i > 0) max += arr[i]
    }
    return longArrayOf(min, max)
}

fun countApplesAndOranges(s: Int, t: Int, a: Int, b: Int, apples: IntArray, oranges: IntArray): IntArray {
    var appleCount = 0
    for (i in apples.indices) {
        val distance = apples[i] + a
        if (distance in s..t) appleCount++
    }
    var orangeCount = 0
    for (i in oranges.indices) {
        val distance = oranges[i] + b
        if (distance in s..t) orangeCount++
    }
    return intArrayOf(appleCount, orangeCount)
}


