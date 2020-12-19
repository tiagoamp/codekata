// https://www.hackerrank.com/challenges/best-divisor/problem

test('Best Divisor', () => {
    const sample = 12, expectedVal = 6;
	const result = bestDivisor(sample);
	expect(result).toEqual(expectedVal);
});


const bestDivisor = (input) => {
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
}

