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
		String nVal = superdigit(n);
		String multiplied = String.valueOf( Integer.valueOf(nVal) * k );
		String result = superdigit(multiplied);
		return Integer.parseInt(result);
	}
	
	private static String superdigit(String value) {
		if (value.length() <= 1) return value;		
		int sum = 0;
		for (int i = 0; i < value.length(); i++) {
			Integer digit = Character.getNumericValue(value.charAt(i));
			sum += digit;
		}		
		return superdigit( String.valueOf(sum) );
	}
	
	
}
