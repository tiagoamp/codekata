package hackerrank;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

//https://www.hackerrank.com/challenges/queens-attack-2/problem
public class QueensAttack {


	public static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) {
		// if board size just fit the queen spot, return 0
		if (n == 0 || n == 1) return 0;

		// if there are no obstacles, return all queen's cells to be attacked
		if (k == 0) {
			int qRowsCount = (n-1) + (n-1);
			int qDiagCount = Integer.min( n - r_q , c_q - 1 ) + Integer.min( r_q - 1 , c_q - 1 ) +
					Integer.min( n - r_q , n - c_q ) + Integer.min( r_q - 1, n - c_q );
			return qRowsCount + qDiagCount;
		}

		// Identify the closest obstacle in each 8 directions
		int min_distance_ob_left = c_q-1, min_distance_ob_right = n-c_q, min_distance_ob_up = n-r_q, min_distance_ob_down = r_q-1,
				min_distance_ob_left_up = Integer.min(n - r_q , c_q - 1), min_distance_ob_left_down = Integer.min(r_q - 1 , c_q - 1),
				min_distance_ob_right_up = Integer.min(n - r_q , n - c_q), min_distance_ob_right_down = Integer.min(r_q - 1, n - c_q);

		for (int i=0; i<k; i++) {
			int r_o = obstacles[i][0], c_o = obstacles[i][1];

			// case same row
			if (r_o == r_q) {
				if ( (c_o < c_q) && ((c_q - c_o - 1) < min_distance_ob_left) ) {
					min_distance_ob_left = c_q - c_o - 1;
				} else if ( (c_o > c_q) && ((c_o - c_q - 1) < min_distance_ob_right) ) {
					min_distance_ob_right = c_o - c_q - 1;
				}
			}
			// case same column
			if (c_o == c_q) {
				if ( (r_o > r_q) && ((r_o - r_q - 1) < min_distance_ob_up) ) {
					min_distance_ob_up = r_o - r_q - 1;
				} else if ( (r_o < r_q) && ((r_q - r_o - 1) < min_distance_ob_down) ) {
					min_distance_ob_down = r_q - r_o - 1;
				}
			}
			// case same diagonals
			if (Math.abs(r_q - r_o) == Math.abs(c_q - c_o)) {
				int distance = (Math.abs(r_q - r_o) - 1);
				if ( ((r_o > r_q) && (c_o < c_q)) && (distance < min_distance_ob_left_up) )
					min_distance_ob_left_up = distance;
				else if ( ((r_o < r_q) && (c_o < c_q)) && (distance < min_distance_ob_left_down) )
					min_distance_ob_left_down = distance;
				else if ( ((r_o > r_q) && (c_o > c_q)) && (distance < min_distance_ob_right_up) )
					min_distance_ob_right_up = distance;
				else if ( ((r_o < r_q) && (c_o > c_q)) && (distance < min_distance_ob_right_down) )
					min_distance_ob_right_down = distance;
			}
		}

		int sum = min_distance_ob_left + min_distance_ob_right + min_distance_ob_up + min_distance_ob_down +
				min_distance_ob_left_up + min_distance_ob_left_down + min_distance_ob_right_up + min_distance_ob_right_down;
		return sum;
	}


	@Test
	@DisplayName("Test sample 0")
	void testQueensAttack0() {
		int n = 4, k = 0, r_q = 4, c_q = 4; 
		int[][] obstacles = new int[0][2];
		int expected = 9;
		int result = queensAttack(n, k, r_q, c_q, obstacles);
		assertEquals(expected, result);
	}
	
	@Test
	@DisplayName("Test sample 1")
	void testQueensAttack1() {
		int n = 8, k = 0, r_q = 4, c_q = 4; 
		int[][] obstacles = new int[0][2];
		int expected = 27;
		int result = queensAttack(n, k, r_q, c_q, obstacles);
		assertEquals(expected, result);
	}
	
	@Test
	@DisplayName("Test sample 2")
	void testQueensAttack2() {
		int n = 5, k = 3, r_q = 4, c_q = 3; 
		int[][] obstacles = new int[k][2];
		obstacles[0][0] = 5; obstacles[0][1] = 5; 
		obstacles[1][0] = 4; obstacles[1][1] = 2;
		obstacles[2][0] = 2; obstacles[2][1] = 3;
		int expected = 10;
		int result = queensAttack(n, k, r_q, c_q, obstacles);
		assertEquals(expected, result);
	}
	
	@Test
	@DisplayName("Test sample 3")
	void testQueensAttack3() {
		int n = 1, k = 0, r_q = 1, c_q = 1; 
		int[][] obstacles = new int[0][2];
		int expected = 0;
		int result = queensAttack(n, k, r_q, c_q, obstacles);
		assertEquals(expected, result);
	}
	
}
