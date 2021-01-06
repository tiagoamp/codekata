const kangaroo = (x1, v1, x2, v2) => {
    if (x2 > x1 && v2 >= v1) return "NO";  // second kangaroo is and and is faster than the 1th one 
    // x1 + n * v1 = x2 + n * v2 , then n = (x2-x1)%(v1-v2) must be == 0 to make them meet
    const result = Math.abs((x2-x1)) % Math.abs((v1-v2)) == 0 ? "YES" : "NO";
    return result;
}

test("kangaroo sample 0", () => {
    const x1 = 0; v1 = 3; x2 = 4; v2 = 2;
	const result = kangaroo(x1, v1, x2, v2);
	expect(result).toEqual("YES");
});

test("kangaroo sample 1", () => {
    const x1 = 0; v1 = 2; x2 = 5; v2 = 3;
	const result = kangaroo(x1, v1, x2, v2);
	expect(result).toEqual("NO");
});

test("kangaroo sample 2", () => {
    const x1 = 43; v1 = 2; x2 = 70; v2 = 2;
	const result = kangaroo(x1, v1, x2, v2);
    expect(result).toEqual("NO");
});
