package code;

import static code.CodePractices.appendAndDelete;
import static code.CodePractices.bonAppetit;
import static code.CodePractices.climbingLeaderboard;
import static code.CodePractices.countingValleys;
import static code.CodePractices.findDigits;
import static code.CodePractices.fizzbuzz;
import static code.CodePractices.getMoneySpent;
import static code.CodePractices.getSmallestAndLargest;
import static code.CodePractices.isAnagram;
import static code.CodePractices.libraryFine;
import static code.CodePractices.lowestTriangle;
import static code.CodePractices.maximumDraws;
import static code.CodePractices.minimumNumber;
import static code.CodePractices.pangrams;
import static code.CodePractices.pickingNumbers;
import static code.CodePractices.plusMinus;
import static code.CodePractices.queensAttack;
import static code.CodePractices.repeatedString;
import static code.CodePractices.saveThePrisoner;
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
	
	// https://www.hackerrank.com/challenges/queens-attack-2/problem
	@Test
	public void testQueensAttack() {
		int n = 4, k = 0, r_q = 4, c_q = 4; 
		int[][] obstacles = new int[0][2];
		int expected0 = 9;
		int result0 = queensAttack(n, k, r_q, c_q, obstacles);
		assertEquals(expected0, result0);
		n = 8; k = 0; r_q = 4; c_q = 4; 
		obstacles = new int[0][2];
		int expected = 27;
		int result = queensAttack(n, k, r_q, c_q, obstacles);
		assertEquals(expected, result);
		n = 5; k = 3; r_q = 4; c_q = 3; 
		obstacles = new int[k][2];
		obstacles[0][0] = 5; obstacles[0][1] = 5; 
		obstacles[1][0] = 4; obstacles[1][1] = 2;
		obstacles[2][0] = 2; obstacles[2][1] = 3;
		int expected1 = 10;
		int result1 = queensAttack(n, k, r_q, c_q, obstacles);
		assertEquals(expected1, result1);
		n = 1; k = 0; r_q = 1; c_q = 1; 
		obstacles = new int[0][2];
		int expected2 = 0;
		int result2 = queensAttack(n, k, r_q, c_q, obstacles);
		assertEquals(expected2, result2);
	}

	// https://www.hackerrank.com/challenges/library-fine/problem
	@Test
	public void testLibraryFine() {
		int d1=9, m1=6, y1=2015;
		int d2=6, m2=6, y2=2015;
		int expected = 45;
		int result = libraryFine(d1, m1, y1, d2, m2, y2);
		assertEquals(expected, result);
		d1=5; m1=5; y1=2014;
		d2=23; m2=2; y2=2014;
		expected = 1500;
		result = libraryFine(d1, m1, y1, d2, m2, y2);
		assertEquals(expected, result);
		d1=2; m1=7; y1=1014;
		d2=1; m2=1; y2=1014;
		expected = 3000;
		result = libraryFine(d1, m1, y1, d2, m2, y2);
		assertEquals(expected, result);
	}
	
	// https://www.hackerrank.com/challenges/repeated-string/problem
	@Test
	public void testRepeatedString() {
		String sample0 = "aba"; long n0 = 10L; long expected0 = 7;
		String sample1 = "a"; long n1 = 1000000000000L; long expected1 = 1000000000000L;
		String sample7 = "kmretasscityylpdhuwjirnqimlkcgxubxmsxpypgzxtenweirknjtasxtvxemtwxuarabssvqdnktqadhyktagjxoanknhgilnm";
		long n7 = 736778906400L; long expected7 = 51574523448L;
		long result0 = repeatedString(sample0, n0);
		long result1 = repeatedString(sample1, n1);
		long result7 = repeatedString(sample7, n7);
		assertEquals(expected0, result0);
		assertEquals(expected1, result1);
		assertEquals(expected7, result7);
    }
	
	// https://www.hackerrank.com/challenges/append-and-delete/problem
	@Test 
	public void testAppendAndDelete() {
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
	
	// https://www.hackerrank.com/challenges/save-the-prisoner/problem
	@Test
	public void testSaveThePrisoner() {
		int n = 5, m = 2, s = 1, expected = 2;
		int result = saveThePrisoner(n, m, s);
		assertEquals(expected, result);
		n = 5; m = 2; s = 2; expected = 3;
		result = saveThePrisoner(n, m, s);
		assertEquals(expected, result);
		n = 7; m = 19; s = 2; expected = 6;
		result = saveThePrisoner(n, m, s);
		assertEquals(expected, result);
		n = 3; m = 7; s = 3; expected = 3;
		result = saveThePrisoner(n, m, s);
		assertEquals(expected, result);
		n= 352926151; m = 380324688; s = 94730870; expected = 122129406;
		result = saveThePrisoner(n, m, s);
		assertEquals(expected, result);
	}
	
	// https://www.hackerrank.com/challenges/climbing-the-leaderboard/problem
	@Test
	public void testClimbingLeaderboard() {
		int[] scores1 = {100, 100, 50, 40, 40, 20, 10};
		int[] alice1 = {5, 25, 50, 120};
		int[] expected1 = {6, 4, 2, 1};
		int[] scores2 = {100, 90, 90, 80, 75, 60};
		int[] alice2 = {50, 65, 77, 90, 102};
		int[] expected2 = {6, 5, 4, 2, 1};
		int[] scores3 = {997,988,981,966,957,937,933,930,929,928,927,926,922,920,916,915,903,896,887,874,872,866,863,863,860,859,858,857,857,847,847,842,830,819,815,809,
				803,797,796,794,794,789,785,783,778,772,765,765,764,757,755,751,744,740,737,733,730,730,724,716,710,709,691,690,684,677,676,653,652,650,625,620,
				619,602,587,587,585,583,571,568,568,556,552,546,541,540,538,531,530,529,527,506,504,501,498,493,493,492,489,482,475,468,457,452,445,442,441,438,
				435,435,433,430,429,427,422,422,414,408,404,400,396,394,387,384,380,379,374,371,369,369,369,368,366,365,363,354,351,341,337,336,328,325,318,316,
				314,307,306,302,287,282,281,277,276,271,246,238,236,230,229,229,228,227,220,212,199,194,179,173,171,168,150,144,136,125,125,124,122,118,98,98,95,
				92,88,85,70,68,61,60,59,44,43,35,32,30,28,23,20,13,12,12};
		int[] alice3 = {83,129,140,184,198,300,312,325,341,344,349,356,370,405,423,444,465,471,491,500,506,508,539,543,569,591,607,612,614,623,645,
				670,689,726,744,747,764,773,777,787,805,811,819,829,841,905,918,918,955,997};
		int[] expected3 = {169, 160, 159, 153, 152, 136, 133, 129, 125, 125, 125, 123, 118, 108, 105, 97, 94, 93, 90};
		int[] result = climbingLeaderboard(scores1, alice1);		
		assertEquals(Arrays.toString(expected1), Arrays.toString(result));
		result = climbingLeaderboard(scores2, alice2);
		assertEquals(Arrays.toString(expected2), Arrays.toString(result));
		result = climbingLeaderboard(scores3, alice3);
		for (int i=0; i<expected3.length; i++) 
			assertEquals(expected3[i], result[i]);
	}
	
	// https://www.hackerrank.com/challenges/picking-numbers/problem
	@Test
	public void testPickingNumbers() {
		List<Integer> sample0 = Arrays.asList(4, 6, 5, 3, 3, 1);
		int expected0 = 3;
		List<Integer> sample1 = Arrays.asList(1, 2, 2, 3, 1, 2);
		int expected1 = 5;
		int result = pickingNumbers(sample0);
		assertEquals(expected0, result);
		 result = pickingNumbers(sample1);
		assertEquals(expected1, result);
	}
			
}
