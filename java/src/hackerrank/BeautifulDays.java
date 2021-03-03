package hackerrank;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.IntStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

//https://www.hackerrank.com/challenges/beautiful-days-at-the-movies/problem
public class BeautifulDays {
	
	static int beautifulDays(int i, int j, int k) {
		return (int) IntStream.rangeClosed(i, j).boxed()
			.filter(n -> ( Math.abs(n - reverse(n)) % k == 0 ) ).count();
    }
		
	private static int reverse(int n) {
		int reversed = 0;
		while(n != 0) {
            int digit = n % 10;
            reversed = reversed * 10 + digit;
            n /= 10;
        }
		return reversed;
	}

	
	@Test
	@DisplayName("Test sample")
	public void testBeautifulDays() {
		int i = 20, j = 23, k = 6, expected = 2;
		int result = beautifulDays(i, j, k);
		assertEquals(expected, result);
	}
	
	@Test
	@DisplayName("Test sample 3")
	public void testBeautifulDays3() {
		int i = 1, j = 2000000, k = 23047885, expected = 2998;
		int result = beautifulDays(i, j, k);
		assertEquals(expected, result);
	}
	
	@Test
	@DisplayName("Test sample 5")
	public void testBeautifulDays5() {
		int i = 1, j = 2000000, k = 1000000000, expected = 2998;
		int result = beautifulDays(i, j, k);
		assertEquals(expected, result);
	}
	
}
