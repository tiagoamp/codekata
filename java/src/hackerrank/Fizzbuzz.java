package hackerrank;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Fizzbuzz {

	public static List<String> fizzbuzz(int n) {
		List<String> result = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			if (i >= (3*5) && i % 3 == 0 && n % 5 == 0)
				result.add("FizzBuzz");
			else if (i >= 3 && i % 3 == 0)
				result.add("Fizz");
			else if (i >= 5 && i % 5 == 0)
				result.add("Buzz");
			else
				result.add(String.valueOf(i));
		}
		return result;
	}


	@Test
	@DisplayName("Test given samples")
	void testFizzBuzz() {
		int n = 15;
		List<String> result = fizzbuzz(n);
		assertEquals("1", result.get(0));
		assertEquals("2", result.get(1));
		assertEquals("Fizz", result.get(2));
		assertEquals("4", result.get(3));
		assertEquals("Buzz", result.get(4));
	}
	
}
