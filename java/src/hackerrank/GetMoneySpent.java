package hackerrank;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

// https://www.hackerrank.com/challenges/electronics-shop/problem
public class GetMoneySpent {

	public static int getMoneySpent(int[] keyboards, int[] drives, int b) {
		List<Integer> results = new ArrayList<>();
		for (int i = 0; i < keyboards.length; i++) {
			for (int j = 0; j < drives.length; j++) {
				int sum = keyboards[i] + drives[j];
				if (b >= sum) results.add(sum);
			}
		}
		return results.isEmpty() ? -1 : Collections.max(results);
	}


	@Test
	@DisplayName("Test sample 0")
	void testGetMoneySpent0() {
		int[] keyboards0 = {3,1}, drives0 = {5,2,8}; 
		int b = 10, expected = 9;
		int result = getMoneySpent(keyboards0, drives0, b);
		assertEquals(expected, result);
	}
	
	@Test
	@DisplayName("Test sample 1")
	void testGetMoneySpent() {
		int[] keyboards1 = {4}, drives1 = {5}; 
		int b = 5, expected = -1;
		int result = getMoneySpent(keyboards1, drives1, b);
		assertEquals(expected, result);
	}
	
}
