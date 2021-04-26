package hackerrank;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// https://www.hackerrank.com/challenges/halloween-sale/problem
public class HalloweenSale {

    static int howManyGames(int p, int d, int m, int s) {
        int nrOfGames = 0, budget = s, currGameVal = p;
        while (currGameVal <= budget) {
            nrOfGames++;
            budget -= currGameVal;
            currGameVal = ( (currGameVal-d) >= m ) ? (currGameVal - d) : m;
        }
        return nrOfGames;
    }


    @Test
    @DisplayName("Test sample input 0")
    void howManyGames0() {
        int p = 20, d = 3, m = 6, s = 80, expected = 6;
        int result = howManyGames(p, d, m, s);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test sample input 1")
    void howManyGames1() {
        int p = 20, d = 3, m = 6, s = 85, expected = 7;
        int result = howManyGames(p, d, m, s);
        assertEquals(expected, result);
    }

}
