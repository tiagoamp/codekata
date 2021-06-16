package hackerrank;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

// https://www.hackerrank.com/challenges/kaprekar-numbers/problem
public class KaprekarNumbers {

    public static List<Long> kaprekarNumbers(int p, int q) {
        var filtered = LongStream.rangeClosed(p, q).filter(i -> {
            Long sq = i * i;
            String sqAsStr = sq.toString();
            int d = String.valueOf(i).length();
            String r = sqAsStr.substring(sqAsStr.length() - d);
            String l = (r.length() < sqAsStr.length()) ? sqAsStr.substring(0, sqAsStr.length() - r.length()) : "0";
            return Long.valueOf(l) + Long.valueOf(r) == i;
        }).mapToObj(Long::valueOf).collect(Collectors.toList());
//        if (filtered.isEmpty())
//            System.out.println("INVALID RANGE");
//        else
//            filtered.forEach(i -> System.out.print(i + " "));
        return filtered;
    }


    @Test
    @DisplayName("Test sample input 0")
    void test0() {
        int p = 1, q = 100;
        List<Long> expected = Arrays.asList(1L,9L,45L,55L,99L);
        List<Long> result = kaprekarNumbers(p, q);
        assertArrayEquals(expected.toArray(), result.toArray());
    }

}
