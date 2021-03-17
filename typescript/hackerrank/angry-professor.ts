// https://www.hackerrank.com/challenges/angry-professor/problem

function angryProfessor(k:number, a:number[]): string {
    const onTime: number = a.filter(n => n<=0).length;
    return onTime >= k ? "NO" : "YES";
}


test("sample A", () => {
	const k = 3, a = [-1, -3, 4, 2], expected = "YES";
    const result = angryProfessor(k, a);
	expect(result).toBe(expected);
});

test("sample B", () => {
	const k = 2, a = [0, -1, 2, 1], expected = "NO";
    const result = angryProfessor(k, a);
	expect(result).toBe(expected);
});

test("edge cases", () => {
    const k = 2, a = [0, -100, 100], expected = "NO";
    const result = angryProfessor(k, a);
	expect(result).toBe(expected);
});
