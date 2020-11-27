package hackerrank;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

//https://www.hackerrank.com/challenges/utopian-tree/problem
public class UtopianTree {
	
	@Test
	@DisplayName("Test given samples")
	void testUtopianTree() {
		Integer[] inputs = {0, 1, 4}, expected = {1, 2, 7};
		for (int i=0; i<inputs.length; i++) 
			assertEquals(expected[i].intValue(), utopianTree(inputs[i]));
	}
	
	public static int utopianTree(int n) {
    	int result = 1;
    	if (n == 0) return result;
    	for(int i=1; i <=n; i++) {
    		boolean shouldDoubleSize = i%2 != 0; // odd numbers double size
    		result = shouldDoubleSize ? result * 2 : result + 1; 
    	}
    	return result;
    }
	
}
