package hackerrank;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

// https://www.hackerrank.com/challenges/beautiful-triplets/problem
public class BeautifulTriplets {

    static int beautifulTriplets_Solution2(int d, int[] arr) {
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        return list.stream().reduce(0, (acc, n) -> (list.contains(n+d) && list.contains(n+2*d)) ? acc+1 : acc);
    }

    static int beautifulTriplets_Solution1(int d, int[] arr) {
        int result = 0;
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        for (int n: list) {
            if (list.contains(n+d) && list.contains(n+2*d))
                result++;
        }
        return result;
    }


    @Test
    @DisplayName("Test sample input 0")
    void beautifulTriplets0() {
        int[] arr = {1, 2, 4, 5, 7, 8, 10};
        int d = 3, expected = 3;
        int result2 = beautifulTriplets_Solution2(d, arr);
        int result1 = beautifulTriplets_Solution1(d, arr);
        assertEquals(expected, result2);
    }

}
