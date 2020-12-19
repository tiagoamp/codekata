package hackerrank;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

// https://www.hackerrank.com/challenges/find-digits/problem
public class FindDigits {

	@Test
	@DisplayName("Test given samples")
	void testFindDigits() {
		int[] input = { 12, 1012 }, expected = { 2, 3 };
		for (int i = 0; i < expected.length; i++) {
			int result = findDigits(input[i]);
			assertEquals(expected[i], result);			
		}
	}
	
	public static int findDigits(int n) {
		int curr = n, counter = 0;
		while (curr > 0) {
		    if ( (curr % 10 != 0) && (n % (curr % 10) == 0) )
		    	counter++;
		    curr = curr / 10;
		}
		return counter;
    }
	
}
