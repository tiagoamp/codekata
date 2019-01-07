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
