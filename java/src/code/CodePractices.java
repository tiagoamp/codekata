package code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class CodePractices {

	static int findDigits(int n) {
		int curr = n, counter = 0;
		while (curr > 0) {
		    if ( (curr % 10 != 0) && (n % (curr % 10) == 0) )
		    	counter++;
		    curr = curr / 10;
		}
		return counter;
    }
	
	static int lowestTriangle(int base, int area){
		return (int) Math.ceil( (area * 2.0) / (float)base ) ;
    }
	
	public static int maximumDraws(int n) {
        return ( (n * 2) / 2 ) + 1;
    }
	
	public static List<String> fizzbuzz(int n) {
		List<String> result = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
            if (i >= (3*5) && i % 3 == 0 && n % 5 == 0) 
                result.add("FizzBuzz");
            else if (i >= 3 && i % 3 == 0)
            	result.add("Fizz");
            else if (i >= 5 && i % 5 == 0)
            	result.add("Buzz");
            else 
            	result.add(String.valueOf(i));
        }
		return result;
	}
	
	public static String bonAppetit(List<Integer> bill, int k, int b) {
		Integer total = bill.stream().reduce(0, (acc, e) -> acc + e);
		Integer actualCharge = (total - bill.get(k)) / 2; 
		return (b == actualCharge) ? "Bon Appetit" : String.valueOf(b - actualCharge);
    }
	
	public static int getMoneySpent(int[] keyboards, int[] drives, int b) {
		List<Integer> results = new ArrayList<>();
		for (int i = 0; i < keyboards.length; i++) {
			for (int j = 0; j < drives.length; j++) {
				int sum = keyboards[i] + drives[j];
				if (b >= sum) results.add(sum);
			}
		}
		return results.isEmpty() ? -1 : Collections.max(results);
	}
	
	public static String[] plusMinus(int[] arr) {
		int positives = 0, negatives = 0, zeros = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) zeros++;
			else if (arr[i] > 0) positives++;
			else negatives++;
		}
		int length = arr.length;
		String[] results = new String[3];
		results[0] = String.format(Locale.US, "%.06f", ((double) positives) / ((double) length));
		results[1] = String.format(Locale.US, "%.06f", ((double) negatives) / ((double) length));
		results[2] = String.format(Locale.US, "%.06f", ((double) zeros) / ((double) length));
		return results;
    }
	
	public static int countingValleys(int n, String s) {
		int countOfValleys = 0, path = 0, seaLevel = 0;
		boolean enteredValley = false;		
		for (int i = 0; i < n; i++) {
			Character letter = s.charAt(i);
			if (letter.equals('U')) path += 1;
			else if (letter.equals('D')) path -= 1;
			if (path == seaLevel && enteredValley)
				countOfValleys++;
			enteredValley = path < 0;
		}
		return countOfValleys;
    }
	
	public static String getSmallestAndLargest(String s, int k) {
        List<String> substrings = new ArrayList<>();
        for(int i=0; i<=s.length()-k; i++) 
        	substrings.add(s.substring(i, i+k));
        String smallest = substrings.stream().sorted().min(String::compareTo).get();
        String largest = substrings.stream().sorted().max(String::compareTo).get();
        return smallest + "\n" + largest;
    }
					
}
