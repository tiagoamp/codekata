package code;

import static code.CodePractices.bonAppetit;
import static code.CodePractices.findDigits;
import static code.CodePractices.fizzbuzz;
import static code.CodePractices.getMoneySpent;
import static code.CodePractices.lowestTriangle;
import static code.CodePractices.maximumDraws;
import static code.CodePractices.plusMinus;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;


public class CodePracticesTest {
	
	// https://www.hackerrank.com/challenges/find-digits/problem
	@Test
	public void testFindDigits() {
		int input0 = 12, input1 = 1012;
		int expected0 = 2, expected1 = 3;
		int result0 = findDigits(input0);
		int result1 = findDigits(input1);
		assertEquals(expected0, result0);
		assertEquals(expected1, result1);
	}
		
	// https://www.hackerrank.com/challenges/lowest-triangle/problem
	@Test
	public void testLowestTriangle() {
		int b = 2, a = 2;
		int result = lowestTriangle(b, a);
		assertEquals(2, result);
		b = 17; a = 100;
		result = lowestTriangle(b, a);
		assertEquals(12, result);
	}
	
	// https://www.hackerrank.com/challenges/maximum-draws/problem
	@Test
	public void testMaximumDraws() {
		int n = 1;
		int result = maximumDraws(n);
		assertEquals(2, result);
		n = 2;
		result = maximumDraws(n);		
		assertEquals(3, result);
	}
	
	@Test
	public void testFizzBuzz() {
		int n = 15;
		List<String> result = fizzbuzz(n);
		assertEquals("1", result.get(0));
		assertEquals("2", result.get(1));
		assertEquals("Fizz", result.get(2));
		assertEquals("4", result.get(3));
		assertEquals("Buzz", result.get(4));
	}
	
	// https://www.hackerrank.com/challenges/bon-appetit/problem
	@Test
	public void testBonAppetit() {
		List<Integer> bill = Arrays.asList(3, 10, 2, 9);
		int k = 1, b = 12;
		String result = bonAppetit(bill, k, b);
		assertEquals("5", result);
		b = 7;
		result = bonAppetit(bill, k, b);
		assertEquals("Bon Appetit", result);
		bill = Arrays.asList(72, 53, 60, 66, 90, 62, 12, 31, 36, 94);
		k = 6; b = 288;
		result = bonAppetit(bill, k, b);
		assertEquals("6", result);		
	}
	
	
	// https://www.hackerrank.com/challenges/electronics-shop/problem
	@Test
	public void testGetMoneySpent() {
		int[] keyboards0 = {3,1}, drives0 = {5,2,8}; 
		int b = 10, expected = 9;
		int result = getMoneySpent(keyboards0, drives0, b);
		assertEquals(expected, result);
		int[] keyboards1 = {4}, drives1 = {5}; 
		b = 5; expected = -1;
		result = getMoneySpent(keyboards1, drives1, b);
		assertEquals(expected, result);
	}
	
	// https://www.hackerrank.com/challenges/plus-minus/problem
	@Test
	public void testPlusMinus() {
		int[] input = {-4, 3, -9, 0, 4, 1};
		String[] result = plusMinus(input);
		assertEquals("0.500000", result[0]);
		assertEquals("0.333333", result[1]);
		assertEquals("0.166667", result[2]);
    }
			
}
