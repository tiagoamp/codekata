package hackerrank;

// https://www.hackerrank.com/challenges/lisa-workbook/problem

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LisaWorkbook {

    public static int workbook(int n, int k, List<Integer> arr) {
        int nrOfSpecialProblems = 0;
        int page = 1;
        for (Integer nrOfProblems: arr) { // problems per chapter
            int problemCount = 0;
            while (problemCount < nrOfProblems) {
                int pgFirstProblem = problemCount + 1;
                int pgLastProblem = (nrOfProblems <= k) ? nrOfProblems
                    : ( (problemCount + k <= nrOfProblems) ? problemCount + k : problemCount + (nrOfProblems % k) );
                final int currPage = page;
                if ( IntStream.rangeClosed(pgFirstProblem,pgLastProblem).filter(i -> i == currPage).findFirst().isPresent() )
                    nrOfSpecialProblems++;
                problemCount = pgLastProblem;
                page++;
            }
        }
        return nrOfSpecialProblems;
    }


    @Test
    @DisplayName("Test sample input 0")
    void test0() {
        int n = 5, k = 3, expected = 4;
        List<Integer> arr = Arrays.asList(4, 2, 6, 1, 10);
        int result = workbook(n, k, arr);
        assertEquals(expected, result);
    }

}
