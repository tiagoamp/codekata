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