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
    }

}
