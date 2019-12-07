module.exports = obj = {

	queensAttack(n, k, r_q, c_q, obstacles) {
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
	},
	
	repeatedString(s, n) {
    	if (s.length == 1) return s === "a" ? n : 0;
    	if (!s.includes("a")) return 0;
    	let count = 0;
        for (let i = 0; i < s.length; i++) {
            const ch = s.charAt(i);
            if (ch == 'a') count++;
        }
        const d = n / s.length;
        const r =  n % s.length;
        count *=  Math.trunc(d);
        for(let i=0;i<r;i++)
            if(s.charAt(i) == 'a') count++;
        return count;
	},
	
	appendAndDelete(s, t, k) {
    	if (s === t) {
    		if (k > s.length) return k > 2 ? "Yes" : "No";
    		else return k%2 == 0 ? "Yes" : "No"; 
    	}    		
    	let commonChars = -1;  // find out index until 't' equals 's' 
    	for (let i = 0; i < s.length; i++) {
    		if ( (i > (t.length-1)) || s.charAt(i) != t.charAt(i) )
    			break;
			commonChars++;  // increment if same char in both strings
		}
    	const diffOfS = s.substring(commonChars+1);
    	const diffOfT = t.substring(commonChars+1);
    	if (diffOfS.length == 0) {
    		return k >= diffOfT.length && (k - diffOfT.length)%2 == 0 ? "Yes": "No";
    	} else if (diffOfT.length == 0) {
    		return k >= diffOfS.length && (k > s.length || (k - diffOfS.length)%2 == 0) ? "Yes": "No";
    	} 
    	if (k > diffOfS.length+diffOfT.length) return k > 2 ? "Yes" : "No";
    	return (k >= diffOfS.length+diffOfT.length) && (k - diffOfS.length+diffOfT.length)%2==0 ? "Yes" : "No";
	},
	
	saveThePrisoner(n, m, s) {
    	const r = s + (m-1);
    	if (r <= n) return r;
    	return (r%n == 0) ? n : r%n;
	},
	
	climbingLeaderboard(scores, alice) {
    	const uniqueScores = [...new Set(scores)];
    	let result = [];
    	let i = uniqueScores.length-1;
        for(let j=0; j<alice.length; j++) {
        	const a = alice[j];
            while(i>=0) {
                if(a>=uniqueScores[i]) { 
                	i--;
				} else {
                	result[j] = i+2; 
                	break;
                }
            }
            if(i<0) result[j] = 1;
        }
        return result;
    },
	
	formingMagicSquare(s) {
    	let costs = [0,0,0,0,0,0,0,0];
        const magicSquares = 
        [ [2,7,6,9,5,1,4,3,8], [6,7,2,1,5,9,8,3,4], [8,3,4,1,5,9,6,7,2], [4,3,8,9,5,1,2,7,6],
          [6,1,8,7,5,3,2,9,4], [2,9,4,7,5,3,6,1,8], [4,9,2,3,5,7,8,1,6], [8,1,6,3,5,7,4,9,2]
        ];
        for (let i=0;i<magicSquares.length;i++) {        
        	costs[i] = Math.abs(magicSquares[i][0]-s[0][0]) + Math.abs(magicSquares[i][1]-s[0][1]) + Math.abs(magicSquares[i][2]-s[0][2]);
        	costs[i] = costs[i] + Math.abs(magicSquares[i][3]-s[1][0]) + Math.abs(magicSquares[i][4]-s[1][1]) + Math.abs(magicSquares[i][5]-s[1][2]);
        	costs[i] = costs[i] + Math.abs(magicSquares[i][6]-s[2][0]) + Math.abs(magicSquares[i][7]-s[2][1]) + Math.abs(magicSquares[i][8]-s[2][2]);
        }
        const minCost = Math.min( ...costs );
        return minCost;
	},
	
	utopianTree: function(n) {
    	let result = 1;
    	if (n == 0) return result;
    	for(let i=1; i <=n; i++) {
    		let shouldDoubleSize = i%2 != 0; // odd numbers double size
    		result = shouldDoubleSize ? result * 2 : result + 1; 
    	}
    	return result;
	},
	
	hurdleRace: function(k, height) {
        height.sort(function(a, b) {
            return a - b;
        });
        const max = height[height.length-1];
    	return k >= max ? 0 : (max-k);
	},
	
	gradingStudents: function(grades) {
        if (grades == null || grades.length === 0) return grades;
    	const roundedGrades = grades.map(n => {
    		if (n < 38) {
    			return n;
    		} else {
    			const nextMultipleOfFive = 5*Math.ceil(n/5);
    			return (nextMultipleOfFive - n) < 3 ? nextMultipleOfFive : n;
    		}
    	});
    	return roundedGrades;
	},
	
	catAndMouse: function(x, y, z) {
    	const distanceCatAFromMouse = Math.abs(z - x);
    	const distanceCatBFromMouse = Math.abs(z - y);
    	if (distanceCatAFromMouse == distanceCatBFromMouse) return "Mouse C";
    	return distanceCatAFromMouse < distanceCatBFromMouse ? "Cat A" : "Cat B";
	},
	
	bigSorting: function(unsorted) {    	
        const comparator = (a, b) => {
            // different sizes
            if (a.length != b.length) 
                return a.length - b.length;
            // same sizes, compare per digits
            for (let i = 0; i < a.length; i++) {
                let digitFromA = a.charAt(i);
                let digitFromB = b.charAt(i);
                if (digitFromA != digitFromB) 
                    return digitFromA - digitFromB;
            }
            // numbers are the same.
            return 0;
        };
        const result = unsorted.sort(comparator);
    	return result;
	},
	
	birthdayChoc: function(s, d, m) {
    	let result = 0, index  = 0;
    	if (s == null || s.length == 0) return result;
    	let isOver = m > s.length;
    	while (!isOver) {    		
    		let inner = s.slice(index, m);
    		let sum = inner.reduce((x,y) => x+y, 0);
    		if (sum == d) result++;
    		index++;
    		m++;
    		isOver = m > s.length;
    	}    	
    	return result;
	},
	
	sockMerchant: function(n, arr) {
    	const colors = [];
        let pairs = 0;
        for (let i = 0; i < n; i++) {
            if (!colors.includes(arr[i])) {
                colors.push(arr[i]);
            } else {
                pairs++;
                const index = arr.indexOf(arr[i]);
                colors.splice(index, 1);
            }
        }
        return pairs;
	},
	
	breakingRecords: function(scores) {
    	let countMin = 0, countMax = 0;
    	let min = scores[0], max = scores[0];
    	
    	for (let i = 0; i < scores.length; i++) {
			if (scores[i] < min) {
				min = scores[i];
				countMin++;
			} else if (scores[i] > max) {
				max = scores[i];
				countMax++;
			}
        }
        
        const result = [countMax, countMin];
    	return result;
	},

	kangaroo: function(x1, v1, x2, v2) {
    	if (x2 > x1 && v2 >= v1) return "NO";  // second kangaroo is and and is faster than the 1th one 
    	// x1 + n * v1 = x2 + n * v2 , then n = (x2-x1)%(v1-v2) must be == 0 to make them meet
    	const result = Math.abs((x2-x1)) % Math.abs((v1-v2)) == 0 ? "YES" : "NO";
    	return result;
    },
	
	birthdayCakeCandles: function(arr) {
        arr.sort(function(a, b) {
                return a - b;
            });
        const lastIndex = arr.length -1;
		let tallest = arr[lastIndex];
		let count = 0;		
		for (let i = lastIndex; i >= 0; i--) {
			if (arr[i] == tallest) count++;
			else break;			
		}		
		return count;
	},
	
	staircase: function(n) {
		if (n == 0) return null;
        const stairMatrix = [];
        for (let row = 0; row < n; row++) {
            let mRow = [];
			for (let col = 0; col < n; col++) {
                const value = (col >=  parseInt((n-row) - 1 )) ? '#' : ' ';
                mRow.push(value);
            }
            stairMatrix.push(mRow);
        }        
		return stairMatrix;
	},
	
	/* Fibonacci starting at 0. Fibonacci series should be as follows: 0, 1, 1, 2, 3, 5, 8, 13, etc... */	
	fibonacci: function(n) {
		if (n == 0) return 0;
		else if (n == 1 || n == 2) return 1;
		else return obj.fibonacci(n-2) + obj.fibonacci(n-1);
	},

	minMaxSum: function(arr) {
        arr.sort(function(a, b){return a-b});
        let min = 0, max = 0;
    	const len = 5;    	
    	for (let i = 0; i < arr.length; i++) {
			if (i < len-1) min += arr[i];
			if (i > 0) max += arr[i];
		}
    	return [min,max];
	},
	
	countApplesAndOranges: function(s, t, a, b, apples, oranges) {
		let appleCount = 0;
		for (let i = 0; i < apples.length; i++) {
			let distance = apples[i] + a;
			if ( distance >= s && distance <= t ) appleCount++;
		}
		let orangeCount = 0;
		for (let i = 0; i < oranges.length; i++) {
			let distance = oranges[i] + b;
			if ( distance >= s && distance <= t ) orangeCount++;
        }
        return [appleCount, orangeCount];
	},
	
	superdigit: function(n, k) {
        if (n.length <= 1) return parseInt(n);
        let sum = 0;
        for (let i = 0; i < n.length; i++) {
            const digit = n.charAt(i);
            sum += parseInt(digit);
        }
        if (k > 1) sum *= k;
        return obj.superdigit(sum.toString(), 1);
    },

    bestDivisor: function(input) {
        const arr = Array(input).fill().map((item, index) => index + 1);
        const divisors = arr.filter(x => input % x == 0);
        const sums = divisors.map(num => {
            let sum = 0;
            while (num > 0) {
                sum = Math.trunc(sum + num % 10);
                num = num / 10;
            }
            return sum;            
        });
        const maxSummedNr = sums.reduce((x,y) => Math.max(x,y));
        const indexOfMaxSummedNr = sums.indexOf(maxSummedNr);
        const bestNumber = divisors[indexOfMaxSummedNr];
		return bestNumber;
    },

}