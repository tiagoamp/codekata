package hackerrank;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

//https://www.hackerrank.com/challenges/picking-numbers/problem
public class PickingNumbers {
		
	@Test
	@DisplayName("Test given samples")
	void testPickingNumbers() {
		List<Integer> sample0 = Arrays.asList(4, 6, 5, 3, 3, 1), sample1 = Arrays.asList(1, 2, 2, 3, 1, 2);
		List<List<Integer>> samples = Arrays.asList( sample0, sample1 );
		int[] expected =  { 3, 5 };
		for (int i = 0; i < expected.length; i++) {
			int result = pickingNumbers(samples.get(i));
			assertEquals(expected[i], result);			
		}
	}

	public static int pickingNumbers(List<Integer> input) {
        Map<Integer, Integer> map = new TreeMap<>();
        input.forEach(i -> {
        	Integer qtt = map.getOrDefault(i, 0);
        	map.put(i, qtt+1);
        });
        int maxRange = map.keySet().stream()
        		.map(k -> map.get(k) + map.getOrDefault(k+1, 0)).max(Integer::compare).get();
        return maxRange;
    }
	
}
