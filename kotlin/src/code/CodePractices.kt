package code


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
