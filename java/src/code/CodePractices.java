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
			if ( distance >= s && distance <= t ) appleCount ++;
		}
		int orangeCount = 0;
		for (int i = 0; i < oranges.length; i++) {
			int distance = oranges[i] + b;
			if ( distance >= s && distance <= t ) orangeCount ++;
		}
		return new int[] {appleCount, orangeCount};
    }
	
}
