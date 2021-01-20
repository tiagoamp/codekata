package hackerrank;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

// https://www.hackerrank.com/challenges/counting-valleys/problem
public class CountingValleys {

	public static int countingValleys(int n, String s) {
		int countOfValleys = 0, path = 0, seaLevel = 0;
		boolean enteredValley = false;
		for (int i = 0; i < n; i++) {
			Character letter = s.charAt(i);
			if (letter.equals('U')) path += 1;
			else if (letter.equals('D')) path -= 1;
			if (path == seaLevel && enteredValley)
				countOfValleys++;
			enteredValley = path < 0;
		}
		return countOfValleys;
	}


	@Test
	@DisplayName("Test given sample")
	public void testCountingValleys() {
		int n = 8; String s = "UDDDUDUU";
		int result = countingValleys(n, s);
		assertEquals(1, result);		
	}
	
}
