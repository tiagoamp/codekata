package hackerrank;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;


//https://www.hackerrank.com/challenges/breaking-best-and-worst-records/problem
public class BreakingBestAndWorstRecords {
	
	@Test
	void testBreakingRecords() {
		int[] sample0 = {10, 5, 20, 20, 4, 5, 2, 25, 1};
		int[] result = breakingRecords(sample0);
		assertEquals(2, result[0]);
		assertEquals(4, result[1]);
		int[] sample1 = {3, 4, 21, 36, 10, 28, 35, 5, 24, 42};
		result = breakingRecords(sample1);
		assertEquals(4, result[0]);
		assertEquals(0, result[1]);		
	}
	
	public static int[] breakingRecords(int[] scores) {
    	int countMin = 0, countMax = 0;
    	int min = scores[0], max = scores[0];
    	for (int i = 0; i < scores.length; i++) {
			if (scores[i] < min) {
				min = scores[i];
				countMin++;
			} else if (scores[i] > max) {
				max = scores[i];
				countMax++;
			}
		}
    	return new int[]{countMax, countMin};
    }
	
}
