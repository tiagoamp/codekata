// https://www.hackerrank.com/challenges/jumping-on-the-clouds/problem

function jumpingOnClouds(c: number[]): number {
    let jumps = 0, index = 0;
    while ( index < (c.length-1) ) {
        index += (index+2 < c.length && c[index+2] == 0) ? 2 : 1;
        jumps++;
    }
    return jumps;
}


test("sample 0", () => {
	const c = [0, 0, 1, 0, 0, 1, 0];
    const expected = 4;
    const result = jumpingOnClouds(c);
	expect(result).toBe(expected);
});

test("sample 1", () => {
	const c = [0, 0, 0, 0, 1, 0];
    const expected = 3;
    const result = jumpingOnClouds(c);
	expect(result).toBe(expected);
});