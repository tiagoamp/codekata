package hackerrank;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Locale;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

// https://www.hackerrank.com/challenges/plus-minus/problem
public class PlusMinus {

	public static String[] plusMinus(int[] arr) {
		int positives = 0, negatives = 0, zeros = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) zeros++;
			else if (arr[i] > 0) positives++;
			else negatives++;
		}
		int length = arr.length;
		String[] results = new String[3];
		results[0] = String.format(Locale.US, "%.06f", ((double) positives) / ((double) length));
		results[1] = String.format(Locale.US, "%.06f", ((double) negatives) / ((double) length));
		results[2] = String.format(Locale.US, "%.06f", ((double) zeros) / ((double) length));
		return results;
	}


	@Test
	@DisplayName("Test given sample")
	void testPlusMinus() {
		int[] input = {-4, 3, -9, 0, 4, 1};
		String[] result = plusMinus(input);
		assertAll(() -> assertEquals("0.500000", result[0]), 
				  () -> assertEquals("0.333333", result[1]), 
				  () -> assertEquals("0.166667", result[2])
		);
    }

}
