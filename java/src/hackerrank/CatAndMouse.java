package hackerrank;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

//https://www.hackerrank.com/challenges/cats-and-a-mouse/problem
public class CatAndMouse {
	
	@Test
	@DisplayName("Test given samples")
	void testCatAndMouse() {
		int[] x = { 1, 1 }, y = { 2, 3 }, z = { 3, 2 };
		String[] expected = { "Cat B", "Mouse C" };
		for (int i = 0; i < expected.length; i++) {
			String result = catAndMouse(x[i], y[i], z[i]);	
			assertEquals(expected[i], result);
		}
	}
	
	public static String catAndMouse(int x, int y, int z) {
    	int distanceCatAFromMouse = Math.abs(z - x);
    	int distanceCatBFromMouse = Math.abs(z - y);
    	if (distanceCatAFromMouse == distanceCatBFromMouse) return "Mouse C";
    	return distanceCatAFromMouse < distanceCatBFromMouse ? "Cat A" : "Cat B";
    }
	
}
