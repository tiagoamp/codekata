package hackerrank;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SplitIntoTwo {
	
	public static int splitIntoTwo(List<Integer> arr) {
		int result = 0, leftSum = 0, rightSum = arr.stream().reduce(0, (a, b) -> a + b);
		for (int i = 0; i < arr.size()-1; i++) {
			leftSum += arr.get(i);
			rightSum -= arr.get(i);
			if (leftSum > rightSum)
				result++;
		}
		return result;
	}
	
	
	@Test
	@DisplayName("Test sample case")
	void testSplitIntoTwo() {
		List<Integer> arr = Arrays.asList(10, 4, -8, 7);
		int expected = 2;
		int result = splitIntoTwo(arr);
		assertEquals(expected, result);
	}

}
