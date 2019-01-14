package code;

import java.util.Arrays;
import java.util.stream.IntStream;

public class CodePractices {

	/* Given two positive different numbers: 
     * The number whose digits sum to a larger number is better than the other. 
     * If the sum of digits is equal for both numbers, then the smaller number is better. */
	public static int bestDivisor(int input) {     
		int[] divisors = IntStream.rangeClosed(1, input).filter(i -> input % i == 0).toArray();
        
		int[] sums = Arrays.stream(divisors).map(num -> {
				int sum = 0;
				while (num > 0) {
		            sum = sum + num % 10;
		            num = num / 10;
		        }
	            return sum;            
			}).toArray();

		int maxSummedNr = Arrays.stream(sums).max().getAsInt();
		
		int indexOfMaxSummedNr = 0;		
		while (sums[indexOfMaxSummedNr] != maxSummedNr) {
			indexOfMaxSummedNr++;
		}
		
		int bestNumber = divisors[indexOfMaxSummedNr];
		return bestNumber;
	}    
	
	
	/* Superdigit = sum of digits until its result has only 1 digit */
	public static int superdigit(String n, int k) {
		if (n.length() <= 1) return Integer.parseInt(n);
		int sum = 0;
		for (int i = 0; i < n.length(); i++) {
			Integer digit = Character.getNumericValue(n.charAt(i));
			sum += digit;
		}		
		if (k > 1) sum *= k;
		return superdigit(String.valueOf(sum), 1);
	}
	
	
	public static int[] countApplesAndOranges(int s, int t, int a, int b, int[] apples, int[] oranges) {
		int appleCount = 0;
		for (int i = 0; i < apples.length; i++) {
			int distance = apples[i] + a;
			if ( distance >= s && distance <= t ) appleCount++;
		}
		int orangeCount = 0;
		for (int i = 0; i < oranges.length; i++) {
			int distance = oranges[i] + b;
			if ( distance >= s && distance <= t ) orangeCount++;
		}
		return new int[] {appleCount, orangeCount};
    }
	
	
	// MinMaxSum function
    public static long[] minMaxSum(int[] arr) {
    	Arrays.sort(arr);
    	long min = 0, max = 0;
    	final int len = 5;    	
    	for (int i = 0; i < arr.length; i++) {
			if (i < len-1) {
				min += arr[i];
			}
			if (i > 0) {
				max += arr[i];
			}
		}
    	return new long[] {min,max};
    }
    
    /* Fibonacci starting at 0. Fibonacci series should be as follows: 0, 1, 1, 2, 3, 5, 8, 13, etc... */	
	public static int fibonacci(Integer n) {
		if (n == 0) return 0;
		else if (n == 1 || n == 2) return 1;
		else return fibonacci(n-2) + fibonacci(n-1);
	}
	
	public static Character[][] staircase(int n) {
		if (n == 0) return null;
		Character[][] stairMatrix = new Character[n][n];		
		for (int row = 0; row < n; row++) {
			for (int col = 0; col < n; col++) {
				stairMatrix[row][col] = col >= ( (n-row) - 1 ) ? '#' : ' ';
			}
		}		
		return stairMatrix;
	}
	
}
