package code;

import java.util.ArrayList;
import java.util.List;

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
					
}
