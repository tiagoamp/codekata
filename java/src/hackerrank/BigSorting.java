package hackerrank;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.jupiter.api.Test;

//https://www.hackerrank.com/challenges/big-sorting/problem
public class BigSorting {
	
	@Test
	void testBigSorting() {
		String[] input = {"1", "2", "100", "12303479849857341718340192371", "3084193741082937", "3084193741082938", "111", "200"};
		String[] result = bigSorting(input);
		String[] expected = {"1", "2", "100", "111", "200", "3084193741082937", "3084193741082938", "12303479849857341718340192371"};
		assertEquals(Arrays.toString(expected), Arrays.toString(result));
	}
	
	
	public static String[] bigSorting(String[] unsorted) {    	
    	String[] result = Arrays.stream(unsorted).sorted(comparator).toArray(String[]::new);    	
        return result;
    }
	
	private static Comparator<String> comparator = (a, b) -> {
		// different sizes
        if (a.length() != b.length()) 
            return a.length() - b.length();
        // same sizes, compare per digits
        for (int i = 0; i < a.length(); i++) {
        	Integer digitFromA = Character.getNumericValue(a.charAt(i));
        	Integer digitFromB = Character.getNumericValue(b.charAt(i));
            if (digitFromA != digitFromB) 
            	return digitFromA - digitFromB;
        }
        // numbers are the same.
        return 0;
     };
	
}
