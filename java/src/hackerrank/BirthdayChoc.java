package hackerrank;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

//https://www.hackerrank.com/challenges/the-birthday-bar/problem
public class BirthdayChoc {

	public static int birthdayChoc(List<Integer> s, int d, int m) {
		int result = 0, index  = 0;
		if (s == null || s.isEmpty()) return result;
		boolean isOver = m > s.size();
		while (!isOver) {
			List<Integer> inner = s.subList(index, m);
			int sum = inner.stream().reduce(0, (x,y) -> x+y);
			if (sum == d) result++;
			index++;
			m++;
			isOver = m > s.size();
		}
		return result;
	}

	
	@Test
	@DisplayName("Test given samples")
	void testBirthdayChoc() {
		List<List<Integer>> s = Arrays.asList( Arrays.asList(1, 2, 1, 3, 2), Arrays.asList(1, 1, 1, 1, 1, 1), 
				Arrays.asList(2, 5, 1, 3, 4, 4, 3, 5, 1, 1, 2, 1, 4, 1, 3, 3, 4, 2, 1) );
		int[] d = { 3, 3, 18 }, m = { 2, 2, 7 }, expected = { 2, 0, 3 };
		for (int i = 0; i < expected.length; i++) {
			int result = birthdayChoc(s.get(i), d[i], m[i]);
			assertEquals(expected[i], result);
		}		
	}

}
