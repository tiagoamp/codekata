const practices = require('./codepractices.js');

test('Hello Test World', () => {
    const result = practices.hello();
    expect('hello').toEqual(result);
});

test('Best Divisor', () => {
    const sample = 12; 
    const expectedVal = 6;
	const result = practices.bestDivisor(sample);
	expect(result).toEqual(expectedVal);
});

test("Superdigit", () => {
    let n = "148"; k = 3, expected = 3, result = 0;
	result = practices.superdigit(n,k);
	expect(expected).toEqual(result);
	n = "9875"; k = 4; expected = 8;
	result = practices.superdigit(n,k);
	expect(expected).toEqual(result);
	n = "123"; k = 3; expected = 9;
	result = practices.superdigit(n,k);
    expect(expected).toEqual(result);
	n = "100000"; k = 100000;  // superior threshold 
    result = practices.superdigit(n,k);
    expect(result).toBeGreaterThan(0);
});

test("CountApplesAndOranges", () => {
    // sample case
    let s = 7, t = 11;  // house
    let a = 5, b = 15;  // tree
    let apples = [-2, 2, 1];   // fruits array
    let oranges = [5, -6];     // fruits array
    let result = practices.countApplesAndOranges(s, t, a, b, apples, oranges);
    expect(1).toEqual(result[0]);
    expect(1).toEqual(result[1]);
    // test case 2
    s = 2; t = 3;
    a = 1; b = 5;
    apples = [2];
    oranges = [-2];
    result = practices.countApplesAndOranges(s, t, a, b, apples, oranges);
    expect(1).toEqual(result[0]);
    expect(1).toEqual(result[1]);
});

test("minMaxSum", () => {
    const arr = [1, 2, 3, 4, 5];
    const result = practices.minMaxSum(arr);
    expect(10).toEqual(result[0]);
    expect(14).toEqual(result[1]);    
});

test("Fibonacci", () => {
    let result = practices.fibonacci(10);
    expect(55).toEqual(result);
});

test("Staircase", () => {
    const n = 6;
    const result = practices.staircase(n);
    for (let i = 0; i < n; i++) expect(result[0][i]).toEqual( (i >= 5) ? '#' : ' ');
	for (let i = 0; i < n; i++) expect(result[1][i]).toEqual( (i >= 4) ? '#' : ' ');
	for (let i = 0; i < n; i++) expect(result[5][i]).toEqual( (i >= 0) ? '#' : ' ');
});

test("birthdayCakeCandles", () => {
    let arr = [3, 2, 1, 3];
	let result = practices.birthdayCakeCandles(arr);
	expect(2).toEqual(result);
	// threshold case 
	const n = 100000;
	arr = Array(n).fill(9999999);
	result = practices.birthdayCakeCandles(arr);
	expect(100000).toEqual(result);
});

test("kangaroo", () => {
    let x1 = 0; v1 = 3; x2 = 4; v2 = 2;
	let result = practices.kangaroo(x1, v1, x2, v2);
	expect("YES").toEqual(result);
	x1 = 0; v1 = 2; x2 = 5; v2 = 3;
	result = practices.kangaroo(x1, v1, x2, v2);
	expect("NO").toEqual(result);
	x1 = 43; v1 = 2; x2 = 70; v2 = 2;
	result = practices.kangaroo(x1, v1, x2, v2);
    expect("NO").toEqual(result);
});

test("breakingRecords", () => {
    const sample0 = [10, 5, 20, 20, 4, 5, 2, 25, 1];
	let result = practices.breakingRecords(sample0);
	expect(2).toEqual(result[0]);
	expect(4).toEqual(result[1]);
	const sample1 = [3, 4, 21, 36, 10, 28, 35, 5, 24, 42];
	result = practices.breakingRecords(sample1);
	expect(4).toEqual(result[0]);
	expect(0).toEqual(result[1]);
});
