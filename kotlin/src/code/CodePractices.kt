package code

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
