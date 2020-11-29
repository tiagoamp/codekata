package code;

import static code.CodePractices.bonAppetit;
import static code.CodePractices.countingValleys;
import static code.CodePractices.findDigits;
import static code.CodePractices.fizzbuzz;
import static code.CodePractices.getMoneySpent;
import static code.CodePractices.getSmallestAndLargest;
import static code.CodePractices.isAnagram;
import static code.CodePractices.lowestTriangle;
import static code.CodePractices.maximumDraws;
import static code.CodePractices.minimumNumber;
import static code.CodePractices.pangrams;
import static code.CodePractices.plusMinus;
import static code.CodePractices.timeConversion;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
	
	// https://www.hackerrank.com/challenges/counting-valleys/problem
	@Test
	public void testCountingValleys() {
		int n = 8; String s = "UDDDUDUU";
		int result = countingValleys(n, s);
		assertEquals(1, result);		
	}
	
	// https://www.hackerrank.com/challenges/java-string-compare/problem
	@Test
	public void testGetSmallestAndLargest() {
		String s = "welcometojava"; int k = 3;
		String result = getSmallestAndLargest(s, k);
		assertTrue(result.contains("ava") && result.contains("wel"));
	}
	
	// https://www.hackerrank.com/challenges/java-anagrams/problem
	@Test
	public void testIsAnagram() {
		String a = "anagram", b = "margana";
		boolean result = isAnagram(a, b);
		assertTrue(result);
		a = "anagramm"; b = "marganaa";
		result = isAnagram(a, b);
		assertFalse(result);
		a = "Hello"; b = "hello";
		result = isAnagram(a, b);
		assertTrue(result);
	}
	
	// https://www.hackerrank.com/challenges/pangrams/problem
	@Test
	public void testPangrams() {
		String s = "We promptly judged antique ivory buckles for the next prize";
		String result = pangrams(s);
		assertEquals("pangram", result);
		s = "We promptly judged antique ivory buckles for the prize";
		result = pangrams(s);
		assertEquals("not pangram", result);
	}
	
	@Test
	public void testMinimumNumber() {
		int n = 3; String password = "Ab1";
		int result = minimumNumber(n, password);
		assertEquals(3, result);
		n = 11; password = "#HackerRank";
		result = minimumNumber(n, password);
		assertEquals(1, result);
		n = 7; password = "AUzs-nV";
		result = minimumNumber(n, password);
		assertEquals(1, result);
	}

	// https://www.hackerrank.com/challenges/time-conversion/problem
	@Test
	public void testTimeConversion() {
        String sample0 = "07:05:45PM", expected0 = "19:05:45";
        String result = timeConversion(sample0);
        assertEquals(expected0, result);
        String sample = "12:00:00AM", expected = "00:00:00";
        result = timeConversion(sample);
        assertEquals(expected, result);
        sample = "12:00:00PM"; expected = "12:00:00";
        result = timeConversion(sample);
        assertEquals(expected, result);
        String sample1 = "12:40:22AM", expected1 = "00:40:22";
        result = timeConversion(sample1);
        assertEquals(expected1, result);
        String sample4 = "12:45:54PM", expected4 = "12:45:54";
        result = timeConversion(sample4);
        assertEquals(expected4, result);        
    }
	
}
