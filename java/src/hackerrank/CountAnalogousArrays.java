package hackerrank;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CountAnalogousArrays {

	public static int countAnalogousArrays(List<Integer> consecutiveDifference, int lowerBound, int upperBound) {
		int counter = 0;
		for (int curr = lowerBound; curr <= upperBound; curr++) {
			boolean isAnalogousRow = checkAnalogousRow(curr, consecutiveDifference, lowerBound, upperBound);
			if (isAnalogousRow) 
				counter++;
		}
		return counter;
	}
	
	
	private static boolean checkAnalogousRow(int value, List<Integer> consecutiveDifference, int lowerBound, int upperBound) {
		for (int i = 0; i < consecutiveDifference.size(); i++) {
			value -= consecutiveDifference.get(i);
			if (value < lowerBound || value > upperBound) 
				return false;
		}
		return true;
	}
	
	
	
	@Test
	@DisplayName("Test sample case")
	void testCountAnalogousArrays() {
		List<Integer> consecutiveDifference = Arrays.asList(-2, -1, -2, 5);
		int lowerBound = 3, upperBound = 10;
		int expected = 3;
		int result = countAnalogousArrays(consecutiveDifference, lowerBound, upperBound);
		assertEquals(expected, result);
	}
	
}
