package hackerrank;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

//https://www.hackerrank.com/challenges/magic-square-forming/problem
public class FormingMagicSquare {
		
	@Test
	@DisplayName("Test sample 0")
	public void testFormingMagicSquare0() {
		int[][] sample0 = { {4,9,2},{3,5,7},{8,1,5} };
		int expectedResult0 = 1;
		int result = formingMagicSquare(sample0);
		assertEquals(expectedResult0, result);
	}
	
	@Test
	@DisplayName("Test sample 1")
	public void testFormingMagicSquare1() {
		int[][] sample1 = { {4,8,2},{4,5,7},{6,1,6} };
		int expectedResult1 = 4;
		int result = formingMagicSquare(sample1);
		assertEquals(expectedResult1, result);
	}

	
	public static int formingMagicSquare(int[][] s) {
    	int costs[] = {0,0,0,0,0,0,0,0};
        int magicSquares[][] = 
	        { {2,7,6,9,5,1,4,3,8}, {6,7,2,1,5,9,8,3,4}, {8,3,4,1,5,9,6,7,2}, {4,3,8,9,5,1,2,7,6},
	          {6,1,8,7,5,3,2,9,4}, {2,9,4,7,5,3,6,1,8}, {4,9,2,3,5,7,8,1,6}, {8,1,6,3,5,7,4,9,2}
	        };
        for(int i=0;i<magicSquares.length;i++) {        
        	costs[i] = Math.abs(magicSquares[i][0]-s[0][0]) + Math.abs(magicSquares[i][1]-s[0][1]) + Math.abs(magicSquares[i][2]-s[0][2]);
        	costs[i] = costs[i] + Math.abs(magicSquares[i][3]-s[1][0]) + Math.abs(magicSquares[i][4]-s[1][1]) + Math.abs(magicSquares[i][5]-s[1][2]);
        	costs[i] = costs[i] + Math.abs(magicSquares[i][6]-s[2][0]) + Math.abs(magicSquares[i][7]-s[2][1]) + Math.abs(magicSquares[i][8]-s[2][2]);
        }   
        int minCost = Arrays.stream(costs).min().getAsInt();
        return minCost;
    }
	
}
