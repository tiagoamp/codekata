package hackerrank;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;


//https://www.hackerrank.com/challenges/mini-max-sum/problem
public class MiniMaxSum {
	
	@Test
	void testMinMaxSum() {
		int[] arr = {1, 2, 3, 4, 5};
		long[] result = minMaxSum(arr);
		assertEquals(10L, result[0]);
		assertEquals(14L, result[1]);
	}
	
	
	public static long[] minMaxSum(int[] arr) {
    	Arrays.sort(arr);
    	long min = 0, max = 0;
    	final int len = 5;    	
    	for (int i = 0; i < arr.length; i++) {
			if (i < len-1) min += arr[i];
			if (i > 0) max += arr[i];
		}
    	return new long[] {min,max};
    }

}
