package code.desafios;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class DesafioCodeNationTest {

	private DesafioCodeNation desafio = new DesafioCodeNation();
	
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
