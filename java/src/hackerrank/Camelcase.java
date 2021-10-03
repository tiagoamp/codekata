package hackerrank;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


// https://www.hackerrank.com/challenges/camelcase/problem

public class Camelcase {

	public static int camelcase(String s) {
		if (s == null || s.isEmpty()) return 0;
		long count = s.chars().filter(Character::isUpperCase).count();
		return (int) count + 1;
    }

	
	@Test
	@DisplayName("Test sample 0")
	public void testInput0() {
		String s = "saveChangesInTheEditor";
		int expected = 5;
		int result = camelcase(s);
		assertEquals(expected, result);
	}
	
}
