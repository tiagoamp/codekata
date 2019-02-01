module.exports = obj = {

    hello: function() { return 'hello' }, 
    

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
    }
    
}
