package hackerrank;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

//https://www.hackerrank.com/challenges/repeated-string/problem
public class RepeatedString {
	
	@Test
	@DisplayName("Test given samples")
	void testRepeatedString() {
		// given
		String sample0 = "aba"; long n0 = 10L; long expected0 = 7;
		String sample1 = "a"; long n1 = 1000000000000L; long expected1 = 1000000000000L;
		String sample7 = "kmretasscityylpdhuwjirnqimlkcgxubxmsxpypgzxtenweirknjtasxtvxemtwxuarabssvqdnktqadhyktagjxoanknhgilnm";
		long n7 = 736778906400L; long expected7 = 51574523448L;
		// when 
		long result0 = repeatedString(sample0, n0);
		long result1 = repeatedString(sample1, n1);
		long result7 = repeatedString(sample7, n7);
		// then 
		assertEquals(expected0, result0);
		assertEquals(expected1, result1);
		assertEquals(expected7, result7);
    }
	
	public static long repeatedString(String s, long n) {
    	if (s.length() == 1) return s.equals("a") ? n : 0L;
    	if (!s.contains("a")) return 0L;
    	long count = 0;
    	for (char ch : s.toCharArray()) 
			if (ch == 'a') count++;
        long d = n / s.length();
        long r =  n % s.length();
        count *=  d;
        for(int i=0;i<r;i++)
            if(s.charAt(i) == 'a') count++;
        return count;
    }
	
}
