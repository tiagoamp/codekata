package code.desafios;

import java.util.ArrayList;
import java.util.List;

public class DesafioCodeNation {

	/* Método que retorne uma lista java.util.List com os primeiro números Integer de série de Fibonacci até passar de 350.
	 * A série de Fibonacci é a seguinte: 0, 1, 1, 2, 3, 5, 8, 13, etc... 
	 */
	public List<Integer> fibonacciUntil350() {
		List<Integer> result = new ArrayList<>();
		int fib = 0, currIndex = 0;
		
		while(fib <= 350) {
			result.add(fib);
			currIndex++;
			fib = fibonacci(currIndex);			
		}
		
		return result;
	}
	
	/* Método que recebe um Integer como parâmetro e retorne Boolean. 
	 * Caso o número recebido por parâmetro esteja entre os números da sequência de Fibonnaci retorne true, senão, false.
	 */
	public Boolean isFibonacci(Integer n) {
		List<Integer> sequence = fibonacciUntil350();
		return sequence.contains(n);
	}
	
	private int fibonacci(Integer n) {
		if (n == 0) return 0;
		else if (n == 1 || n == 2) return 1;
		else return fibonacci(n-2) + fibonacci(n-1);
	}
		
}
