package hackerrank;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

// https://www.hackerrank.com/challenges/time-conversion/problem
public class TimeConversion {

	public static String timeConversion(String s) {
		if (s.endsWith("AM")) {
			if (s.startsWith("12:")) {
				String[] timeFields = s.split(":");
				timeFields[0] = "00";
				s = String.join(":", timeFields);
			}
			return s.replace("AM", "");
		}
		// pm
		if (s.startsWith("12:")) return s.replace("PM", "");
		s = s.replace("PM", "");
		String[] timeFields = s.split(":");
		timeFields[0] = String.valueOf(Integer.valueOf(timeFields[0]) + 12);
		return String.join(":", timeFields);
	}


	@Test
	@DisplayName("Test given samples")
	void testTimeConversion() {
		String[] samples = { "07:05:45PM", "12:00:00AM", "12:00:00PM", "12:40:22AM", "12:45:54PM" };
		String[] expected = { "19:05:45", "00:00:00", "12:00:00", "00:40:22", "12:45:54" };
		for (int i = 0; i < expected.length; i++) { 
			String result = timeConversion(samples[i]);
			assertEquals(expected[i], result);
		}
    }

}
