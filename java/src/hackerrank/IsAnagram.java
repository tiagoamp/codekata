package hackerrank;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


// https://www.hackerrank.com/challenges/java-anagrams/problem
public class IsAnagram {

	
	@Test
	@DisplayName("Test sample 0")
	void testIsAnagram0() {
		String a = "anagram", b = "margana";
		List<Boolean> results = Arrays.asList( isAnagram_Solution1(a, b), isAnagram_Solution2(a, b) );
		results.forEach(result -> assertTrue(result));
	}
	
	@Test
	@DisplayName("Test sample 1")
	void testIsAnagram1() {
		String a = "anagramm", b = "marganaa";
		List<Boolean> results = Arrays.asList( isAnagram_Solution1(a, b), isAnagram_Solution2(a, b) );
		results.forEach(result -> assertFalse(result));
	}
	
	@Test
	@DisplayName("Test sample 2")
	void testIsAnagram2() {
		String a = "Hello", b = "hello";
		List<Boolean> results = Arrays.asList( isAnagram_Solution1(a, b), isAnagram_Solution2(a, b) );
		results.forEach(result -> assertTrue(result));
	}
	
	
	public static boolean isAnagram_Solution1(String a, String b) {
    	if (a.length() != b.length()) return false;
    	int len = a.length();
    	Map<Character, Integer> resultFrequency = new HashMap<>();
    	for(int i=0; i<len; i++) 
    		resultFrequency.compute(a.toLowerCase().charAt(i), (k,v) -> (v == null) ? 1 : v+1);
    	for(int i=0; i<len; i++) 
    		resultFrequency.computeIfPresent(b.toLowerCase().charAt(i), (k,v) -> v-1);
    	Integer absSum = resultFrequency.values().stream().reduce(0, (x,y) -> Math.abs(x)+Math.abs(y));
    	return absSum == 0;
    }
	
	public static boolean isAnagram_Solution2(String a, String b) {
		char[] aCharArr = a.toLowerCase().toCharArray();
		char[] bCharArr = b.toLowerCase().toCharArray();
		Arrays.sort( aCharArr );
		Arrays.sort( bCharArr );
		return String.valueOf(aCharArr).equals(String.valueOf(bCharArr));
	}
	
}
