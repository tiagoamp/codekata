package hackerrank;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

//https://www.hackerrank.com/challenges/save-the-prisoner/problem
public class SaveThePrisoner {

	public static int saveThePrisoner(int n, int m, int s) {
		int r = s + (m-1);
		if (r <= n) return r;
		return (r%n == 0) ? n : r%n;
	}


	@Test
	void testSaveThePrisoner() {
		int[] n = { 5, 5, 7, 3, 352926151 }, m = { 2, 2, 19, 7, 380324688 }, 
				s = { 1, 2, 2, 3, 94730870}, expected = { 2, 3, 6, 3, 122129406 };
		for (int i = 0; i < expected.length; i++) {
			int result = saveThePrisoner(n[i], m[i], s[i]);
			assertEquals(expected[i], result);			
		}
	}
	
}
