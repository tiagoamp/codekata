// https://www.hackerrank.com/challenges/queens-attack-2/problem

const queensAttack = (n, k, r_q, c_q, obstacles) => {
    // if board size just fit the queen spot, return 0 
    if (n == 0 || n == 1) return 0;
    
    // if there are no obstacles, return all queen's cells to be attacked
    if (k == 0) {
        const qRowsCount = (n-1) + (n-1);
        const qDiagCount = Math.min( n - r_q , c_q - 1 ) + Math.min( r_q - 1 , c_q - 1 ) + 
        Math.min( n - r_q , n - c_q ) + Math.min( r_q - 1, n - c_q );
        return qRowsCount + qDiagCount;
    }
    
    // Identify the closest obstacle in each 8 directions
    let min_distance_ob_left = c_q-1, min_distance_ob_right = n-c_q, min_distance_ob_up = n-r_q, min_distance_ob_down = r_q-1, 
        min_distance_ob_left_up = Math.min(n - r_q , c_q - 1), min_distance_ob_left_down = Math.min(r_q - 1 , c_q - 1), 
        min_distance_ob_right_up = Math.min(n - r_q , n - c_q), min_distance_ob_right_down = Math.min(r_q - 1, n - c_q);
    
    for (let i=0; i<k; i++) {
        const r_o = obstacles[i][0], c_o = obstacles[i][1];
     
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
            const distance = (Math.abs(r_q - r_o) - 1);
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
    
    const sum = min_distance_ob_left + min_distance_ob_right + min_distance_ob_up + min_distance_ob_down +   
              min_distance_ob_left_up + min_distance_ob_left_down + min_distance_ob_right_up + min_distance_ob_right_down;
    return sum;
}


test("sample 0", () => {
	const n = 4, k = 0, r_q = 4, c_q = 4, obstacles = [], expected = 9;
	const result = queensAttack(n, k, r_q, c_q, obstacles);
	expect(result).toBe(expected);
});

test("sample 1", () => {
	const n = 8, k = 0, r_q = 4, c_q = 4, obstacles = [], expected = 27;
	const result = queensAttack(n, k, r_q, c_q, obstacles);
	expect(result).toBe(expected);
});

test("sample 2", () => {
	const n = 5, k = 3, r_q = 4, c_q = 3, obstacles = [ [5,5], [4,2], [2,3] ], expected = 10;
	const result = queensAttack(n, k, r_q, c_q, obstacles);
	expect(result).toBe(expected);
});

test("sample 3", () => {
	const n = 1, k = 0, r_q = 1, c_q = 1, obstacles = [], expected = 0;
	const result = queensAttack(n, k, r_q, c_q, obstacles);
	expect(result).toBe(expected);
});