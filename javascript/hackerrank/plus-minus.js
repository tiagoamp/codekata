// https://www.hackerrank.com/challenges/plus-minus/problem

const plusMinus = (arr) => {
    let positives = 0, negatives = 0, zeros = 0;
    for (let i = 0; i < arr.length; i++) {
        if (arr[i] == 0) zeros++;
        else if (arr[i] > 0) positives++;
        else negatives++;
    }
    const results = [];
    results.push( (positives / arr.length).toFixed(6) );
    results.push( (negatives / arr.length).toFixed(6) );
    results.push( (zeros / arr.length).toFixed(6) );
    return results;
}


test("plusMinus", () => {
	const input = [-4, 3, -9, 0, 4, 1];
	const result = plusMinus(input);
	expect(result[0]).toBe(0.500000.toFixed(6));
	expect(result[1]).toBe(0.333333.toFixed(6));
	expect(result[2]).toBe(0.166667.toFixed(6));
})

