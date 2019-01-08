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