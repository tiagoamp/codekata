package code;

import static code.CodePractices.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CodePracticesTest {
		
	@Test
	public void test_bestDivisor() {
		int sample = 12, expectedVal = 6;
		int result = bestDivisor(sample);
		assertEquals(expectedVal, result);
	}
	
	@Test
	public void testSuperdit() {
		String n = "148"; int k = 3, expected = 3, result = 0;
		result = superdigit(n,k);
		assertEquals(expected, result);
		n = "9875"; k = 4; expected = 8;
		result = superdigit(n,k);
		assertEquals(expected, result);
		n = "123"; k = 3; expected = 9;
		result = superdigit(n,k);
		assertEquals(expected, result);
		// superior threshold 
		n = "100000"; k = 100000;
		result = superdigit(n,k);
		assertTrue(result > 0);
	}
	
	@Test
	public void testCountApplesAndOranges() {
		// sample case
		int s = 7, t = 11;  // house
		int a = 5, b = 15;  // tree
		int[] apples = {-2, 2, 1};   // fruits array
		int[] oranges = {5, -6};     // fruits array
		int[] result = countApplesAndOranges(s, t, a, b, apples, oranges);
		assertEquals(1, result[0]);
		assertEquals(1, result[1]);
		// test case 2
		s = 2; t = 3;
		a = 1; b = 5;
		apples = new int[] {2};
		oranges = new int[] {-2};
		result = countApplesAndOranges(s, t, a, b, apples, oranges);
		assertEquals(1, result[0]);
		assertEquals(1, result[1]);
	}
	
	@Test
	public void testMinMaxSum() {
		int[] arr = {1, 2, 3, 4, 5};
		long[] result = minMaxSum(arr);
		assertEquals(10L, result[0]);
		assertEquals(14L, result[1]);
	}
	
	@Test
	public void testFibonacci_positionEquals10() {
		int result = fibonacci(10);
		assertEquals(55, result);
	}
	
	@Test
	public void testStaircase() {
		int n = 6;
		Character[][] result = staircase(n);
		for (int i = 0; i < n; i++) assertEquals(result[0][i].toString(), String.valueOf( (i >= 5) ? '#' : ' ') );
		for (int i = 0; i < n; i++) assertEquals(result[1][i].toString(), String.valueOf( (i >= 4) ? '#' : ' ') );
		for (int i = 0; i < n; i++) assertEquals(result[5][i].toString(), String.valueOf( (i >= 0) ? '#' : ' ') );
	}

}
