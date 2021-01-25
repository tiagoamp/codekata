// https://www.hackerrank.com/challenges/lowest-triangle/problem

const lowestTriangle = (base, area) => Math.ceil( (area * 2.0) / base );


test("sample 0", () => {
	const b = 2, a = 2, expected = 2;
	const result = lowestTriangle(b, a);
	expect(result).toBe(expected);
})

test("sample 1", () => {
	const b = 17, a = 100, expected = 12;
	const result = lowestTriangle(b, a);
	expect(result).toBe(expected);
})