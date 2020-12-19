package hackerrank;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

// https://www.hackerrank.com/challenges/lowest-triangle/problem
public class LowestTriangle {
	
	@Test
	@DisplayName("Test given samples")
	void testLowestTriangle() {
		int[] b = { 2, 17 }, a = { 2, 100 }, expected = { 2, 12};
		for (int i = 0; i < expected.length; i++) {
			int result = lowestTriangle(b[i], a[i]);
			assertEquals(expected[i], result);
		}
	}
	

	public static int lowestTriangle(int base, int area){
		return (int) Math.ceil( (area * 2.0) / (float)base ) ;
    }
	
}
