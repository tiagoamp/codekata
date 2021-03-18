package hackerrank;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

// https://www.hackerrank.com/challenges/angry-professor/problem

public class AngryProfessor {

	static String angryProfessor(int k, int[] a) {
		var onTime = Arrays.stream(a).filter(n -> n <= 0).count();
		return onTime >= k ? "NO" : "YES";
    }
	
	
	@Test
	@DisplayName("Test sample A")
	public void angryProfessorA() {
		int k = 3; int[] a = {-1, -3, 4, 2}; String expected = "YES";
		String result = angryProfessor(k, a);
		assertEquals(expected, result);
	}
	
	@Test
	@DisplayName("Test sample B")
	public void angryProfessorB() {
		int k = 2; int[] a = {0, -1, 2, 1}; String expected = "NO";
		String result = angryProfessor(k, a);
		assertEquals(expected, result);
	}
	
	@Test
	@DisplayName("Test edge cases")
	public void angryProfessor() {
		int k = 2; int[] a = {0, -100, 100}; String expected = "NO";
		String result = angryProfessor(k, a);
		assertEquals(expected, result);
	}
	
}
