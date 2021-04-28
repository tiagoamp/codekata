package hackerrank

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals


// https://www.hackerrank.com/challenges/halloween-sale/problem

fun howManyGames(p: Int, d: Int, m: Int, s: Int): Int {
    var nrOfGames = 0; var budget = s; var currGameVal = p
    while (currGameVal <= budget) {
        nrOfGames++
        budget -= currGameVal
        currGameVal = if ( (currGameVal-d) >= m ) (currGameVal - d) else m
    }
    return nrOfGames
}


internal class HalloweenSaleTest {

    @Test
    @DisplayName("Test sample 0")
    fun howManyGames0() {
        val p = 20; val d = 3;  val m = 6; val s = 80; val expected = 6;
        val result = howManyGames(p, d, m, s)
        assertEquals(expected, result)
    }

    @Test
    @DisplayName("Test sample 1")
    fun howManyGames1() {
        val p = 20; val d = 3;  val m = 6; val s = 85; val expected = 7;
        val result = howManyGames(p, d, m, s)
        assertEquals(expected, result)
    }

}