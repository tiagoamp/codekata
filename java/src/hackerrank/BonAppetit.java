package hackerrank;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

// https://www.hackerrank.com/challenges/bon-appetit/problem
public class BonAppetit {

	public static String bonAppetit(List<Integer> bill, int k, int b) {
		Integer total = bill.stream().reduce(0, (acc, e) -> acc + e);
		int actualCharge = (total - bill.get(k)) / 2;
		return (b == actualCharge) ? "Bon Appetit" : String.valueOf(b - actualCharge);
	}


	@Test
	@DisplayName("Test given samples")
	void testBonAppetit() {
		List<Integer> bill = Arrays.asList(3, 10, 2, 9);
		int k = 1, b = 12;
		String result = bonAppetit(bill, k, b);
		assertEquals("5", result);
		b = 7;
		result = bonAppetit(bill, k, b);
		assertEquals("Bon Appetit", result);
		bill = Arrays.asList(72, 53, 60, 66, 90, 62, 12, 31, 36, 94);
		k = 6; b = 288;
		result = bonAppetit(bill, k, b);
		assertEquals("6", result);		
	}
	
}
