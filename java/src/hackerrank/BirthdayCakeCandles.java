package hackerrank;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

// https://www.hackerrank.com/challenges/birthday-cake-candles/problem
public class BirthdayCakeCandles {

	public static int birthdayCakeCandles(int[] arr) {
		Arrays.sort(arr);
		int lastIndex = arr.length -1;
		int tallest = arr[lastIndex];
		int count = 0;
		for (int i = lastIndex; i >= 0; i--) {
			if (arr[i] == tallest) count++;
			else break;
		}
		return count;
	}

	
	@Test
	@DisplayName("Test sample")
	void testBirthdayCakeCandles1() {
		int[] arr = {3, 2, 1, 3};
		int result = birthdayCakeCandles(arr);
		assertEquals(2, result);		
	}
	
	@Test
	@DisplayName("Test threshold case")
	void testBirthdayCakeCandles2() {
		int n = 100000;
		int[] arr = new int[n];
		for (int i=0; i<n; i++) 
			arr[i] = 9999999;
		int result = birthdayCakeCandles(arr);
		assertEquals(100000, result);		
	}
	
}
