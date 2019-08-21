module.exports = obj = {

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


    // Superdigit = sum of digits until its result has only 1 digit
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


    /* Fibonacci starting at 0. Fibonacci series should be as follows: 0, 1, 1, 2, 3, 5, 8, 13, etc... */	
	fibonacci: function(n) {
		if (n == 0) return 0;
		else if (n == 1 || n == 2) return 1;
		else return obj.fibonacci(n-2) + obj.fibonacci(n-1);
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


    kangaroo: function(x1, v1, x2, v2) {
    	if (x2 > x1 && v2 >= v1) return "NO";  // second kangaroo is and and is faster than the 1th one 
    	// x1 + n * v1 = x2 + n * v2 , then n = (x2-x1)%(v1-v2) must be == 0 to make them meet
    	const result = Math.abs((x2-x1)) % Math.abs((v1-v2)) == 0 ? "YES" : "NO";
    	return result;
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

    catAndMouse: function(x, y, z) {
    	const distanceCatAFromMouse = Math.abs(z - x);
    	const distanceCatBFromMouse = Math.abs(z - y);
    	if (distanceCatAFromMouse == distanceCatBFromMouse) return "Mouse C";
    	return distanceCatAFromMouse < distanceCatBFromMouse ? "Cat A" : "Cat B";
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

    hurdleRace: function(k, height) {
        height.sort(function(a, b) {
            return a - b;
        });
        const max = height[height.length-1];
    	return k >= max ? 0 : (max-k);
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
    }

}
