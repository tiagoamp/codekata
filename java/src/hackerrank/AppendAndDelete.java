package hackerrank;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

//https://www.hackerrank.com/challenges/append-and-delete/problem
public class AppendAndDelete {
		
	@Test 
	void testAppendAndDelete() {
		String s = "hackerhappy", t = "hackerrank"; int k = 9;
		String result = appendAndDelete(s, t, k);
		assertEquals("Yes", result);
		s = "aba"; t = "aba"; k = 7;
		result = appendAndDelete(s, t, k);
		assertEquals("Yes", result);
		s = "ashley"; t = "ash"; k = 2;
		result = appendAndDelete(s, t, k);
		assertEquals("No", result);
		s = "y"; t = "yu"; k = 2;
		result = appendAndDelete(s, t, k);
		assertEquals("No", result);
		s = "asdfqwertyuighjkzxcvasdfqwertyuighjkzxcvasdfqwertyuighjkzxcvasdfqwertyuighjkzxcvasdfqwertyuighjkzxcv"; 
		t = "asdfqwertyuighjkzxcvasdfqwertyuighjkzxcvasdfqwertyuighjkzxcvasdfqwertyuighjkzxcvasdfqwertyuighjkzxcv";
		k = 20;
		result = appendAndDelete(s, t, k);
		assertEquals("Yes", result);
		s = "abcd"; t = "abcdert"; k = 10;
		result = appendAndDelete(s, t, k);
		assertEquals("No", result);
		s = "abcdef"; t = "fedcba"; k = 15;
		result = appendAndDelete(s, t, k);
		assertEquals("Yes", result);
		s = "aaa"; t = "a"; k = 5;
		result = appendAndDelete(s, t, k);
		assertEquals("Yes", result);
    }
	
	
	public static String appendAndDelete(String s, String t, int k) {
    	if (s.equals(t)) {
    		if (k > s.length()) return k > 2 ? "Yes" : "No";
    		else return k%2 == 0 ? "Yes" : "No"; 
    	}    		
    	int commonChars = -1;  // find out index until 't' equals 's' 
    	for (int i = 0; i < s.length(); i++) {
    		if ( (i > (t.length()-1)) || s.charAt(i) != t.charAt(i) )
    			break;
			commonChars++;  // increment if same char in both strings
		}
    	String diffOfS = s.substring(commonChars+1);
    	String diffOfT = t.substring(commonChars+1);
    	if (diffOfS.length() == 0) {
    		return k >= diffOfT.length() && (k - diffOfT.length())%2 == 0 ? "Yes": "No";
    	} else if (diffOfT.length() == 0) {
    		return k >= diffOfS.length() && (k > s.length() || (k - diffOfS.length())%2 == 0) ? "Yes": "No";
    	} 
    	if (k > diffOfS.length()+diffOfT.length()) return k > 2 ? "Yes" : "No";
    	return (k >= diffOfS.length()+diffOfT.length()) && (k - diffOfS.length()+diffOfT.length())%2==0 ? "Yes" : "No";
    }

}
