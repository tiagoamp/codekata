package hackerrank;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.regex.Pattern;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MinimumNumber {

	private static final int MIN_PASS_LEN = 6;

	public static int minimumNumber(int n, String password) {
		int minCharsToAdd = 0;
		if (!Pattern.compile("[0-9]").matcher(password).find()) minCharsToAdd++;
		if (!Pattern.compile("[a-z]").matcher(password).find()) minCharsToAdd++;
		if (!Pattern.compile("[A-Z]").matcher(password).find()) minCharsToAdd++;
		if (!Pattern.compile("[!@#\\$%^&*()\\-\\+]").matcher(password).find()) minCharsToAdd++;
		if ( (password.length() + minCharsToAdd) < MIN_PASS_LEN )
			minCharsToAdd += MIN_PASS_LEN - (password.length() + minCharsToAdd);
		return minCharsToAdd;
	}


	@Test
	@DisplayName("Test given samples")
	void testMinimumNumber() {
		int[] n = { 3, 11, 7 };
		String[] password = { "Ab1", "#HackerRank", "AUzs-nV" };
		int[] expected = { 3, 1, 1 };
		for (int i = 0; i < expected.length; i++) {
			int result = minimumNumber(n[i], password[i]);			
			assertEquals(expected[i], result);
		}
	}
	
}
