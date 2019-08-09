package code;

import static code.CodePractices.bestDivisor;
import static code.CodePractices.bigSorting;
import static code.CodePractices.birthdayCakeCandles;
import static code.CodePractices.birthdayChoc;
import static code.CodePractices.breakingRecords;
import static code.CodePractices.catAndMouse;
import static code.CodePractices.countApplesAndOranges;
import static code.CodePractices.fibonacci;
import static code.CodePractices.gradingStudents;
import static code.CodePractices.hurdleRace;
import static code.CodePractices.kangaroo;
import static code.CodePractices.minMaxSum;
import static code.CodePractices.minPrice;
import static code.CodePractices.sockMerchant;
import static code.CodePractices.staircase;
import static code.CodePractices.superdigit;
import static code.CodePractices.utopianTree;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
	
	@Test
	public void testBirthdayCakeCandles() {
		int[] arr = {3, 2, 1, 3};
		int result = birthdayCakeCandles(arr);
		assertEquals(2, result);
		// threshold case 
		int n = 100000;
		arr = new int[n];
		for (int i=0; i<n; i++) {
			arr[i] = 9999999;
		}
		result = birthdayCakeCandles(arr);
		assertEquals(100000, result);		
	}
	
	@Test
	public void testKangaroo() {
		int x1 = 0, v1 = 3, x2 = 4, v2 = 2;
		String result = kangaroo(x1, v1, x2, v2);
		assertTrue(result.equals("YES"));
		x1 = 0; v1 = 2; x2 = 5; v2 = 3;
		result = kangaroo(x1, v1, x2, v2);
		assertTrue(result.equals("NO"));
		x1 = 43; v1 = 2; x2 = 70; v2 = 2;
		result = kangaroo(x1, v1, x2, v2);
		assertTrue(result.equals("NO"));
	}
	
	@Test
	public void testBreakingRecords() {
		int[] sample0 = {10, 5, 20, 20, 4, 5, 2, 25, 1};
		int[] result = breakingRecords(sample0);
		assertEquals(2, result[0]);
		assertEquals(4, result[1]);
		int[] sample1 = {3, 4, 21, 36, 10, 28, 35, 5, 24, 42};
		result = breakingRecords(sample1);
		assertEquals(4, result[0]);
		assertEquals(0, result[1]);
		
	}
	
	@Test
	public void testSockMerchant() {
		int n = 9;
		int[] arr = {10, 20, 20, 10, 10, 30, 50, 10, 20};
		int result = sockMerchant(n, arr);
		assertEquals(3, result);
		n = 10;
		arr = new int[]{1, 1, 3, 1, 2, 1, 3, 3, 3, 3};
		result = sockMerchant(n, arr);
		assertEquals(4, result);		
	}
	
	@Test
	public void testMinPrice() {
		List<List<Integer>> cost = new ArrayList<>();
		// sample 0
		cost.add( Arrays.asList(1,2,2) );
		cost.add( Arrays.asList(2,2,1) );
		cost.add( Arrays.asList(2,1,2) );
		int result = minPrice(cost);
		assertEquals(3, result);
		// sample 1
		cost.clear();
		cost.add( Arrays.asList(1,2,2) );
		cost.add( Arrays.asList(2,3,3) );
		cost.add( Arrays.asList(3,3,1) );
		result = minPrice(cost);
		assertEquals(5, result);
		// sample 3
		cost.clear();
		cost.add( Arrays.asList(1,10,20) );
		cost.add( Arrays.asList(2,100,100) );
		result = minPrice(cost);
		assertEquals(12, result);
	}
	
	@Test
	public void testBirthdayChoc() {
		List<Integer> s = Arrays.asList(1, 2, 1, 3, 2);
		int d = 3, m = 2;
		int result = birthdayChoc(s, d, m);
		assertEquals(2, result);
		s = Arrays.asList(1, 1, 1, 1, 1, 1);
		result = birthdayChoc(s, d, m);
		assertEquals(0, result);
		s = Arrays.asList(2, 5, 1, 3, 4, 4, 3, 5, 1, 1, 2, 1, 4, 1, 3, 3, 4, 2, 1);
		d = 18; m = 7;
		result = birthdayChoc(s, d, m);
		assertEquals(3, result);		
	}
	
	@Test
	public void testBigSorting() {
		String[] input = {"1", "2", "100", "12303479849857341718340192371", "3084193741082937", "3084193741082938", "111", "200"};
		String[] result = bigSorting(input);
		String[] expectedArr = {"1", "2", "100", "111", "200", "3084193741082937", "3084193741082938", "12303479849857341718340192371"};
		assertEquals(Arrays.toString(expectedArr), Arrays.toString(result));
	}
	
	@Test
	public void testCatAndMouse() {
		int x = 1, y = 2, z = 3;
		String result = catAndMouse(x, y, z);
		assertEquals("Cat B", result);
		x = 1; y = 3; z = 2;
		result = catAndMouse(x, y, z);
		assertEquals("Mouse C", result);
	}
	
	@Test
	public void testGradingStudents() {
		List<Integer> input = Arrays.asList(73, 67, 38, 33);
		List<Integer> expected = Arrays.asList(75, 67, 40, 33);
		List<Integer> result = gradingStudents(input);
		for (int i = 0; i < result.size(); i++) {
			assertEquals(expected.get(i), result.get(i));
		}
	}
	
	@Test
	public void testHurdleRace() {
		int k0 = 4, k1 = 7;
		int[] height0 = {1, 6, 3, 5, 2}, height1 = {2, 5, 4, 5, 2};
		int result = hurdleRace(k0, height0);
		assertEquals(2, result);
		result = hurdleRace(k1, height1);
		assertEquals(0, result);
	}
	
	@Test
	public void testUtopianTree() {
		Integer[] inputs = {0, 1, 4};
		Integer[] expected = {1, 2, 7};
		for (int i=0; i<inputs.length; i++) {
			assertEquals(expected[i].intValue(), utopianTree(inputs[i]));
		}
	}
	

}
