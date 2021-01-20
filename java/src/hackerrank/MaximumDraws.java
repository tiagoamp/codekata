package hackerrank;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

// https://www.hackerrank.com/challenges/maximum-draws/problem
public class MaximumDraws {

	public static int maximumDraws(int n) {
		return ( (n * 2) / 2 ) + 1;
	}


	@Test
	@DisplayName("Test given samples")
	void testMaximumDraws() {
		int[] n = { 1, 2 }, expected = { 2, 3 };
		for (int i = 0; i < expected.length; i++) {
			int result = maximumDraws(n[i]);
			assertEquals(expected[i], result);
		}
	}
	
}
