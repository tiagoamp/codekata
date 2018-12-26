package code.desafio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import code.desafios.Desafio0;

public class Desafio0Test {

	private Desafio0 desafio = new Desafio0();
	
	@Test
	public void testFibonacciUntil350() {
		List<Integer> result = desafio.fibonacciUntil350();
		int lastIndex = result.size()-1;
		assertTrue(result.get(lastIndex) <= 350);
		assertEquals("[0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233]", result.toString());
	}
	
	@Test
	public void testIsFibonacci_numberInSequence_shouldReturnTrue() {
		Boolean result = desafio.isFibonacci(21);
		assertTrue(result);
	}
	
	@Test
	public void testIsFibonacci_numberNotInSequence_shouldReturnFalse() {
		Boolean result = desafio.isFibonacci(400);
		assertFalse(result);
	}

}
