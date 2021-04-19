package hackerrank;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

//https://www.hackerrank.com/challenges/the-hurdle-race/problem
public class HurdleRace {

	public static int hurdleRace(int k, int[] height) {
		Arrays.sort(height);
		int max = height[height.length-1];
		return k >= max ? 0 : (max-k);
	}


	@Test
	@DisplayName("Test given samples")
	void testHurdleRace() {
		int k0 = 4, k1 = 7;
		int[] height0 = {1, 6, 3, 5, 2}, height1 = {2, 5, 4, 5, 2};
		int result0 = hurdleRace(k0, height0);
		int result1 = hurdleRace(k1, height1);
		assertEquals(2, result0);
		assertEquals(0, result1);
	}
	
}
