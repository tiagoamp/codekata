package hackerrank;

// https://www.hackerrank.com/challenges/jumping-on-the-clouds/problem

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JumpingOnClouds {

    public static int jumpingOnClouds(List<Integer> c) {
        int jumps = 0, index = 0;
        while ( index < (c.size()-1) ) {
            index += (index+2 < c.size() && c.get(index+2) == 0) ? 2 : 1;
            jumps++;
        }
        return jumps;
    }


    @Test
    @DisplayName("Test sample input 0")
    void test0() {
        List<Integer> c = Arrays.asList(0, 0, 1, 0, 0, 1, 0);
        var expected = 4;
        var result = jumpingOnClouds(c);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test sample input 1")
    void test1() {
        List<Integer> c = Arrays.asList(0, 0, 0, 0, 1, 0);
        var expected = 3;
        var result = jumpingOnClouds(c);
        assertEquals(expected, result);
    }

}
