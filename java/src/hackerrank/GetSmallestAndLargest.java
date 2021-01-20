package hackerrank;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

// https://www.hackerrank.com/challenges/java-string-compare/problem
public class GetSmallestAndLargest {

	public static String getSmallestAndLargest(String s, int k) {
		List<String> substrings = new ArrayList<>();
		for(int i=0; i<=s.length()-k; i++)
			substrings.add(s.substring(i, i+k));
		String smallest = substrings.stream().sorted().min(String::compareTo).get();
		String largest = substrings.stream().sorted().max(String::compareTo).get();
		return smallest + "\n" + largest;
	}


	@Test
	@DisplayName("Test given sample")
	void testGetSmallestAndLargest() {
		String s = "welcometojava"; int k = 3;
		String result = getSmallestAndLargest(s, k);
		assertTrue(result.contains("ava") && result.contains("wel"));
	}

}
