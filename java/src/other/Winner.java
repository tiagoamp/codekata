package other;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Winner {
	
	static final int WINNER = 1, NOT_WINNER = 0;
	
	public static int winner(List<String> codeList, List<String> shoppingCart) {
		if (codeList == null || codeList.isEmpty())
			return WINNER;
		
		int matches = 0; 
		List<String> currCart = new ArrayList<>(shoppingCart);
		
		for (String fruits : codeList) {
			String[] fruitsArr = fruits.split(" ");
			int found = 0, shift = 0;
			
			while ( shift <= (currCart.size() - fruitsArr.length) ) {	
				for (int f = 0; f < fruitsArr.length; f++) {
					if ( fruitsArr[f].equals("anything") || fruitsArr[f].equals(currCart.get(f + shift)) )
						found++;
				}
				if (found == fruitsArr.length) {
					currCart = currCart.subList(shift + fruitsArr.length, currCart.size());
					matches++;
					break;
				}					
				shift++;
			}
		}
		
		return matches == codeList.size() ? WINNER : NOT_WINNER;
    }
	
	
	@Test
	@DisplayName("Test sample case")
	void testFoo() {
		List<String> codeList = Arrays.asList("orange", "apple apple", "banana orange apple", "banana");
		List<String> shoppingCart = Arrays.asList("orange","apple","apple","banana","orange","apple","banana");
		int expected = 1;
		int result = winner(codeList, shoppingCart);
		assertEquals(expected, result);
	}

}
