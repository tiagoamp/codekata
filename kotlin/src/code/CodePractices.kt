package code


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

fun superdigit(n: String, k: Int) : Int {
    if (n.length <= 1) return n.toInt()
    var sum = 0
    for (ch in n) {
        val digit: Int = Character.getNumericValue(ch)
        sum += digit
    }
    if (k > 1) sum *= k
    return superdigit(sum.toString(), 1)
}

fun bestDivisor(input: Int) : Int {
    val divisors = (1..input).filter { input % it == 0 }
    val sums = divisors.map {
            var num = it
            var sum  = 0
            while (num > 0) {
                sum += num % 10
                num /= 10
            }
            sum
        }
    val maxSummedNr = sums.max()
    val indexOfMaxSummedNr = sums.indexOf(maxSummedNr)
    return divisors[indexOfMaxSummedNr]
}
