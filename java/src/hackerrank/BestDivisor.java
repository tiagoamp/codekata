package hackerrank;

import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntUnaryOperator;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;


// https://www.hackerrank.com/challenges/best-divisor/problem
public class BestDivisor {
	
	@Test
	void test_bestDivisor() {
		Integer sample = 12, expected = 6;
		List<Integer> results = Arrays.asList(bestDivisor_solution3(sample), 
				bestDivisor_solution2(sample), bestDivisor_solution1(sample));
		results.forEach(result -> assertEquals(expected, result));
	}
		
	
	public static int bestDivisor_solution3(int input) {
		List<Integer> divisors = IntStream.rangeClosed(1, input).filter(i -> input % i == 0).boxed().collect(toList());
		int maxSumOfDigits = divisors.stream().mapToInt(sumOfDigitsFunc::applyAsInt).max().getAsInt();
		List<Integer> candidates = divisors.parallelStream().filter(d -> sumOfDigitsFunc.applyAsInt(d) == maxSumOfDigits).collect(toList());
		int bestNumber = candidates.stream().mapToInt(Integer::valueOf).min().getAsInt();
		return bestNumber;
	}
	
	public static int bestDivisor_solution2(int input) {
		int[] divisors = IntStream.rangeClosed(1, input).filter(i -> input % i == 0).toArray();
		int val = 0, max = 0;
		for (int d : divisors) {
			int sum = sumOfDigitsFunc.applyAsInt(d);
			if (sum > max) {
				max = sum;
				val = d;
			} else if (sum == max) {
				if (d < val)
					val = d;
			}
		}
		return val;
	}
	
	public static int bestDivisor_solution1(int input) {
		List<Integer> divisors = IntStream.rangeClosed(1, input).filter(i -> input % i == 0).boxed().collect(toList());
		List<Integer> sums = divisors.stream().map(sumOfDigitsFunc::applyAsInt).collect(toList());
		int maxSummedNr = sums.stream().mapToInt(Integer::valueOf).max().getAsInt();
		int indexOfMaxSummedNr = 0;		
		while (sums.get(indexOfMaxSummedNr) != maxSummedNr) 
			indexOfMaxSummedNr++;
		int bestNumber = divisors.get(indexOfMaxSummedNr);
		return bestNumber;
	}
	
	
	private static IntUnaryOperator sumOfDigitsFunc = n -> {
		int sum = 0;
		while (n > 0) {
            sum = sum + n % 10;
            n = n / 10;
        }
        return sum;
	};

}
