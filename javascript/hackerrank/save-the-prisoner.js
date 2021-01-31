// https://www.hackerrank.com/challenges/save-the-prisoner/problem

const saveThePrisoner = (n, m, s) => {
    const r = s + (m-1);
    if (r <= n) return r;
    return (r%n == 0) ? n : r%n;
}


test("sample 0", () => {
    const n = 5, m = 2, s = 1, expected = 2;
	const result = saveThePrisoner(n, m, s);
	expect(result).toBe(expected);
});

test("sample 1", () => {
    const n = 5, m = 2, s = 2, expected = 3;
	const result = saveThePrisoner(n, m, s);
	expect(result).toBe(expected);
});

test("sample 2", () => {
    const n = 7, m = 19, s = 2, expected = 6;
	const result = saveThePrisoner(n, m, s);
	expect(result).toBe(expected);
});

test("sample 3", () => {
    const n = 3, m = 7, s = 3, expected = 3;
	const result = saveThePrisoner(n, m, s);
	expect(result).toBe(expected);
});

test("sample 4", () => {
    const n = 352926151, m = 380324688, s = 94730870, expected = 122129406;
	const result = saveThePrisoner(n, m, s);
	expect(result).toBe(expected);
});