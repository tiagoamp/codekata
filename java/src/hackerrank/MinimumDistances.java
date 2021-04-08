package hackerrank;

// https://www.hackerrank.com/challenges/minimum-distances/problem

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinimumDistances {

    static int minimumDistances_solution2(int[] a) {
        int minDist = a.length+1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<a.length; i++) {
            int curr = a[i];
            if (map.get(curr) == null) {
                map.put(curr,i);
                continue;
            }
            int dist = i - map.get(curr);
            if ( dist < minDist )
                minDist = dist;
            map.put(curr,i);
        }
        return minDist == a.length+1 ? -1 : minDist;
    }

    static int minimumDistances_solution1(int[] a) {
        int minDist = a.length+1;
        for (int i=0; i<(a.length-1); i++) {
            for (int j=i+1; j<a.length; j++) {
                if (a[i] == a[j] && (j-i) < minDist)
                    minDist = j-i;
            }
        }
        return (minDist == a.length+1) ? -1 : minDist;
    }


    @Test
    @DisplayName("Test sample input 0")
    void minimumDistances0() {
        int[] arr = {7, 1, 3, 4, 1, 7};
        int expected = 3;
        int result2 = minimumDistances_solution2(arr);
        int result1 = minimumDistances_solution1(arr);
        assertEquals(expected, result2);
        assertEquals(result1, result2);
    }

    @Test
    @DisplayName("Test sample input 8")
    void minimumDistances8() {
        int[] arr = {1, 1};
        int expected = 1;
        int result2 = minimumDistances_solution2(arr);
        int result1 = minimumDistances_solution1(arr);
        assertEquals(expected, result2);
        assertEquals(result1, result2);
    }

}
