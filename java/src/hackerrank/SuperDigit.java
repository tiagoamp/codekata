package hackerrank;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.IntStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


//https://www.hackerrank.com/challenges/super-digit/problem
public class SuperDigit {
	
	@Test
	@DisplayName("Test given samples")
	void testSuperdit() {
		// given
		String[] n = { "148", "9875", "123" };
		Integer[] k = { 3, 4, 3};
		Integer[] expected = { 3, 8, 9 }; 
		// when 
		int[] results = IntStream.range(0, expected.length).map(i -> superdigit(n[i], k[i])).toArray();
		// then 
		for (int i = 0; i < results.length; i++)
			assertEquals(expected[i], results[i]);
	}
	
	@Test
	@DisplayName("Test superior threshold")
	public void testSuperdit_limit() {
		String n = "100000"; int k = 100000;
		int result = superdigit(n,k);
		assertTrue(result > 0);
	}
	
	
	// Superdigit = sum of digits until its result has only 1 digit 
	public static int superdigit(String n, int k) {
		if (n.length() <= 1) return Integer.parseInt(n);
		int sum = 0;
		for (int i = 0; i < n.length(); i++) {
			Integer digit = Character.getNumericValue(n.charAt(i));
			sum += digit;
		}		
		if (k > 1) sum *= k;
		return superdigit(String.valueOf(sum), 1);
	}

}
