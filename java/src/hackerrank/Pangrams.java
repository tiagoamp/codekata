package hackerrank;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

// https://www.hackerrank.com/challenges/pangrams/problem
public class Pangrams {

	@Test
	@DisplayName("Test given samples")
	public void testPangrams() {
		String[] s = { "We promptly judged antique ivory buckles for the next prize", 
				       "We promptly judged antique ivory buckles for the prize" };
		String[] expected = { "pangram", "not pangram" };
		for (int i = 0; i < expected.length; i++) {
			String result = pangrams(s[i]);
			assertEquals(expected[i], result);			
		}
	}

	
	public static String pangrams(String s) {
    	final String letters = "abcdefghijklmnopqrstuvxywz";
    	char[] charArr = letters.toCharArray();
    	int[] qt = new int[charArr.length];    	
    	if (s == null || s.length() < charArr.length)
    		return "not pangram";    	
    	for (int i=0; i<s.length(); i++) {
    		char currChar = s.toLowerCase().charAt(i);
    		for(int j=0; j<charArr.length; j++) {
    			if (currChar == charArr[j]) {
    				qt[j]++;
    				break;
    			}
    		}
    	}    	
    	boolean result = true;
    	for(int j=0; j<charArr.length; j++) 
    		result = result && (qt[j] > 0);
    	return result ? "pangram" : "not pangram";	
    }
	
}
