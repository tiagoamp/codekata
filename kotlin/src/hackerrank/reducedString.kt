package hackerrank

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

// https://www.hackerrank.com/challenges/reduced-string/problem

fun superReducedString(s: String): String {
    var r = s
    var wasReduced = true
    while (wasReduced) {
        var tokens = r.breakInRepeatedTokens()
        var reducedStr = ""
        for (token in tokens) {
            if (token.length.isOddCount())
                reducedStr += token[0]
        }
        wasReduced = reducedStr != r
        r = reducedStr
    }
    return if (r == "") "Empty String" else r
}

fun String.breakInRepeatedTokens() : List<String> {
    val tokens = mutableListOf<String>()
    if (this == "") return tokens
    var token = ""
    var currCh = this[0]
    for (ch in this) {
        if (ch == currCh) {
            token += ch
            continue
        }
        tokens.add(token)
        token = "" + ch
        currCh = ch
    }
    tokens.add(token)
    return tokens
}

fun Int.isOddCount() = this % 2 != 0


internal class SuperReducedStringTest {

    @Test
    @DisplayName("Test sample input 0")
    fun test() {
        val input = arrayOf("aaabccddd", "aa", "baab")
        val expected = arrayOf("abd", "Empty String", "Empty String")
        for ((i, s) in input.withIndex()) {
            val result = superReducedString(s)
            assertEquals(expected[i], result)
        }
    }

}